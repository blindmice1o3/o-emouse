package HeadFirst.DesignPatterns.Ch10StatePattern;
/*
    -----     -----     -----
    STATE pattern: allows an object to alter its behavior when its internal state changes. The object will appear to
        change its class.
    -----     -----     -----

    -We've been hired by the Mighty Gumball, Inc. to implement their gumball machine controller software. They've given us
        a state diagram of how they want it to work. There are 4 states and 5 transitions.
    -Model state within an object by creating an instance variable to hold the state values and writing conditional code
        within our methods to handle the various states.

    -REQUIREMENT CHANGE: the CEO wants to turn "gumball buying" into a game: 10% of the time, when the crank is turned,
        the customer gets two gumballs instead of one.
    -Adding a WinnerState instance variable isn't bad, but for each method (insertQuarter(), ejectQuarter(), turnCrank(),
        dispense()) we'd have to add a new conditional statement to handle the WinnerState; that's a lot of code to modify.

    -Instead of maintaining the existing code, we're going to rework it to encapsulate state objects in their own classes
        and then delegate to the current state when an action occurs.
        1. First, we're going to define a State interface that contains a method for every action in the Gumball Machine.
        2. Then we're going to implement a State class for every state of the machine. These classes will be responsible
            for the behavior of the machine when it is in the corresponding state.
        3. Finally, we're going to get rid of all of our conditional code and instead delegate to the state class to do
            the work for us.
    -In the GumballMachine, we update the code to use the new classes rather than the static integers. The code is quite
        similar, except that in one class we have integers and in the other objects.
    -What we're doing is implementing the behaviors that are appropriate for the state we're in. In some cases, this
        behavior includes moving the Gumball Machine to a new state.
    -WHAT WE"VE DONE: we have an implementation that is "structurally" quite different from our first version, and yet
        "functionally" it is exactly the same. By "structurally" changing the implementation, we've:
        1. Localized the behavior of each state into its own class.
        2. Removed all the troublesome "if-statements" that would have been difficult to maintain.
        3. Close each state for modification, and yet left the Gumball Machine open to extension by adding new state classes.
        4. Created a base code and class structure that maps much more closely to the Mighty Gumball diagram and is easier
           to read and understand.

    The STATE pattern DEFINED:
        -Because the pattern encapsulates state into separate classes and delegates to the object representing the
            current state, we know that the behavior changes along with the internal state.
        -The Gumball Machine provides a good example: when the gumball machine is in the NoQuarterState and you insert a
            quarter, you get different behavior (the machine accepts the quarter) than if you insert a quarter when it's
            in the HasQuarterState (the machine rejects the quarter).
        -"appear to change its class?" Think about it from the perspective of a client: if an object you're using can
            completely change its behavior, then it appears to you that the object is actually instantiated from another
            class. In reality, however, you know that we are using composition to give the appearance of a class change
            by simply referencing different state objects.
    STATE pattern CLASS DIAGRAM:
        -The Context is the class that can have a number of internal states. In our example, the GumballMachine is the Context.
        -Whenever the request() is made on the Context it is delegated to the state to handle.
        -The State interface defines a common interface for all concrete states; the states all implement the same interface,
            so they are interchangeable.
        -ConcreteStates handle requests from the Context. Each ConcreteState provides it own implementation for a request.
            In this way, when the Context changes state, its behavior will change as well.
    STRATEGY pattern vs STATE pattern:
        -Class diagram are essentially the same, but the two patterns differ in their "intent".
        -Strategy pattern allow objects to incorporate different behaviors or algorithms through composition and delegation.
            State and Strategy seem to relate, but State pattern's intent is different than Strategy. And the way State
            pattern "teach" its clients to use composition and delegation is totally different. In State pattern, when the
            Context objects get created, the starting state is given, but then they change their own state over time. The
            Context objects change state over time according to some well defined state transitions, changing behavior is
            built into the scheme. Strategy pattern does not encourage objects to have a well-defined set of transitions
            between states; in fact, it like to control what strategy its objects are using.
        -State pattern - we have a set of behaviors encapsulated in state objects; at any time the context is delegating
            to one of those states. Over time, the current state changes across the set of state objects to reflect the
            internal state of the context, so the context's behavior changes over time as well. The client usually knows
            very little, if anything, about the state objects.
        -Strategy pattern - the client usually specifies the strategy object that the context is composed with. Now,
            while the pattern provides the flexibility to change the strategy object at runtime, often there is a
            strategy object that is most appropriate for a context object. For instance, in Chapter 1, some of our ducks
            were configured to fly with typical flying behavior (like mallard ducks), while others were configured with a
            fly behavior that kept them grounded (like rubber ducks and decoy ducks).
        -Think of the Strategy pattern as a flexible alternative to subclassing; if you use inheritance to
            define the behavior of a class, then you're stuck with that behavior even if you need to change it. With
            Strategy you can change the behavior by composing with a different object.
        -Think of the State pattern as an alternative to putting lots of conditionals in your context; by encapsulating
            the behaviors within state objects, you can simply change the state object in context to change its behavior.

    We've got one more change to make: we need to implement the random chance game and add a transition to the WinnerState.
        We're going to add both to the HasQuarterState since that is where the customer turns the crank.

    Q. Why do we need the WinnerState? Couldn't we just have the SoldState dispense two gumballs?
    A. SoldState and WinnerState are almost identical, except that WinnerState dispenses two gumballs instead of one. You
       certainly could put the code to dispense two gumballs into the SoldState. The downside is, of course, that now you've
       got TWO states represented in one State class: the state in which you're a winner, and the state in which you're
       not. So you are sacrificing clarity in your State class to reduce code duplication. Another thing to consider is
       the principle you learned in the previous chapter: One class, One responsibility. By putting the WinnerState
       responsibility into the SoldState, you've just given the SoldState TWO responsibilities. What happens when the
       promotion ends? Or the stakes of the contest change? So, it's a tradeoff and comes down to a design decision.

    THINGS WE CAN FURTHER DO / THINGS TO CONSIDER:
        1. We've got a lot of duplicate code in the Sold and Winning states and we might want to clean those up. How would
            we do it? We could make State into an abstract class and build in some default behavior for the methods; after
            all, error messages like, "You already inserted a quarter," aren't going to be seen by the customer. So all
            "error response" behavior could be generic and inherited from the abstract State class.
        2. The dispense() method always gets called, even if the crank is turned when there is no quarter. While the machine
            operates correctly and doesn't dispense unless it's in the right state, we could easily fix this by having
            turnCrank() return a boolean, or by introducing exceptions. Which do you think is a better solution?
        3. All the intelligence for the state transitions is in the State classes. What problems might this cause? Would
            we want to  move that logic into the Gumball Machine? What would be the advantages and disadvantages of that?
        4. Will you be instantiating a lot of GumballMachine objects? If so, you may want to move the state instances into
            static instance variables and share them. What changes would this require to the GumballMachine and the States?

    -----     -----     -----
    STATE pattern: allows an object to alter its behavior when its internal state changes. The object will appear to
        change its class.
    -----     -----     -----
*/
public class TestClassGumballMachine {
    public static void main(String[] args) {

        // Load it up with five gumballs total.
        GumballMachine gumballMachine = new GumballMachine(5);

        // Print out the state of the machine.
        System.out.println(gumballMachine);

        // Throw a quarter in...
        gumballMachine.insertQuarter();
        // Turn the crank; we should get our gumball.
        gumballMachine.turnCrank();

        // Print out the state of the machine, again.
        System.out.println(gumballMachine);

        // Throw a quarter in...
        gumballMachine.insertQuarter();
        // Ask for it back.
        gumballMachine.ejectQuarter();
        // Turn the crank; we shouldn't get our gumball.
        gumballMachine.turnCrank();

        // Print out the state of the machine, again.
        System.out.println(gumballMachine);

        // Throw a quarter in...
        gumballMachine.insertQuarter();
        // Turn the crank; we should get our gumball.
        gumballMachine.turnCrank();
        // Throw a quarter in...
        gumballMachine.insertQuarter();
        // Turn the crank; we should get our gumball.
        gumballMachine.turnCrank();
        // Ask for a quarter back we didn't put in.
        gumballMachine.ejectQuarter();

        // Print out the state of the machine, again.
        System.out.println(gumballMachine);

        // Throw TWO quarter in...
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        // Turn the crank; we should get our gumball.
        gumballMachine.turnCrank();
        // Now for the stress testing...
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        // Print that machine state one more time.
        System.out.println(gumballMachine);

    }
}
