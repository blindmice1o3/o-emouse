package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern.CompositePatternMenuComponent;

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;

    // The Waitress code really is this simple. Now we just hand her the top level menu component, the one that contains
    // all the other menus. We've called that allMenus.
    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    // All she has to do to print the entire menu hierarchy - all the menus, and all the menu items - is call print() on
    // the top level menu.
    public void printMenu() {
        allMenus.print();
    }

    // The printVegetarianMenu() method takes the allMenu's composite and gets its iterator. That will be our CompositeIterator.
    public void printVegetarianMenu() {
        Iterator iterator = allMenus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n----");
        // Iterate through every element of the composite.
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            try {
                // Calls each element's isVegetarian() method and if true, we call its print() method.
                // print() is only called on MenuItems, never composites. Can you see why?
                // We implemented isVegetarian() on the Menus to always throw an exception. If that happens we catch the
                //     exception, but continue with our iteration.
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {}
        }
    }
}
