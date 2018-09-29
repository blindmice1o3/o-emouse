package HeadFirst.DesignPatterns.Ch01StrategyPattern;

/*
    -----     -----     -----
    STRATEGY pattern: defines a family of algorithms (set of behaviors), encapsulates each one, and makes them interchangeable.
        Strategy lets the algorithm vary independently from clients that use it.
    -----     -----     -----

    Duck class started as superclass with methods: quack(), swim(), [abstract] display(), OTHER duck-like methods.
    Duck has subclassses (MallardDuck, RedheadDuck) that inherit the above methods, and provide unique implementation of display().

    Then change from management: ducks should be able to fly().

    Try adding fly() to the superclass (Duck), inheritance provides ALL subclasses of Duck to have fly().
    Problem: not all subclasses of Duck (RubberDuck) can/should fly (yet they'll inherit fly()), also quack() is different (squeak).

    Try overriding both quack() and fly() for RubberDuck.
    Problem: what about DecoyWoodenDuck? Shouldn't fly, but should quack when quack().

    Try overriding just fly() for DecoyWoodenDuck.
    Problem: what about ModelDuck? Shouldn't fly, and no noise (not even squeak) when quack().

    Try overriding both quack() and fly() for ModelDuck too.
    Problem: reuse and maintenance.

    Try creating Interface Quackable, Flyable; have subclasses of Duck decide to implements those interfaces or not.
    Problem: same issue with maintenance (just in a different form); what if implementation for fly() changes for 48 Duck subclasses?
        48 places to change code.

    *****
    Try creating Interface QuackBehavior, FlyBehavior; instead of subclasses of Duck implementing these interfaces, they are compose of
        QuackBehavior quackBehavior, FlyBehavior flyBehavior instance variables to delegate its flying and quacking behavior;
        each subclasses of Duck will have constructor that will set the concrete subclass of QuackBehavior, FlyBehavior interfaces.
    Problem: we're still programming to an implementation in the constructors (making new() instance of concrete Quack implementation class).
    *****

    -----     -----     -----
    STRATEGY pattern: defines a family of algorithms (set of behaviors), encapsulates each one, and makes them interchangeable.
        Strategy lets the algorithm vary independently from clients that use it.
    -----     -----     -----
 */

public class TestClassDuck {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.performQuack();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performFly();
        rubber.performQuack();

        Duck decoywooden = new DecoyWoodenDuck();
        decoywooden.display();
        decoywooden.performFly();
        decoywooden.performQuack();
    }
}
