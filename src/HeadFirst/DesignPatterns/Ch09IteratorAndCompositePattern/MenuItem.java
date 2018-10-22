package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

// The Diner menu has lots of lunch items, while the Pancake House consists of breakfast items. Every menu item has a
// name, a description, and a price.
public class MenuItem {
    String name;
    String description;
    boolean vegetarian;
    double price;

    // A MenuItem consists of a name, a description, a flag to indicate if the item is vegetarian, and a price. You pass
    // all these values into the constructor to initialize the MenuItem.
    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    // These getter methods let you access the fields of the menu item.
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}

