package HeadFirst.DesignPatterns.Ch10StatePattern;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    // Here are all the inappropriate actions for this state.
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    // Dispense one gumball. Check number of gumballs; if > 0, go to NoQuarterState, otherwise go to SoldOutState.
    // And here's where the real work begins...
    // We're in the SoldState, which means the customer paid. So, we first need to ask the machine to release a gumball.
    // Then we ask the machine what the gumball count is, and either transition to the NoQuarterState or the SoldOutState.
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
