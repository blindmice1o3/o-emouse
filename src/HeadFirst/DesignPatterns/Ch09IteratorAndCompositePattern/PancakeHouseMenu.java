package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

import java.util.ArrayList;
import java.util.Iterator;

// Here's Lou's implementation of the Pancake House menu.
// I used an ArrayList so I can easily expand my menu.
public class PancakeHouseMenu implements Menu {
    ArrayList menuItems;

    public PancakeHouseMenu() {
        // Lou's using an ArrayList to store his menu items.
        menuItems = new ArrayList();

        // Each item is added to the ArrayList here, in the constructor.
        // Each MenuItem has a name, a description, whether or not it's a vegetarian item, and the price.
        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);

        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);

        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);

        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public Iterator createIterator() {
        return new PancakeHouseIterator(menuItems);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        // To add a menu item, Lou creates a new MenuItem object, passing in each argument, and then adds it to the ArrayList.
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    /* We're not going to need the getMenuItems() method anymore and in fact, we don't want it because it exposes our
           internal implementation!
    // The getMenuItems() method returns the list of menu items.
    public ArrayList getMenuItems() {
        return menuItems;
    }
    */

    // Lous has a bunch of other menu code that depends on the ArrayList implementation. he doesn't want to have to
    //     rewrite all that code!
    // other menu methods here
}
