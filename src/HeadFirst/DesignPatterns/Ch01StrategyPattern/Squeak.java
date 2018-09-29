package HeadFirst.DesignPatterns.Ch01StrategyPattern;

public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}
