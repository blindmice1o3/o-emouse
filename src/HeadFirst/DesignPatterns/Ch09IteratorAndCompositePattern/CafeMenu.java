package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

import java.util.Hashtable;
import java.util.Iterator;

// CafeMenu doesn't implement our new Menu interface, but this is easily fixed.
// Now the CafeMenu implements the Menu interface, so the Waitress can use it just like the other two Menus.
public class CafeMenu implements Menu {
    // The Cafe is storing their menu items in a Hashtable. Does that support Iterator? We'll see shortly...
    // We're using Hashtable because it's a common data structure for storing values; you could also use the newer HashMap.
    Hashtable menuItems = new Hashtable();

    public CafeMenu() {
        // Like the other Menus, the menu items are initialized in the constructor.
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true,
                3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false,
                3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true,
                4.29);
    }

    // Here's where we create a new MenuItem and add it to the menuItems hashtable.
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        // The key is the item name.
        // The value is the menuItem object.
        menuItems.put(menuItem.getName(), menuItem);
    }

    // And here's where we implement the createIterator() method. Notice that we're not getting an Iterator for the whole
    // Hashtable, just for the values.
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }

    /* Just like before, we can get rid of getItems() so we don't expose the implementation of menuItems to the Waitress.
    // We're not going to need this anymore.
    public Hashtable getItems() {
        return menuItems;
    }
    */
}
