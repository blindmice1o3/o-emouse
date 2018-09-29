package HeadFirst.DesignPatterns.Ch04FactoryPattern;

/*
    -----     -----     -----
    FACTORY METHOD pattern: define an interface for creating an object, but let subclasses decide which class to
        instantiate. Factory Method lets a class defer instantiation to the subclasses.
    -----     -----     -----

    -----     -----     -----
    ABSTRACT FACTORY pattern: provide an interface for creating families of related or dependent objects without
        specifying their concrete classes.
    -----     -----     -----

    Chapter 4 starts off with PizzaStore that has implementation code for selecting which Pizza type to instantiate.

    *** The Simple Factory (not official design pattern, but Honorable Mention!) ***
    Later, we encapsulated out lines of if/else code that matched a String it's passed in ("cheese", "pepperoni", "veggie",
        etc.) to the corresponding instantiation code (new cheesePizza(), new pepperoniPizza(), new veggiePizza(), etc.).
        This was moved into its own class called the SimplePizzaFactory (who's sole responsibility is to instantiate Pizza
        objects). Then the PizzaStore had a reference to the SimplePizzaFactory object and delegated pizza creation to
        simplePizzaFactory's createPizza(String pizzaType) method.

    Next, we moved the SimplePizzaFactory's call to createPizza() back to the PizzaStore class itself (the PizzaStore class
        has AN ABSTRACT METHOD called createPizza(); now we'll need subclasses of PizzaStore [NYPizzaStore, ChicagoPizzaStore]
        to implement the if/else code for instantiating new Pizza objects).

    "With just a couple of transformations to the PizzaStore we've gone from having an object handle the instantiation of
        our concrete classes to a set of subclasses that are now taking on that responsibility."
    "All the responsibility for instantiating Pizzas has moved into a method that acts as a factory."


    CODE UP CLOSE:
        A factory method handles object creation and encapsulates it in a subclass. This decouples the client code in the
        superclass from the object creation code in the subclass.

            abstract Product factoryMethod(String type)

        -A factory method is abstract so the subclasses are counted on to handle object creation.
        -A factory method returns a Product that is typically used within methods defined in the superclass.
        -A factory method isolates the client (the code in the superclass, like orderPizza()) from knowing what kind of
            concrete Product is actually created.
        -A factory method may be parameterized (or not) to select among several variations of a product.


    FACTORY METHOD pattern encapsulates object creation by letting subclasses decide what objects to create.

    Abstract PRODUCT class (Pizza)                  and         Abstract CREATOR class (PizzaStore)
    Concrete PRODUCT classes (NYStyleCheesePizza)   and         Concrete CREATOR classes (NYPizzaStore)
        The factory method pattern provides a framework:
            -by supplying an orderPizza() method that is combined with a factory method (createPizza()).
            -in the way it encapsulates product knowledge into each creator.


    Difference between Simple Factory and Factory Method:
    -Think of Simple Factory as a one shot deal, which with Factory Method you are creating a framework that let's the
        subclasses decide which implementation will be used.
    -The Simple Factory gives you a way to encapsulate object creation, but doesn't give you the flexibility of the
        Factory Method because there is no way to vary the products you're creating.

    "By placing all my creation code in one object or method, I avoid duplication in my code and provide one place to
        perform maintenance. That also means clients depend only upon interfaces rather than the concrete classes
        required to instantiate objects."
    "By encapsulating object creation I am coding to abstractions and decoupling my client code from actual implementations."


    DEPENDENCY INVERSION PRINCIPLE: Depend upon abstractions. Do not depend upon concrete classes.
    "It sounds like "Program to an interface, not an implementation," however, the Dependency Inversion Principle makes
        an even stronger statement about abstraction. It suggests that our high-level components should not depend
        on our low-level components; rather, they should BOTH depend on abstractions."
    Guidelines to help you follow the Dependency Inversion Principle:
        -No variable should hold a reference to a concrete class.
        -No class should derive from a concrete class.
        -No method should override an implemented method of any of its base classes.


    PizzaStoreFranchise now wants to ensure consistency in quality of ingredients across their stores (some stores were
        starting to use inferior ingredients to lower costs and increase their profit margins, so we're going to have
        ingredients made in-house in our PizzaIngredientFactory (interface); regional ingredient factories
        (NYPizzaIngredientFactory) will implements this interface.



    -----     -----     -----
    FACTORY METHOD pattern: define an interface for creating an object, but let subclasses decide which class to
        instantiate. Factory Method lets a class defer instantiation to the subclasses.
    -----     -----     -----

    -----     -----     -----
    ABSTRACT FACTORY pattern: provide an interface for creating families of related or dependent objects without
        specifying their concrete classes.
    -----     -----     -----
 */

public class TestClassPizza {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
