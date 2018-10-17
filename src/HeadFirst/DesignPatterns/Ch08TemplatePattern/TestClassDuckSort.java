package HeadFirst.DesignPatterns.Ch08TemplatePattern;

import java.util.Arrays;

public class TestClassDuckSort {
    public static void main(String[] args) {
        // We need an array of Ducks.
        Duck[]  ducks = {
                            new Duck("Daffy", 8),
                            new Duck("Dewey", 2),
                            new Duck("Howard", 7),
                            new Duck("Louie", 2),
                            new Duck("Donald", 10),
                            new Duck("Huey", 2)
        };

        // Let's print them to see their names and weights.
        System.out.println("Before sorting:");
        display(ducks);

        // Notice that we call Arrays' static method sort, and pass it our Ducks.
        Arrays.sort(ducks);

        // Let's print them (again) to see their names and weights.
        System.out.println("\nAfter sorting:");
        display(ducks);
    }

    public static void display(Duck[] ducks) {
        for (int i = 0; i < ducks.length; i++) {
            System.out.println(ducks[i]);
        }
    }
}
