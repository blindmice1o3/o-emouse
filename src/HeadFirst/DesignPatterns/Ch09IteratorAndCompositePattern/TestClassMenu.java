package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;
/*
    -----     -----     -----
    ITERATOR pattern: provides a way to access the elements of an aggregate object sequentially without exposing its
        underlying representation.
    -----     -----     -----

    -----     -----     -----
    COMPOSITE pattern: allows you to compose objects into tree structures to represent part-whole hierarchies. Composite
        lets clients treat individual objects and compositions of objects uniformly.
    -----     -----     -----

    -Objectville Diner and Objectville Pancake House are merging businesses. The owners agreed on the implementation for
        the menu items, but can't agree on how to implement the menus. One used an ArrayList to hold menu items while the
        other used an Array. Neither are will to change their implementations, they both have too much code written that
        depends on them.
    -What's the problem with having two different menu representations? To see how it complicates things, let's try
        implementing a client tha tuses the two menus.
    -We've been hired to create a Java-enabled waitress that can print a custom menu for customers on demand, and even
        tell you if a menu item is vegetarian without having to ask the cook.
    -Because neither will change their implementation, we need a way to allow them to implement the same interface for
        their menus (they're already close, except for the return type of the getMenuItems() method). That way we can
        minimize the concrete references in the Waitress code and also hopefully get rid of the multiple loops required
        to iterate over both menus.


    -Encapsulate what varies: the iteration caused by different collections of objects being returned from the menus.
        To iterate through the breakfast items, we use the size() and the get() methods on the ArrayList.
        To iterate through the lunch items, we use the Array length field and the array subscript notation on the MenuItem Array.
    -Now what if we create an object, let's call it an Iterator, that encapsulates the way we iterate through a collection
        of objects?

    MEET THE ITERATOR PATTERN:
        <<interface>>               Concrete implementation of Iterator         Concrete implementation of Iterator
           Iterator                           DinerMenuIterator                       PancakeHouseMenuIterator
        -hasNext()                  -hasNext()                                  -hasNext()
        -next()                     -next()                                     -next()

    -We ask the breakfastMenu (ArrayList) for an iterator of its MenuItems.
    -The client just calls hasNext() and next(); behind the scenes the iterator calls get() on the ArrayList.
        // And while there are more items left...
        // We get the next item.
                    Iterator iterator = breakfastMenu.createIterator();
                    while (iterator.hasNext()) {
                        MenuItem menuItem = (MenuItem)iterator.next();
                    }
        // We can do the same with the lunchMenu (Array), ask it for an iterator of its MenuItems.
        // Same situation: the client just calls hasNext() and next(); behind the scenes, the iterator indexes into the
        // Array.
                    Iterator iterator = lunchMenu.createIterator();
                    while (iterator.hasNext()) {
                        MenuItem menuItem = (MenuItem)iterator.next();
                    }

    Adding an Iterator to the DinerMenu: define the Iterator interface, implement a concrete Iterator that works for Diner menu.
    Fixing up the Waitress code: integrate the iterator code into the Waitress. First we create a printMenu() method that
        takes an Iterator, then we use the createIterator() method on each menu to retrieve the Iterator and pass it to
        the new method.
    Once we gave the Objectville cooks a PancakeHouseMenuIterator and a DinerMenuIterator, all they had to do was add a
        createIterator() method to their Menu class and they were finished.

    WHAT HAVE WE DONE SO FAR?
    Hard to Maintain Waitress Implementation:
        -The Menus are not well encapsulated; we can see the Diner is using an ArrayList and the Pancake House an Array.
        -We need two loops to iterate through the MenuItems.
        -The Waitress is bound to concrete classes (MenuItems[] and ArrayList).
        -The Waitress is bound to two different concrete Menu classes, despite their interfaces being almost identical.
    New, Hip Waitress Powered by Iterator:
        -The Menu implementations are now encapsulated. Each Menu now have their own createIterator() methods that are
            responsible for creating the iterator for their respective menu items implementations. The Waitress is
            decoupled from the implementation of the concrete Menu classes. She has no idea how the Menus hold their
            collection of menu items. She doesn't need to know if a Menu is implemented with an Array, an ArrayList, or
            with PostIt notes. All she cares is that she can get an Iterator to do her iterating.
        -All we need is a loop that polymorphically handles any collection of items as long as it implements Iterator.
        -The Waitress now uses an interface (Iterator).
        -The Menu interfaces are now exactly the same and, uh oh, we still don't have a common interface. which means
            the Waitress is still bound to two concrete Menu classes. We'd better fix that.........

    Note that the iterator give us a way to step through the elements of an aggregate without forcing the aggregate to
    clutter its own interface with a bunch of methods to support traversal of its elements. It also allows the
    implementation of the iterator to live outside of the aggregate; in other words, we've encapsulated the interaction.


    THE java.util.Iterator INTERFACE:
    We're going to switch from using our own home grown Iterator interface to the Java Iterator interface (we created one
    from scratch just so we could see HOW to build an iterator from scratch).

    The Java Iterator interface looks just like our previous definition, except we have an additional method that allows
    us to remove() the last item returned by the next() method from the aggregate.
        -We just need to change the interface that both PancakeHouseMenuIterator and DinerMenuIterator extend? Just
        DinerMenuIterator (the PancakeHouseMenuIterator used an ArrayList, which already has an iterator() method that
        returns an iterator. In other words, we never needed to implement our own iterator for ArrayList.).

        -For PancakeHouseMenu:
            // Instead of creating our own iterator now, we just call the iterator() method on the menuItems ArrayList.
            public Iterator createIterator() {
                return menuItems.iterator();
            }
        -For DinerMenu (its DinerMenuIterator class will still implement next() and hasNext(), but now also remove()):
            // Here, because the chef is using a fixed sized Array, we just shift all the elements up one when remove()
            // is called.
            public void remove() {
                if (position <= 0) {
                    throw new IllegalStateException("You can't remove an item until you've done at least one next()");
                }
                if (list[position-1] != null) {
                    for (int i = position-1; i < (list.length-1); i++) {
                        list[i] = list[i+1];
                    }
                    list[list.length-1] = null;
                }
            }

    We need to give the Menus a common interface (which is quite simple) and rework the Waitress a little.
        public interface Menu {
            public Iterator createIterator();
        }

    Now we need to add an "implements Menu" on both the PancakeHouseMenu and the DinerMenu class definitions and update
    Waitress.
        -Now the Waitress uses the java.util.Iterator.
        -Replace the concrete Menu classes (ArrayList and MenuItem[]) with the Menu Interface).

    What did this get us?
        // This solves the problem of the Waitress depending on the concrete Menus.
        -The PancakeHouseMenu and DinerMenu classes implement an interface, Menu. Waitress can refer to each menu object
            using the interface rather than the concrete class. So, we're reducing the dependency between the Waitress
            and the concrete classes by "programming to an interface, not an implementation." Now Waitress only needs to
            be concerned with Menus and Iterators.
        // This solves the problem of the Waitress depending on the implementation of the MenuItems.
        -The new Menu interface has one method, createIterator(), that is implemented by PancakeHouseMenu and DinerMenu.
            Each menu class assumes the responsibility of creating a concrete Iterator that is appropriate for its
            internal implementation of the menu items.

    The pattern gives you a way to step through the elements off an aggregate without having to know how things are
        represented under the covers. You've seen that with the two implementations of Menus.
    Once you have a uniform way of accessing the elements of all your aggregate objects, you can write polymorphic code
        that works with any of these aggregates - just like the printMenu() method, which doesn't care if the menu items
        are held in an Array or ArrayList (or anything else that can create an Iterator), as long as it can get hold of
        an Iterator.
    The pattern takes the responsibility of traversing elements and give that responsibility to the iterator object, not
        the aggregate object. This not only keeps the aggregate interface and implementation simpler, it removes the
        responsibility for iteration from the aggregate and keeps the aggregate focused on the things it should be focused
        on (managing a collection of objects), not on iteration.
    We implemented an external iterator, which means that the client controls the iteration by calling next() to get the
        next element. An internal iterator is controlled by the iterator itself.


    SINGLE RESPONSIBILITY (Design Principle): A class should have only one reason to change.
        Q. Why is it bad if we had a class take on multiple responsibility?
        A. If we allow a class to not only take care of its own business (managing some kind of aggregate) but also take
        on more responsibilities (like iteration) then we've given the class two reasons to change. It can change if the
        collection changes in some way, and it can change if the way we iterate changes.
    COHESION: a measure of how closely a class or a module supports a single purpose or responsibility.
    Cohesion is a more general concept than the Single Responsibility Principle, but the two are closely related. Classes
        that adhere to the principle tend to have high cohesion and are more maintainable than classes that take on
        multiple responsibilities and have low cohesion.


    NEW REQUIREMENT: HANDLE A THIRD MENU OBJECT.
    Objectville Cafe is also joining the team, the Cafe is merging and adopting the dinner menu.
        -See CafeMenu class.
        -See Waitress class. Now updated with the third menu. As well as this test class to take 3 menus.

    CODE UP CLOSE:
    -The Hashtable is a little more complex than the ArrayList because it supports both keys and values, but we can still
        get an Iterator for the values (which are the MenuItems).
    -First we get the values of the Hashtable, which is just a collection of all the objects in the hashtable
        (menuItems.value()).
    -Luckily that collection supports the iterator() method, which returns a object of type java.util.Iterator.
                    public Iterator createIterator() {
                        return menuItems.values().iterator();
                    }

    WHAT DID WE DO?
    We decoupled the Waitress...
        -We wanted to give the Waitress an easy way to iterate over menu items...
        -...and we didn't want her to know about how the menu items are implemented.
        -Our menu items had two different implementations and two different interfaces for iterating.
        -So we gave the Waitress an Iterator for each kind of group of objects she needed to iterator over...
            -ArrayList has a built in iterator... Array doesn't have a built in iterator so we built our own.
        -Now she doesn't have to worry about which implementation we used; she always uses the same interface - Iterator -
            to iterate over menu items. She's been decoupled from the implementation.
    ...and we made the Waitress more extensible
        -By giving her an Iterator we have decoupled her from the implementation of the menu items, so we can easily add
            new Menus if we want.
            -We easily added another implementation of menu items, and since we provided an Iterator, the Waitress knew
                what to do.
            -Making an Iterator for the Hashtable values was easy; when you call values.iterator() you get an Iterator.
        -Which is better for her, because now she can use the same code to iterate over any group of objects. And it's
            better for us because the implementation details aren't exposed.
    But there's more!
        -Java gives you a lot of "collection" classes that allow you to store and retrieve groups of objects. For example,
            Vector and LinkedList.
        -Most have different interfaces. But almost all of them support a way to obtain an Iterator. And even if they
            don't support Iterator, that's ok, because now you know how to build your own.


    ITERATORS and COLLECTIONS:
        -Java Collections Framework is a set of classes and interfaces (including ArrayList, Vector, LinkedList, Stack,
            and PriorityQueue). Each of these classes implements the java.util.Collection interface (which contains a
            bunch of useful methods for manipulating groups of objects).
        -Each Collection object knows how to create its own Iterator. Calling iterator() on an ArrayList returns a concrete
            Iterator made for ArrayLists, but you never need to see or worry about the concrete class it uses. Hashtable
            indirectly supports Iterator, first retrieve its collection of values and then obtain the iterator.
        -Java 5 added support for iterating over Collections so we don't even have to ask for an iterator. It's a new form
            of the for statement, called "for/in":
                for (Object obj: collection) {                  for (MenuItem item: items) {
                    ...                                             System.out.println("Breakfast item: " + item);
                }                                               }


    WAITRESS STORES THREE IMPLEMENTATIONS of Menu into an ArrayList:
        -The Waitress has come a long way, but we're still calling printMenu() three times (one for each menu), and every
            time we add a new menu we have to open up the Waitress implementation and add more code (violating the
            "Open Closed Principle".
        -We are still handling the menus with separate, independent objects - we need a way to manage them together. We
            need one Iterator to pass to the Waitress to iterate over all the menus.
        -We can package all the menus stored in the Waitress into an ArrayList and then get the ArrayList's iterator to
            iterate through each menu, passing each menu's iterator to the overloaded printMenu() method.


    NEW CHANGE: ADD dessert SUBMENU to DinerMenu.
        -Not only support multiple menus, but not we need to support menus within menus.
        -But we can't put a Menu object into an Array that only hold MenuItem objects.
        -We'll refactor the chef's implementation so it's general enough to work over all the menus (and sub menus).
        -We need a TREE SHAPED STRUCTURE that will accommodate menus, submenus, and menu items.


    The COMPOSITE PATTERN allows us to build structures of objects in the form of trees that contain both compositions of
        objects and individual objects as nodes.
    -Using a composite structure, we can apply the same operations (like printing) over both composites and individual
        objects. In other words, we can ignore the differences between compositions of objects and individual objects.
    -By putting menus and items in the same structure we create a part-whole hierarchy; that is, a tree of objects that
        is made of parts (menus and menu items) but can be treated as a whole, like one big uber menu.
    -We can create a tree structure that can handle a nested group of menus AND menu items in the same structure. Menus
        are nodes, and MenuItems are leaves.

    COMPOSITE PATTERN class diagram:
        -The Client uses the Component interface to manipulate the objects in the composition.
        -The Component define an interface for all objects in the composition; both the composite and the leaf nodes.
        -The Composite's role is to define the behavior of the components having children and to store child components.
            The Composite also implements the Leaf-related operations. Note that some of these may not make sense on a
            Composite, so in that case an exception might be generated.
        -A Leaf has no children. A Leaf defines the behavior for the elements in the composition. It does this by
            implementing the operations the Composite supports. Note that a Leaf also inherits methods like add(), remove(),
            and getChild(), which don't necessarily make a lot of sense for a leaf node.
    DESIGNING MENU WITH COMPOSITE:
        -The Waitress is going to use the MenuComponent interface to access both Menus and MenuItems.
        -MenuComponent represents the interface for both MenuItem and Menu. We've used an abstract class here because we
            want to provide default implementations for these methods.
        -Menu overrides the methods that make sense, like a way to add and remove menu items (or other menus!) from its
            menuComponents. In addition, we'll use the getName() and getDescription() methods to return the name and
            description of the menu.
        -MenuItem overrides the methods that make sense, and uses the default implementations in MenuComponent for those
            that don't make sense (like add() - it doesn't make sense to add a component to a MenuItem... we can only
            add components to a Menu).
    -See CompositePatternMenuComponent package.
        -All components must implement the MenuComponent interface; however, because leaves and nodes have different roles
            we can't always define a default implementation for each method that makes sense. Sometimes the best you can
            do is throw a runtime exception.
        -We start with the MenuComponent abstract class; remember, the role of the menu component is to provide an interface
            for the leaf nodes and the composite nodes. Now you might be asking, "Isn't the MenuComponent playing two roles?"
            It might well be and we'll come back to that point. However, for now we're going to provide a default implementation
            of the methods so that if the MenuItem (the leaf) or the Menu (the composite) doesn't want to implement some
            of the methods (like getChild() for a leaf node) they can fall back on some basic behavior.
    -TWO RESPONSIBILITIES IN ONE CLASS: manages a hierarchy AND performs operations related to Menus.
        -The Composite Pattern takes the Single Responsibility design principle and trades it for transparency (a client
            can treat both composites and leaf nodes uniformly, so whether an element is a composite or a leaf node becomes
            transparent to the client).
        -The Component interface contain the child management operations AND the leaf operations.
        -We lose a bit of safety because a client might try to do something inappropriate or meaningless on an element
            (like try to add a menu to a menu item). This is a design decision; we could take the design in the other
            direction and separate out the responsibilities into interfaces. This would make our design safe, in the sense
            that any inappropriate calls on elements would be caught at compile time or runtime, but we'd lose
            transparency and our code would have to use conditionals an the isntanceof operator.
        -This is a classic case of tradeoff. Sometimes we purposely do things in a way that seems to violate the principle.
        -In some cases it is a matter of perspective. It might seem incorrect to have child management operations in the
            leaf nodes (like add(), remove() and getChild()), but then again you can always shift your perspective and
            see a leaf as a node with zero children.

    FLASHBACK TO ITERATOR:
        -We are already using Iterator in our internal implementation of the print() method, but we can also allow the
            Waitress to iterate over an entire composite if she needs to, for instance, if she wants to go through the
            entire menu and pull out vegetarian items.
        -To implement a Composite iterator, let's add a createIterator() method in every component. We'll start with the
            abstract MenuComponent class.
        -THE COMPOSITE ITERATOR - see CompositeIterator class in CompositePatternMenuComponent package.
        -THE NULL ITERATOR - see NullIterator class in CompositePatternMenuComponent package.

    -----     -----     -----
    ITERATOR pattern: provides a way to access the elements of an aggregate object sequentially without exposing its
        underlying representation.
    -----     -----     -----

    -----     -----     -----
    COMPOSITE pattern: allows you to compose objects into tree structures to represent part-whole hierarchies. Composite
        lets clients treat individual objects and compositions of objects uniformly.
    -----     -----     -----
*/

import java.util.ArrayList;

public class TestClassMenu {
    public static void main(String[] args) {
        // First we create the new menus.
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        ArrayList menus = new ArrayList();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(cafeMenu);

        Waitress waitress = new Waitress(menus);
        /* We're switching to the Waitress holding all 3 menus in an ArrayList instance variable.
        // Then we create a Waitress and pass her the menus.
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
        */

        // Then we print them.
        waitress.printMenu();
    }
}
