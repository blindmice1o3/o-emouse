package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericsUsingGenerics {

    public static void main(String[]args) {
        ////////////// Before Java 5 //////////////////////////////////////////////////////////////////////////////////
        ArrayList list = new ArrayList();   // A collection that's like an expandable array that holds Object.

        // What we put into the ArrayList are String objects.
        list.add("apple");
        list.add("banana");
        list.add("orange");
        // What we get back from the ArrayList are Object objects.
        // Error because get() method returns a type Object... need to downcast that Object back into a String.
        String fruit = (String)list.get(1);
        System.out.println(fruit);


        ////////////// Modern style ///////////////////////////////////////////////////////////////////////////////////
        ArrayList<String> strings = new ArrayList<String>();    // Type parameter specify the type of object it holds.

        // What we put into the ArrayList are String objects.
        strings.add("cat");
        strings.add("dog");
        strings.add("alligator");
        // What we get back from the ArrayList are String objects!!!
        // No need to cast it back into what it was before going into the ArrayList collection object.
        String animal = strings.get(1);
        System.out.println(animal);


        /////////////// There can be more than one type argument (separate them with a comma) /////////////////////////
        HashMap<Integer, String> map = new HashMap<Integer, String>();


        /////////////// Java 7 style //////////////////////////////////////////////////////////////////////////////////
        ArrayList<String> someList = new ArrayList<>();     // No longer need to repeat the type parameter list the 2nd time.
    }
}