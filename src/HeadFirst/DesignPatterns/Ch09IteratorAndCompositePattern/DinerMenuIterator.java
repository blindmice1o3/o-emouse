package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

import java.util.Iterator;

// We implement the Iterator interface.
public class DinerMenuIterator implements java.util.Iterator {
    MenuItem[] list;
    // position maintains the current position of the iteration over the array.
    int position = 0;

    // The constructor takes the array of menu items we are going to iterate over.
    public DinerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    // The next() method returns the next item in the array and increments the position.
    public Object next() {
        MenuItem menuItem = list[position];
        position = position + 1;
        return menuItem;
    }

    // The hasNext() method checks to see if we've seen all the elements of the array and returns true if there are more
    // to iterate through.
    public boolean hasNext() {
        // Because the diner chef went ahead and allocated a max sized array, we need to check not only if we are at the
        // end of the array, but also if the next item is null, which indicates there are no more items.
        if (position >= list.length || list[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    // We need to implement remove(). Here, because the chef is using a fixed sized Array, we just shift all the elements
    // up one when remove() is called.
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
}
