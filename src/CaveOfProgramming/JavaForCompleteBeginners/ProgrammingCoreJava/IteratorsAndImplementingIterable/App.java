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

        Iterator<String> it = animals.iterator();

        String value = it.next();
        System.out.println(value);

        System.out.println();

        ////// Modern iteration, Java 5 and later

        for (String animal: animals) {
            System.out.println(animal);
        }
    }

}
