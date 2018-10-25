package HeadFirst.DesignPatterns.Ch10StatePattern;

public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    // Justa like SoldState, we have a bunch of error messages for inappropriate requests.
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a gumball.");
    }
    public void ejectQuarter() {
        System.out.println("Sorry, you have already turned the crank.");
    }
    public void turnCrank() {
        System.out.println("Turning twice does not get you another gumball!");
    }
    // Here we release two gumballs and then either go to the NoQuarterState or the SoldOutState.
    public void dispense() {
        System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter!");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
            // As long as we have a second gumball we release it.
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
