package HeadFirst.DesignPatterns.Ch10StatePattern;

public class HasQuarterState implements State {
    GumballMachine gumballMachine;

    // When the state is instantiated we pass it a reference to the GumballMachine. This is used to transition the
    // machine to a different state.
    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    // An inappropriate action for this state.
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }
    // Return the customer's quarter and transition back to the NoQuarterState
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
    // When the crank is turned we transition the machine to the SoldState state by calling its setState() method and
    // passing it the SoldState object. The SoldState object is retrieved by the getSoldState() getter method (there is
    // one of these getter methods for each state.
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }
    // Another inappropriate action for this state.
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
