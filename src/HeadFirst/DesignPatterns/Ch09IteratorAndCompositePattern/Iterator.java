package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

// Here's our two methods:
public interface Iterator {
    // The hasNext() method returns a boolean indicating whether or not there are more elements to iterate over...
    boolean hasNext();
    // ...and the next() method returns the next element.
    Object next();
}
