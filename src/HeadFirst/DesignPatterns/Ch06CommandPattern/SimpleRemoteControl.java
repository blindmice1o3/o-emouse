package HeadFirst.DesignPatterns.Ch06CommandPattern;

public class SimpleRemoteControl {
    // We have one slot to hold our command, which will control one device.
    Command slot;

    public SimpleRemoteControl() {}

    // We have a method for setting the command the slot is going to control. This could be called multiple times if the
    //     client of this code wanted to change the behavior of the remote button.
    public void setCommand(Command command) {
        slot = command;
    }


    // This method is called when the button is pressed. All we do is take the current command bound to the slot and
    //     call its execute() method.
    public void buttonWasPressed() {
        slot.execute();
    }
}
