package HeadFirst.DesignPatterns.Ch01StrategyPattern;

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
