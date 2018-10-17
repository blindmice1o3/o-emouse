package HeadFirst.DesignPatterns.Ch07AdapterPattern;

public class MallardDuck implements Duck {
    // Simple implementations: the duck just prints out what it is doing.
    public void quack() {
        System.out.println("Quack");
    }

    public void fly() {
        System.out.println("I'm flying");
    }
}
