package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern.CompositePatternMenuComponent;

import java.util.Iterator;

// MenuComponent provides default implementations for every method.
// Because some of these methods only make sense for MenuItems, and some only make sense for Menus, the default
//     implementation is UnsupportedOperationException. That way, if MenuItem or Menu doesn't support an operation, they
//     don't have to do anything, they can just inherit the default implementation.
public abstract class MenuComponent {
    // We've grouped together the "composite" methods - that is, methods to add, remove, and get MenuComponents.
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    // Here are the "operation" methods; these are used by the MenuItems. It turns out we can also use a couple of them
    // in Menu too.
    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    // print() is an "operation" method that both our Menus and MenuItems will implement, but we provide a default operation here.
    public void print() {
        throw new UnsupportedOperationException();
    }

    // We've added createIterator() method to the MenuComponent. This means that each Menu and MenuItem will need to
    // implement this method. It also means that calling createIterator() on a composite should apply to all children of
    // the composite.
    public abstract Iterator createIterator();
}
