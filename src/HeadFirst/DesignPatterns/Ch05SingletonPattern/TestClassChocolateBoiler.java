package HeadFirst.DesignPatterns.Ch05SingletonPattern;

/*
    -----     -----     -----
    SINGLETON pattern: ensures a class has only one instance, and provides a global point of access to it.
    -----     -----     -----

    -Some classes should only be instantiated once (e.g. thread pools, caches, dialog boxes, objects that handle
        preferences and registry settings, objects used for logging, and objects that act as device drivers to devices
        like printers and graphics cards.

    Q. Why use Singleton pattern instead of "instantiation-once" by convention or instead of using a global variable?
    A. In many ways, it is a convention (for ensuring one and only one object is instantiated for a given class). The
        Singleton pattern also gives us a global point of access, just like a global variable, but without the downsides
        (global variable, the object might be created when the application begins... what if the application never ends
        up using it? With Singleton pattern, we can create our objects only when they are needed.
    Q. How do I prevent more than one object from being instantiated?
    A. A constructor (the thing that's called when you use the "new" keyword) that's set as PRIVATE.
    Q. What object can use the private constructor?
    A. The code in the class itself is the only code that can call it. We can have our class contain a static method like:
        MyClass.getInstance();

            public MyClass {

                public static MyClass getInstance() {
                }
            }


    The classic Singleton Pattern implementation:
            // Let's rename MyClass to Singleton.
            public class Singleton {
                // We have a static variable to hold our one instance of the class Singleton.
                private static Singleton uniqueInstance;

                // other useful instance variable here

                // Our constructor is declared private; only Singleton can instantiate this class!
                private Singleton() {}

                // The getInstance() method gives us a way to instantiate the class and also to return an instance of it.
                public static Singleton getInstance() {
                    if (uniqueInstance == null) {
                        uniqueInstance = new Singleton();
                    }
                    return uniqueInstance;
                }

                // Of course Singleton is a normal class; it has other useful instance variables and methods.
                // other useful methods here
            }
       CODE UP CLOSE:
                    if (uniqueInstance == null) {
                        uniqueInstance = new MyClass();
                    }
                    return uniqueInstance;
        -uniqueInstance holds our ONE instance; remember, it is a static variable.
        -If uniqueInstance is null, then we haven't created the instance yet...
        -... and, if it doesn't exist, we instantiate Singleton through its private constructor and assign it to
            uniqueInstance. Note that if we never need the instance, it never gets created; this is lazy instantiation.
        -If uniqueInstance wasn't null, then it was previously created. We just fall through to the return statement.
        -By the time we hit this code, we have an instance and we return it.

    -"To get hold of a Singleton object, you don't instantiate one, you just ask for an instance."
    -"We're taking a class and letting it manage a single instance of itself. We're also preventing any other class from
        creating a new instance on its own. To get an instance, you've got to go through the class itself."
    -"We're also providing a global access point to the instance: whenever you need an instance, just query the class
        and it will hand you back the single instance. As you've seen, we can implement this so that the Singleton is
        created in a lazy manner, which is especially important for resource intensive objects."
    -"A class implementing the Singleton pattern is more than a Singleton; it is a general purpose class with its own set
        of data and methods."


    Dealing with multithreading:
        (1) Synchronize the getInstance() method
        -A straight forward technique that is guaranteed to work. We don't seem to have any performance concerns with the
            chocolate boiler, so this would be a good choice.

        (2) Use eager instantiation
        -We are always going to instantiate the chocolate boiler in our code, so statically initializing the instance would
            cause no concerns. This solution would work as well as the synchronized method, although perhaps be less obvious
            to a developer familiar with the standard pattern.

        (3) Double-checked locking
        -Given we have no performance concerns, double-checked locking seems like overkill. In addition, we'd have to ensure
            that we are running at least Java 5.

    (1)
    public class Singleton {

    // other useful instance variables here

    private Singleton() {}

    // By adding the synchronized keyword to getInstance(), we force every thread to wait its turn before it can enter
    // the method. That is, no two threads may enter the method at the same time.
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    (2)
    public class Singleton {
    // Go ahead and create an instance of Singleton in a static initializer. This code is guaranteed to be thread safe!
        private static Singleton uniqueInstance = new Singleton();

        private Singleton() {}

        public static Singleton getInstance() {
            // We've already got an instance, so just return it
            return uniqueInstance;
        }
    }

    (3)
    public class Singleton {
    // With double-checked locking, we first check to see if an instance is created, and if not, THEN we synchronize. This
    // way, we only synchronize the first time through, just what we want.
        // The volatile keyword ensures that multiple threads handle the uniqueInstance variable correctly when it is
        // being initialized to the Singleton instance.
        private volatile static Singleton uniqueInstance;

        private Singleton() {}

        // Check for an instance and if there isn't one, enter a synchronized block.
        // Note we only synchronize the first time through!
        public static Singleton getInstance() {
            if (uniqueInstance == null) {
                synchronized (Singleton.class) {
                    // Once in the block, check again and if still null, create an instance.
                    if (uniqueInstance == null) {
                        uniqueInstance = new Singleton();
                    }
                }
            }
            return uniqueInstance;
        }
    }

    -----     -----     -----
    SINGLETON pattern: ensures a class has only one instance, and provides a global point of access to it.
    -----     -----     -----
 */

public class TestClassChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    // A uniqueInstance class [static] variable holds our one and only one instance of Singleton
    private static TestClassChocolateBoiler uniqueInstance;

    // The constructor is private, only code inside this class can use it.
    private TestClassChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    // The getInstance() method is static, which means it's a class method, so you can conveniently access this method
    // from anywhere in your code using Singleton.getInstance(). That's just as easy as accessing a global variable, but
    // we get the benefits like lazy instantiation from the Singleton.
    public static TestClassChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TestClassChocolateBoiler();
        }
        return uniqueInstance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // fill the boiler with a milk/chocolate mixture
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
