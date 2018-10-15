package HeadFirst.DesignPatterns.Ch06CommandPattern;

public class Light {
    String name;

    public Light() {

    }
    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("Light is On");
    }

    public void off() {
        System.out.println("Light is Off");
    }
}
