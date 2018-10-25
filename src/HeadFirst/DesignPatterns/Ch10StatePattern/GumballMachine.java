package HeadFirst.DesignPatterns.Ch10StatePattern;

public class GumballMachine {
    /* We're switching to using State objects
    // Here are the four states; they match the states in Mighty Gumball's state diagram.
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;
    // Here's the instance variable that is going to keep track of the current states we're in. We start in the SOLD_OUT state.
    //int state = SOLD_OUT;
    */

    // Here are all the State instance variable.
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    // We're now saving state as a State object
    State state = soldOutState;

    // We have a second instance variable that keeps track of the number of gumballs in the machine.
    // The count instance variable hold the count of gumballs - initially the machine is empty.
    int count = 0;

    // The constructor takes an initial inventory of gumballs. If the inventory isn't zero, the machine enters state
    // NO_QUARTER, meaning it is waiting for someone to insert a quarter, otherwise it stays in the SOLD_OUT state.
    // Our constructor takes the initial number of gumballs and stores it in an instance variable.
    public GumballMachine(int count) {
        // It also creates the State instances, one of each.
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = count;
        // If there are more than 0 gumballs we set the state to the NoQuarterState.
        if (count > 0) {
            //state = NO_QUARTER;
            state = noQuarterState;
        }
    }

    /* Switching to using State objects
    // Now we start implementing the actions as methods...
    // When a quarter is inserted, if...
    public void insertQuarter() {
        // a quarter is already inserted we tell the customer;
        if (state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
            // otherwise we accept the quarter and transition to the HAS_QUARTER state.
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
            // and if the machine is sold out, we reject the quarter.
        } else if (state == SOLD_OUT) {
            System.out.println("You can't insert a quarter, the machine is sold out");
            // If the customer just bought a gumball he needs to wait until the transaction is complete before inserting
            // another quarter.
        } else if (state == SOLD) {
            System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    // Now, if the customer tries to remove the quarter...
    public void ejectQuarter() {
        // If there is a quarter, we return it and go back to the NO_QUARTER state.
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTER;
            // Otherwise, if there isn't one we can't give it back.
        } else if (state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
            // If the customer just turned the crank, we can't give a refund; he already has the gumball!
        } else if (state == SOLD) {
            System.out.println("Sorry, you already turned the crank");
            // You can't eject if the machine is sold out, it doesn't accept quarters!
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }

    // The customer tries to turn the crank...
    public void turnCrank() {
        // Someone's trying to cheat the machine.
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball!");
            // We need a quarter first.
        } else if (state == NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
            // We can't deliver gumballs; there are none.
        } else if (state == SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs");
            // Success! They get a gumball. Change the state to SOLD and call the machine's dispense() method.
        } else if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    // Called to dispense a gumball.
    public void dispense() {
        // We're in the SOLD state; give 'em a gumball!
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            // Here's where we handle the "out of gumballs" condition: If this was the last one, we set the machine's
            // state to SOLD_OUT; otherwise, we're back to not having a quarter.
            if (count == 0) {
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
            // None of these should ever happen, but if they do, we give 'em an error, not a gumball.
        } else if (state == NO_QUARTER) {
            System.out.println("You need to pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        }
    }
    */

    // Now for the actions. These are VERY EASY to implement now. We just delegate to the currrent state.
    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    // Note that we don't need an action method for dispense() in GumballMachine because it's just an internal action; a
    // user can't ask the machine to dispense directly. But we do call dispense() on the State object from the turnCrank() method.
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    // The machine supports a releaseBall() helper method that releases the ball and decrements the count instance variable.
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
           count = count -1;
        }
    }

    public void refill(int numOfGumballs) {
        this.count = numOfGumballs;
        if (count > 0) {
            state = noQuarterState;
        }
    }

    // other methods here like toString() and refill()
    public String toString() {
        return "Mighty Gumball, Inc." +
        "\nJava-enabled Standing Gumball Model #2004" +
        "\nInventory: " + count + " gumballs" +
        "\n" + state;
    }

    // This method allows other objects (like our State objects) to transition the machine to a different state.
    public void setState(State state) {
        this.state = state;
    }
    public int getCount() {
        return count;
    }

    // More methods here including getts for each State...
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    public State getSoldOutState() {
        return soldOutState;
    }
    public State getNoQuarterState() {
        return noQuarterState;
    }
    public State getSoldState() {
        return soldState;
    }
    public State getWinnerState() {
        return winnerState;
    }

}
