package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    ArrayList menus;
    /*
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;
    */

    // In the constructor the Waitress takes the two menus
    // The Cafe menu is passed into the Waitress in the constructor with the other menus, and we stash it in an instance variable.
    // We refactored the Waitress to use an ArrayList to store multiple menus.
    public Waitress(ArrayList menus) {
        this.menus = menus;
        /*
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
        */
    }

    // The printMenu() method now creates two iterators, one for each menu.
    public void printMenu() {
        Iterator menuIterator = menus.iterator();
        while(menuIterator.hasNext()) {
            Menu menu = (Menu)menuIterator.next();
            System.out.println(menu.getName());
            printMenu(menu.createIterator());
            System.out.println("\n");
        }

        /* We're changing the implementation to use an ArrayList to store all 3 menus.
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        // We're using the Cafe's menu for our dinner menu. All we have to do to print it is create the iterator, and
        // pass it to printMenu(). That's it!
        Iterator cafeIterator = cafeMenu.createIterator();

        // And then call the overloaded printMenu() with each iterator.
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
        */

        /* We're changing the implementation to use Iterator instead.
        // The implementation is showing through, breakfast items are in an ArrayList, lunch items are in an Array.
        // The method look the same, but the calls are returning different types.
        ArrayList breakfastItems = pancakeHouseMenu.getMenuItems();
        MenuItem[] lunchItems = dinerMenu.getMenuItems();

        // Now, we have to implement two different loops to step through the two implementations of the menu items...
        // ...one loop for the ArrayList...
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem)breakfastItems.get(i);
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }

        // and another for the Array.
        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
        */
    }

    // The overloaded printMenu() method uses the Iterator to step through the menu items and print them.
    private void printMenu(Iterator iterator) {
        // Test if there are any more items.
        while (iterator.hasNext()) {
            // Get the next item.
            MenuItem menuItem = (MenuItem)iterator.next();
            // Use the item to get name, price, and description and print them.
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
        // Note that we're down to ONE LOOP.
    }

    /* We're changing the implementation to use Iterator instead.
    // Implementing every other method in the Waitress is going to be a variation of this theme. We're going to need to
    // get both menus and use two loops to iterate through their items. If another restaurant with a different
    // implementation is acquired then we'll have THREE loops.

    public void printBreakfastMenu() {

    }

    public void printLunchMenu() {

    }

    public void printVegetarianMenu() {

    }

    public boolean isItemVegetarian(String name) {

    }
    */
}
