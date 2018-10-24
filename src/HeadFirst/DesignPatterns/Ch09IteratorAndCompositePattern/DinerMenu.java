package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

import java.util.Iterator;

// And here's Mel's implementation of the Diner menu.
// I used a REAL Array so I can control the maximum size of my menu and get my MenuItems without having to use a cast.
public class DinerMenu implements Menu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;
    String name = "Diner Menu";

    public DinerMenu() {
        // Mel takes a different approach; he's using an Array so he can control the max size of the menu and retrieve
        // menu items without having to cast his objects.
        menuItems = new MenuItem[MAX_ITEMS];

        // Like Lou, Mel creates his menu items in the constructor, using the addItem() helper method.
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);

        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99);

        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);

        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);

        // a couple of other Diner Menu items added here
    }

    // Here's the createIterator() method. It creates a DinerMenuIterator from the menuItems array and returns it to the
    // client.
    public Iterator createIterator() {
        // We're returning the Iterator interface. The client doesn't need to know how the menuItems are maintained in
        // the DinerMenu, nor does it need to know how the DinerMenuIterator is implemented. It just needs to use the
        // iterators to step through the items in the menu.
        return new DinerMenuIterator(menuItems);
    }

    // addItem() takes all the parameters necessary to create a MenuItem and instantiates one. It also checks to make sure
    // we haven't hit the menu size limit.
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);

        if (numberOfItems >= MAX_ITEMS) {
            // Mel specifically wants to keep his menu under a certain size (presumably so he doesn't have to remember
            // too many recipes).
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    /* We're not going to need the getMenuItems() method anymore and in fact, we don't want it because it exposes our
           internal implementations.
    // getMenuItems() returns the array of menu items.
    public MenuItem[] getMenuItems() {
        return menuItems;
    }
    */

    // Like Lou, Mel has a bunch of code that depends on the implementation of his menu being an Array. He's too busy
    //     cooking to rewrite all of this.
    // other menu methods here

    public String getName() {
        return this.name;
    }
}
