package HeadFirst.DesignPatterns.Ch07AdapterPattern;

/*
    -----     -----     -----
    ADAPTER pattern: converts the interface of a class into another interface the clients expect. Adapter lets classes
        work together that couldn't otherwise because of incompatible interfaces.
    -----     -----     -----

    -----     -----     -----
    FACADE pattern: provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level
        interface that makes the subsystem easier to use.
    -----     -----     -----

    Ex. real world adapter (US-made laptop in a European country)
        -European Wall Outlet: the European wall outlet exposes one interface for getting power
        -AC Power Adapter: the adapter converts one interface into another
        -Standard AC Plug (your laptop): the US laptop expects another interface

    Ex. object oriented adapters
        -New vendor class library with an interface designed differently than your last vendor: no code changes
        -OO adapter: new code
        -Existing software system: no code changes
    You don't want to solve the problem by changing your existing code (and you can't change the vendor's code). Well,
    you can write a class that adapts the new vendor interface into the one you're expecting.
        -The adapter implements the interface your classes expect.
        -And talks to the vendor interface to service your requests.
    The adapter acts as the middleman by receiving requests from the client and converting them into requests that make
    sense on the vendor classes.

    First Adapter pattern example: We ran out of Ducks, quick use these Turkeys instead (here's some TurkeyAdapters too!)

    ***** CODE UP CLOSE ***** -------> See TurkeyAdapter class

    The Adapter Pattern explained (note that the Client and Adaptee are decoupled - neither knows about the other.)
        // I need more Ducks! Just send in the Turkeys wearing TurkeyAdapters, ASAP!!
        -Client: The Client is implemented against the target interface.
        // TurkeyAdapter implemented the target interface, Duck.
        -Adapter: The Adapter implements the target interface and holds an instance of the Adaptee.
        // Turkey was the adaptee interface
        -Adaptee: The Adaptee is the object that is delegated to when a method of the target interface is invoked.
    Here's how the Client uses the Adapter
        (1) The client makes a request to the adapter by calling a method on it using the target interface.
        (2) The adapter translate the request into one or more calls on the adaptee using the adaptee interface.
        (3) The client receives the results of the call and never knows there is an adapter doing the translation.
    Now, we know this pattern allows us to use a client with an incompatible interface by creating an Adapter that does
    the conversion. This acts to decouple the client from the implemented interface, and if we expect the interface to
    change over time, the adapter encapsulates that change so that the client doesn't have to be modified each time it
    needs to operate against a different interface.


    *** Object and class adapters ***
    -Class adapter need multiple inheritance to implement it, which isn't possible in Java.
    -We've only talked about object adapters and the class diagram we saw is a diagram of an object adapter (composition).
    -Class adapter uses a different mean of adapting the Adaptee, inheritance. Instead of using composition to adapt
        the Adaptee, the Adapter now subclasses both the Adaptee and the Target classes.
    -With class adapter we subclass the Target and the Adaptee, while with object adapter we use composition to pass
        requests to an Adaptee (which can not only adapt an Adaptee class, but any of its subclasses).


    Ex. real world adapters (Old world Enumerators, New world Iterators, And today...)
        -Previous version of Java had collections types (Vector, Stack, Hashtable, etc) implement a method called
            elements(), which returns an Enumeration.
        -More recent Collections classes began using an Iterator interface, like Enumeration, allows you to iterate
            through a set of items in a collection, but also adds the ability to remove items.
        -Today, we are often faced with legacy (older code) code that exposes the Enumerator interface, yet we'd like for
            our new code to use only Iterators. We need to build an adapter.

            Target interface        Adapter                         Adaptee interface
            (Iterator)              (EnumerationIterator)           (Enumeration)
            hasNext()               hasNext()                       hasMoreElements()
            next()                  next()                          nextElement()
            remove()                remove()                        (will "throw new UnsupportedOperationException()")
        -See EnumerationIterator class


    Decorator vs Adapter:
        -Decorator wraps an object to add new behaviors and responsibilities.
        -Adapter wraps an object to change its interface.
        -Facade "wraps" a set of objects to simplify.  // composes a subsystem



    Facade Pattern hides all the complexity of one or more classes behind a clean, well-lit facade.

    Ex. Home theater system (Amplifier, Tuner, CdPlayer, Screen, TheaterLights, PopcornPopper, Projector, DvdPlayer)
        -Each class in our home theater system has their own set of methods (some even have states), big set of interfaces
            to learn and use.
        -A Facade class can take a complex subsystem and make it easier to use by providing "one" (more reasonable) interface.
        -All the power of the complex subsystem (low-level access) is still there for you to use if you need the advanced
            functionality of the subsystem classes, but now we'll also have one straightforward interface.
        -See HomeTheaterFacade class.

    To use the Facade Pattern, we create a class that simplifies and unifies a set of more complex classes that belong
        to our subsystem.
    A facade not only simplifies an interface, it decouples a client from a subsystem of components.
    Facades and adapters may wrap multiple classes, but a facade's intent is to simplify, while an adapter's is to convert
        the interface to something different.


    The Principle of Least Knowledge - talk only to your immediate friends.
        -When you are designing a system, for any object, be careful of the number of classes it interacts with and also
            how it comes to interact with those classes.
        -This principle prevents us from creating designs that have a large number of classes coupled together so that
            changes in one part of the system cascade to other parts. When you build a lot of dependencies between many
            classes, you are building a fragile system that will be costly to maintain and complex for others to understand.
        -See Car class.

    *Notice that these guidelines tell us ***not*** to call methods on objects that were returned from calling other methods!!!
    Guidelines (take any object; now from any method in that object, the principle tells us that we should only invoke
    methods that belong to):
        -the object itself
        -objects passed in as a parameter to the method
        -any object the method creates or instantiates
        -any components of the object (think of "component" as any object that is referenced by an instance variable)

    -----     -----     -----
    ADAPTER pattern: converts the interface of a class into another interface the clients expect. Adapter lets classes
        work together that couldn't otherwise because of incompatible interfaces.
    -----     -----     -----

    -----     -----     -----
    FACADE pattern: provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level
        interface that makes the subsystem easier to use.
    -----     -----     -----
*/

public class TestClassAdapterAndFacade {
    // Testing the TurkeyAdapter
    public static void main(String[] args) {
        // Let's create a Duck and a Turkey...
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        // And then wrap the turkey in a TurkeyAdapter, which makes it look like a Duck.
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        // Then, let's test the Turkey: make it gobble, make it fly.
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        // Now, let's test the duck by calling the testDuck() method, which expects a Duck object.
        System.out.println("\nThe Duck says...");
        testDuck(duck);

        // NOW the big test: we try to pass off the turkey as a duck...
        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);

        // Some comments after the test runs...
        System.out.println("The Turkey gobbles and flies a short distance. The Duck quacks and flies just like you'd " +
                "expect. And the adapter gobbles when quack() is called and flies a few times when fly() is called. The " +
                "testDuck() method never knows it has a turkey disguised as a duck!");
    }
    // Here's our testDuck() method; it gets a duck and calls its quack() and fly() methods.
    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
