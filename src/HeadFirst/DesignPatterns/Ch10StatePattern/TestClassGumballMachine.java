package HeadFirst.DesignPatterns.Ch10StatePattern;
/*
    -----     -----     -----
    STATE pattern: allows an object to alter its behavior when its internal state changes. The object will appear to
        change its class.
    -----     -----     -----

    -We've been hired by the Mighty Gumball, Inc. to implement their gumball machine controller software. They've given us
        a state diagram of how they want it to work. There are 4 states and 5 transitions.
    -Model state within an object by creating an instance variable to hold the state values and writing conditional code
        within our methods to handle type various states.
    -CHANGE: the CEO wants to turn "gumball buying" into a game: 10% of the time, when the crank is turned, the customer
        gets two gumballs instead of one.

    -Instead of maintaining the existing code, we're going to rework it to encapsulate state objects in their own classes
        and then delegate to the current state when an action occurs.
        1. First, we're going to define a State interface that contains a method for every action in the Gumball Machine.
        2. Then we're going to implement a State class for every state of the machine. These classes will be responsible
            for the behavior of the machine when it is in the corresponding state.
        3. Finally, we're going to get rid of all of our conditional code and instead delegate to the state class to do
            the work for us.


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
