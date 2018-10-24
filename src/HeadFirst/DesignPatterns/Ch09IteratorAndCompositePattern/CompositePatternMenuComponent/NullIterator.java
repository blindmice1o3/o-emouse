package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern.CompositePatternMenuComponent;

import java.util.Iterator;

// This is the laziest Iterator you've ever seen, at every step of the way it punts.
public class NullIterator implements Iterator {
    // When next() is called, we return null.
    public Object next() {
        return null;
    }
    // Most importantly when hasNext() is called we always return false.
    public boolean hasNext() {
        return false;
    }
    // And the NullIterator wouldn't think of support remove.
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
