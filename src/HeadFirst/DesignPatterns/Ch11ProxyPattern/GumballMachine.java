package HeadFirst.DesignPatterns.Ch11ProxyPattern;

public class GumballMachine {
    // other instance variables
    State state;
    int count;
    // A location is just a String.
    String location;

    // The location is passed into the constructor and stored in the instance variable.
    public GumballMachine(String location, int count) {
        // other constructor code here
        this.location = location;
        this.count = count;
        state = new NoQuarterState();
    }

    // Let's also add a getter method to grab the location when we need it.
    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    // other methods here
}
