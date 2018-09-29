package HeadFirst.DesignPatterns.Ch01StrategyPattern;

public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
