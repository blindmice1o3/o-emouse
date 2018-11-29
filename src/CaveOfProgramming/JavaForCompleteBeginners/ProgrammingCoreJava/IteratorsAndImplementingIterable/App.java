package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.IteratorsAndImplementingIterable;

import java.util.Iterator;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        System.out.println("Running \"Iterators and Implementing Iterable\"...");
        LinkedList<String> animals = new LinkedList<String>();

        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");

        // Before Java 5, we get an iterator from our LinkedList (which implements Iterable interface) (most collection do)
        // by calling its iterator() method.                                // hasNext() - returns true if there's a next element
        Iterator<String> it = animals.iterator();                           // next() - returns the next element and moves the iterator
        // An Iterator has methods: hasNext(), next(), and remove().        // remove() - removes the last element returned by the iterator

        // The value of using an iterator can be seen in the following while loop. An iterator is external of the collection
        // and can remove elements while iterating through it without the concurrency problem if you try to manipulate a
        // collection type while its looping through its elements (like if you try to remove or add to it).
                // ConcurrentModificationException if try to remove() using a for-each loop.
                // (trying to modify the collection while concurrently iterating through it.)
                // for-each uses iterators behind-the-scene (if our class implements Iterable, we can then use for-each
                // loop with our class type).
        // There's something called a ListIterator that allows you to add() items to your list as your iterator through
        // (and a previous() method, opposite of next()).
        while(it.hasNext()) {
            String value = it.next();
            System.out.println(value);

            if (value.equals("cat")) {
                it.remove();
            }
        }
        System.out.println();

        ////// Modern iteration, Java 5 and later
                // This for-each loop is using iterator (with the while loop and calling hasNext()) behind-the-scene.
        for (String animal: animals) {
            System.out.println(animal);
        }
    }
}
