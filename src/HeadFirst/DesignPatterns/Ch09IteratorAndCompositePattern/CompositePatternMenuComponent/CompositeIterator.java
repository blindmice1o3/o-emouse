package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern.CompositePatternMenuComponent;

import java.util.Iterator;
import java.util.Stack;

// The CompositeIterator is a SERIOUS iterator. It's got the job of iterating over the MenuItems in the component, and of
// making sure all the child Menus (and child child Menus, and so on) are included.

// This isn't a lot of code, but it can be a little mind bending. Just repeat to yourself as you go through it "recursion
// is my friend, recursion is my friend."

// Like all iterators, we're implementing the java.util.Iterator interface.
public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    // The iterator of the top level composite we're going to iterate over is passed in. We throw that in a stack data structure.
    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    // Okay, when the client wants to get the next element we first make sure that there is one by calling hasNext()...
    public Object next() {
        // If there is a next element, we get the current iterator off the stack and get its next element.
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent)iterator.next();
            // If that element is a menu, we have another composite that needs to be included in the iteration, so we
            // throw it on the stack. In either case, we return the component.
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }
    }

    // To see if there is a next element, we check to see if the stack is empty; if so, there isn't.
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            // Otherwise, we get the iterator off the top of the stack and see if it has a next element. If it doesn't
            // we pop it off the stack and call hasNext() recursively.
            Iterator iterator = (Iterator)stack.peek();
            if(!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                // Otherwise, there is a next element and we return true.
                return true;
            }
        }
    }

    // We're not support remove, just traversal.
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
