package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseIterator implements java.util.Iterator {
    ArrayList items;
    int position = 0;

    public PancakeHouseIterator(ArrayList items) {
        this.items = items;
    }

    public Object next() {
        MenuItem menuItem = (MenuItem)items.get(position);
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        } else {
            return true;
        }
    }


}
