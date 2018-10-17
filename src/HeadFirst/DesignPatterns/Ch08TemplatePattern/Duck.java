package HeadFirst.DesignPatterns.Ch08TemplatePattern;

// Remember, we need to implement the Comparable interface since we aren't really subclassing (the template pattern, sort).
public class Duck implements Comparable {
    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name + " weighs " + weight;
    }

    // Okay, here's what sort needs...
    // compareTo() takes another Duck to compare THIS Duck to.
    public int compareTo(Object object) {
        Duck otherDuck = (Duck)object;

        // Here's where we specify how Ducks compare. If THIS Duck weighs less than otherDuck then we return -1; if they
        // are equal, we return 0; and if THIS Duck weighs more, we return 1.
        if(this.weight < otherDuck.weight) {
            return -1;
        } else if (this.weight == otherDuck.weight) {
            return 0;
        } else {
            return 1;
        }
    }
}
