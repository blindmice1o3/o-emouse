package HeadFirst.DesignPatterns.Ch10StatePattern;

public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("Can't insert quarter, gumball machine is sold out");
    }
    public void ejectQuarter() {
        System.out.println("Can't eject quarter, gumball machine is sold out");
    }
    public void turnCrank() {
        System.out.println("Can't turn crank, gumball machine is sold out");
    }
    public void dispense() {
        System.out.println("Can't dispense gumball, gumball machine is sold out");
    }
}
