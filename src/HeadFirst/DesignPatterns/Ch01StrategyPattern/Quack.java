package HeadFirst.DesignPatterns.Ch01StrategyPattern;

public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}
