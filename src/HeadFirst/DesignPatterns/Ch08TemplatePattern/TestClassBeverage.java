package HeadFirst.DesignPatterns.Ch08TemplatePattern;

/*
    -----     -----     -----
    TEMPLATE METHOD pattern: defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
        Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
    -----     -----     -----

    -Started with Coffee class and Tea class that had very similar methods.
    -Both coffee and tea follow the same algorithm for their recipe. We can abstract the algorithm (the template),
        a method with a structure or set of steps, to a common superclass (base class), CaffeineBeverage.
    -So next, we abstract prepareRecipe() from each subclass by generalizing step 2 and step 4, they will be abstract and
        each concrete subclass (Coffee and Tea) will provide their specific implementations of brew() and addCondiments():
        (1) Boil some water.                                --->    (1) boilWater();
        (2) Use the hot water to extract the coffee or tea. --->    (2) brew();
        (3) Pour the resulting beverage into a cup.         --->    (3) pourInCup();
        (4) Add the appropriate condiments to the beverage. --->    (4) addCondiments();
    -See CaffeineBeverageWithHook class.

    This pattern is all about creating a template for an algorithm. What's a template? As you've seen it's just a method;
        more specifically, it's a method that defines an algorithm as a set of steps. One or more of these steps is defined
        to be abstract and implemented by a subclass. This ensures the algorithm's structure stays unchanged, while subclasses
        provide some part of the implementation.


    CODE UP CLOSE:
        // Here we have our abstract class; it is declared abstract and meant to be subclassed by classes that provide
        // implementations of the operations. Now we're adding another method called "hook()"
        abstract class AbstractClass {
            // Here's the template method. It's declared final to prevent subclasses from reworking the sequence of steps
            // in the algorithm.
            final void templateMethod() {
                // The template method define the sequence of steps, each represented by a method.
                primitiveOperation1();
                primitiveOperation2();
                concreteOperation();
                // We've changed the templateMethod() to include a new method call, hook().
                hook();
            }

            // We still have our primitive methods; these are abstract and implemented by concrete subclasses.
            abstract void primitiveOperation1();
            abstract void primitiveOperation2();

            // A concrete operation is defined in the abstract class. This one is declared final so that subclasses can't
            // override it. It may be used in the template method directly, or used by subclasses.
            final void concreteOperation() {
                // implementation here
            }

            // We can also have concrete methods that do nothing by default; we call these "hooks." Subclasses are free
            // to override these but don't have to.
            void hook() {}
        }

    A hook is a method that is declared in the abstract class, but only given an empty or default implementation. This
    gives subclasses the ability to "hook into" the algorithm at various points, if they wish; a subclass is also free
    to ignore the hook.


    Q. When I'm creating a template method, how do I know when to use abstract methods and when to use hooks?
    A. Use abstract methods when your subclass MUST provide an implementation of the method or step in the algorithm.
    Use hooks when that part of the algorithm is optional. With hooks, a subclass may choose to implement that hook, but
    it doesn't have to.

    Q. What are hooks really supposed to be used for?
    A. There are a few uses of hooks. As we just said, a hook may provide a way for a subclass to implement an optional
    part of an algorithm, or if it isn't important to the subclass's implementation, it can skip it.

    Another use is to give the subclass a chance to react to some step in the template method that is about to happen,
    or just happened. For instance, a hook method like justReOrderedList() allows the subclass to perform some activity
    (such as redisplaying an onscreen representation) after an internal list is reordered.

    As you've seen a hook can also provide a subclass with the ability to make a decision for the abstract class.


    The Hollywood Principle (Design Principle): Don't call us, we'll call you.
        -Gives us a way to prevent "dependency rot." Dependency rot happens when you have high-level components depending
            on low-level components depending on high-level components depending on sideways components depending on low-
            level components, and so on. When rot sets in, no one can easily understand the way a system is designed.
        -With the Hollywood Principle, we allow low-level components to hook themselves into a system, but the high-level
            components determine when they are needed, and how. In other words, the high-level components give the low-level
            components a "don't call us, we'll call you" treatment.

    The Hollywood Principle and Template Method:
        -The connection between the Hollywood Principle and the Template Method Pattern is we're telling subclasses, "don't
            call us, we'll call you."
        -CaffeineBeverageWithHook is our high-level component. It has control over the algorithm for the recipe, and calls
            on the subclasses only when they're needed for an implementation of a method.
        -Clients of beverages will depend on the CaffeineBeverageWithHook abstraction rather than a concrete Tea or Coffee,
            which reduces dependencies in the overall system.
        -CoffeeWithHook and TeaWithHook never call the abstract class directly without being "called" first


    Q. How does the Hollywood Principle relate to the Dependency Inversion Principle that we learned a few chapters back?
    A. The Dependency Inversion Principle teaches us to avoid the use of concrete classes and instead work as much as
    possible with abstractions. The Hollywood Principle is a technique for building frameworks or components so that lower-
    level components can be hooked into the computation, but without creating dependencies between the lower-level
    components and the higher-level layers. So, they both have the goal of decoupling, but the Dependency Inversion
    Principle makes a much stronger and general statement about how to avoid dependencies in design. The Hollywood
    Principle gives us a technique for creating designs that allow low-level structures to inter-operate while preventing
    other classes from becoming too dependent on them.


    TEMPLATE METHODS IN THE WILD (Java API):
        Sorting with Template Method
        // We actually have two methods here and they act together to provide the sort functionality.

        // The first method, sort(), is just a helper method that creates a copy of the array and passes it along as the
        // destination array to the mergeSort() method. It also passes along the length of the array and tells the sort
        // to start at the first element.
        public static void sort(Object[] a) {
            Object aux[] = (Object[])a.clone();
            mergeSort(aux, a, 0, a.length, 0);
        }
        // The mergeSort() method contains the sort algorithm, and relies on an implementation of the compareTo() method
        // to complete the algorithm.

        // Think of this as the template method.
        private static void mergeSort(Object src[], Object des[], int low, int high, int off) {
            for (int i = low; i < high; i++) {
                for (int j = i; j > low &&
                    ((Comparable)des[j-1]).compareTo((Comparable)des[j]) > 0; j--) {
                    // compareTo() is the method we need to implement to "fill out" the template method.
                    // This is a concrete method, already defined in the Arrays class.
                    swap(dest, j, j-1);
                }
            }
            return;
        }

    Let's say you have an array of ducks that you'd like to sort. The sort template method in Arrays gives us the
    algorithm, but you need to tell it how to compare ducks, which you do by implementing the compareTo() method...

        // Aren't we suppose to be subclassing something??? Good point. Here's the deal: the designers of sort() wanted
        // it to be useful across all arrays, so they had to make sort() a static method that could be used from anywhere.
        // But that's okay, it works almost the same as if it were in a superclass. Now, here is one more detail: because
        // sort() really isn't defined in our superclass, the sort() method needs to know that you've implemented the
        // compareTo() method, or else you don't have the piece needed to complete the sort algorithm.
        // To handle this, the designers made use of the Comparable interface. All you have to do is implement this interface,
        // which has one method (surprise): compareTo().

    Q. What is compareTo()?
    A. The compareTo() method compares two objects and returns whether one is less than, greater than, or equal to
    the other. sort() uses this as the basis of its comparison of objects in the array.

    -See Duck and TestClassDuckSort classes.

    -Another template method "in the wild": java.io has a read() method in InputStream that subclasses must implement
        and is used by the template method read(byte b[], int off, int len).
    -Another template method "in the wild": java.Swing has JFrame that inherits a paint() method. By default, paint() does
        nothing because it's a hook! By overriding paint(), you can insert yourself into JFrame's algorithm for displaying
        its area of the screen and have your own graphic output incorporated into the JFrame.
        -See MyFrame class.
    -Another template method "in the wild": java.Applet has several hooks that subclasses of Applet can use.
        -See MyApplet class.

    The Strategy and Template Method Patterns both encapsulate algorithms, one by inheritance and one by composition.
    The Factory Method is a specialization of Template Method.

    -----     -----     -----
    TEMPLATE METHOD pattern: defines the skeleton of an algorithm in an operation, deferring some steps to subclasses.
        Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
    -----     -----     -----
*/

public class TestClassBeverage {
    public static void main(String[] args) {

        TeaWithHook teaHook = new TeaWithHook();
        CoffeeWithHook coffeeHook = new CoffeeWithHook();

        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffeeHook.prepareRecipe();
    }
}
