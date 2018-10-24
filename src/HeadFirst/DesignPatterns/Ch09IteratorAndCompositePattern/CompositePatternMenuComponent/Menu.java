package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern.CompositePatternMenuComponent;

import java.util.ArrayList;
import java.util.Iterator;

// Menu is the composite class. It can hold MenuItems or other Menus.
// Menu is also a MenuComponent, just like MenuItem.
public class Menu extends MenuComponent {
    // Menu can have any number of children of type MenuComponent, we'll use an internal ArrayList to hold these.
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    // This is different than our old implementation: we're going to give each Menu a name and a description. Before, we
    // just relied on having different classes for each menu.
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Here's how you add MenuItem or other Menus to a Menu. Because both MenuItems and menus are MenuComponents, we
    // just need one method to do both. You can also remove a MenuComponent or get a MenuComponent.
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    // Here are the getter methods for getting the name and description. Notice, we aren't overriding getPrice() or
    // isVegetarian() because those methods don't make sense for a Menu (although you could argue that isVegetarian()
    // might make sense). If someone tries to call those methods on a Menu, they'll get an UnsupportedOperationException.
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // To print the Menu, we print the Menu's name and description.
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        // We need to fix the print() method to make it print not only the information about this Menu, but all of this
        // Menu's components: other Menus and MenuItems.

        // We get to use an Iterator. We use it to iterate through all of the Menu's components... those could be other
        // Menus, or they could be MenuItems. Since both Menus and MenuItems implement print(), we just call print() and
        // the rest is up to them.

        // NOTE: If, during this iteration, we encounter another Menu object, its print() method will start another
        // iteration, and so on.

        Iterator iterator = menuComponents.iterator();
        while(iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.print();
        }
    }

    // Here we're using a new iterator called CompositeIterator. It knows how to iterate over any composite. We pass it
    // the current composite's iterator.
    public Iterator createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}
