package HeadFirst.DesignPatterns.Ch06CommandPattern;

public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    // We've added local state to keep track of the previous speed of the fan.
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        // In execute(), BEFORE we change the speed of the fan, we need to first record its previous state, just in case
        //     we need to undo our actions.
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    public void undo() {
        // To undo, we set the speed of the fan back to its previous speed.
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
