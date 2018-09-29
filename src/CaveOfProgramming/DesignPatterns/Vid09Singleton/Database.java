package CaveOfProgramming.DesignPatterns.Vid09Singleton;

public class Database {

    // If we want to have ONLY ONE instance of a class (singleton - design pattern)...
    //      we can create a static method that returns the one instance (so other classes won't
    //      be able to create/access it OTHER THAN one at a time

    // We'll need a private static variable of the class INSIDE OF the class itself (here we're naming it "instance")
    //      (a Database object in the Database class)

    private static Database instance = new Database();

    // Java can have "private" constructors
    private Database() {

    }

    // A static method that returns our static class variable
    public static Database getInstance() {
        return instance;
    }



    // There is another way of doing this (singleton - design pattern), which has fallen out of favor
    // This is called "lazy instantiation" (call this because it doesn't happen until the last possible moment;
    //      until someone calls getInstanceOld() there's no instantiation (no instance of your Database class).
    private static Database instanceOld;

    private static Database getInstanceOld() {
        if (instanceOld == null) {
            instanceOld = new Database();
        }

        return instanceOld;
    }
    // Sometimes this is good, like when you don't want your class to be constructed when your program starts; like it
    //      may take too long (you want to speed up the start of your program)... so you can defer creation of it
    //      (if it's a massive object or something) until the getInstanceOld() method is called.

    // The disadvantage of this old way is that it is NOT thread safe.
}
