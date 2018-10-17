package HeadFirst.DesignPatterns.Ch07AdapterPattern;

import java.util.Enumeration;
import java.util.Iterator;

// We're adapting Enumeration to Iterator, our Adapter implements the Iterator interface... it has to look like an Iterator.
public class EnumerationIterator implements Iterator {
    Enumeration enum1;

    // The Enumeration we're adapting. We're using composition so we stash it in an instance variable.
    public EnumerationIterator(Enumeration enum1) {
        this.enum1 = enum1;
    }

    // The Iterator's hasNext() method is delegated to the Enumeration's hasMoreElements() method...
    public boolean hasNext() {
        return enum1.hasMoreElements();
    }

    // ... and the Iterator's next() method is delegated to the Enumeration's nextElement() method.
    public Object next() {
        return enum1.nextElement();
    }

    // Unfortunately, we can't support Iterator's remove() method, so we have to punt (in other words, we give up!). Here
    // we just throw an exception.
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
