package HeadFirst.DesignPatterns.Ch06CommandPattern;

// Harder version of Undo (the first was... if the object was an "off" command its undo() would turn it on... if the
//     object was an "on" command its undo() would turn it off.
// (aka Using state to implement Undo)

// A vendor supplied class that our RemoteControl API is suppose to work with
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    // Notice that the CeilingFan class holds local state representing the speed of the ceiling fan
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    // ********* These methods set the speed of the ceiling fan. *********************
    public void high() {
        speed = HIGH;
        System.out.println(location + " ceiling fan is on high");
        // code to set fan to high
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " ceiling fan is on medium");
        // code to set fan to medium
    }

    public void low() {
        speed = LOW;
        System.out.println(location + " ceiling fan is on low");
        // code to set fan to low
    }

    public void off() {
        speed = OFF;
        System.out.println(location + " ceiling fan is off");
        // code to turn fan off
    }
    // *******************************************************************************

    // We can get the current speed of the ceiling fan using getSpeed().
    public int getSpeed() {
        return speed;
    }
}
