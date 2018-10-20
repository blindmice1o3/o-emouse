package HeadFirst.DesignPatterns.Ch03DecoratorPattern.DecoratorOurs;

/*
    -----     -----     -----
    DECORATOR pattern: attaches additional responsibilities to an object dynamically. Decorators provide a flexible
        alternative to subclassing for extending functionality.
    -----     -----     -----

    Starbuzz Coffee begins with an abstract Beverage superclass with instance variable description (is set in each subclass).
    Beverage also has a getDescription() method and an abstract cost() method (each subclass will define its own cost).
    There are 4 concrete subclasses of Beverage (HouseBlend, DarkRoast, Decaf, Espresso).

    -They try adding condiments by just creating (A LOT) more concrete subclasses of Beverage (eg.DarkRoastWithStreamedMilkandWhip).
    -Problem: maintenance nightmare, each of the hundreds of concrete subclass has to calculate its own unique cost!
    -Then they tried adding boolean instance variables for Beverage (eg. milk, soy, mocha, whip), and making cost() not abstract.
        So Beverage's cost() will calculate the cost of the condiments, and the concrete subclasses of Beverage will override
        cost() (invoke the super's version so that they can calculate the total cost of the condiments plus the cost of
        the basic beverage).
    -Problem: Price change for condiment will force us to alter existing code, new condiments will force us to add new methods
        and alter the cost method in the superclass, we may have a new beverage (like iced tea) where the condiments may
        not be appropriate yet the Tea subclass will still inherit methods like hasWhip(), and what if customer wanted double mocha?
    -We've seen that representing our beverage plus condiment pricing scheme with inheritance has not worked out very
        well - we get class explosions, rigid designs, or we add functionality to the base class that isn't appropriate
        for some of the subclasses.


    Decorator Pattern: start with a beverage and "decorate" it with the condiments at runtime (Dark Roast with Mocha and Whip).
    *A hint: think of decorator objects as "wrappers".
    (1) Take a DarkRoast object
    (2) Decorate it with a Mocha object*   // The Mocha object is a decorator, its type mirrors the object it is decorating.
    (3) Decorate it with a Whip object*    // By "mirrors", they mean it is the same type.
    (4) Call the cost() method and rely on DELEGATION to add on the condiment costs
             // We call the cost() method on the outermost decorator, Whip, and Whip is going to delegate computing the
             // cost to the beverage (object) it decorates. Once it gets that cost, it will add on the cost of the Whip.
    -Decorators have the same supertype as the objects they decorate.
    -You can use one or more decorator to wrap an object.
    -Given that the decorator has the same supertype as the object it decorates, we can pass around a decorated (wrapped)
        object in place of the original (non-wrapped) object.
    -***The decorator adds its own behavior either before and/or after delegating to the object it decorates to do the
        rest of the job.***
    -Objects can be decorated at any time, so we can decorate objects dynamically at runtime with as many decorators
        as we like.


    Component: Each component can be used on its own, or wrapped by a decorator.
    ConcreteComponent: The ConcreteComponent is the object we're going to dynamically add new behavior to. It extends Component.
    Decorator: Each decorator HAS-A (wraps a) component, which means the decorator has an instance variable that holds a
        reference to a component. Decorators implement the same interface or abstract class as the component they are
        going to decorate.
    ConcreteDecorator: The ConcreteDecorator has an instance variable for the thing it decorate (the Component). Decorators
        can add new methods; however, ***new behavior is typically added by doing computation before or after an existing
        method in the component***. Decorators can extend the state of the component.


    Inheritance versus Composition:
    -The CondimentDecorator is extending the Beverage class (that's inheritance). However, the point is that it's vital
        that the decorators have the same type as the objects they are going to decorate. So here we're using inheritance
        to achieve the "type matching", but we aren't using inheritance to get "behavior".
    -Okay, I can see how decorators need the same "interface" as the components they wrap because they need to stand in
        place of the component. But where does the behavior come in?
    -When we compose a decorator with a component, we are adding new behavior. We are acquiring new behavior not by
        inheriting it from a superclass, but by composing objects together.
    -Okay, so we're subclassing the abstract class Beverage in order to have the correct type, not to inherit its behavior.
        The behavior comes in through the composition of decorators with the base components as well as other decorators.
    -Because we are using object composition, we get a whole lot more flexibility about how to mix and match. If we rely
        on inheritance, then our behavior can only be determined statically at compile time. In other words, we get only
        whatever behavior the superclass gives us or that we override. With composition, we can mix and match decorators
        any way we like... at runtime.
    -And we can implement new decorators at any time to add new behavior. If we relied on inheritance, we'd have to go
        in and change existing code any time we wanted new behavior.


    *****
    -Java I/O API is... overwhelming. But it should make more sense since the java.io package is largely based on Decorator.
    -InputStream is the abstract component.
    -FileInputStream, StringBufferInputStream, ByteArrayInputStream are concrete components (that we will wrap with decorators).
    -FilterInputStream is the abstract decorator.
    -PushbackInputStream, BufferedInputStream, DataInputStream, LineNumberInputStream are concrete decorators.
    -One of the downsides of the Decorator Pattern: designs using this pattern often result in a large number of small classes
        that can be overwhelming to a developer trying to use the Decorator-based API.
    *****


    -----     -----     -----
    DECORATOR pattern: attaches additional responsibilities to an object dynamically. Decorators provide a flexible
        alternative to subclassing for extending functionality.
    -----     -----     -----
 */



public class TestClassStarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
