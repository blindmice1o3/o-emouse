package HeadFirst.DesignPatterns.Ch11ProxyPattern;

public class NoQuarterState implements State {
    public void insertQuarter() {
        System.out.println("You've inserted a quarter");
    }
    public void ejectQuarter() {
        System.out.println("There's no quarter to eject");
    }
    public void turnCrank() {
        System.out.println("No quarter, no gumball");
    }
    public void dispense() {
        System.out.println("Nothing dispenses");
    }
    public String toString() {
        return "NoQuarterState";
    }
}
