package HeadFirst.DesignPatterns.Ch06CommandPattern;

public class RemoteControl {
    // This time around, as oppose to the SimpleRemoteControl, the remote is going to handle seven On and Off commands,
    //     which we'll hold in corresponding arrays.
    Command[] onCommands;
    Command[] offCommands;

    // This is where we'll stash the last command executed for the undo button.
    Command undoCommand;

    // In the constructor, all we need to do is instantiate and initialize the on and off arrays.
    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        // In the remote control, we didn't want to check to see if a command was loaded every time we referenced a slot,
        //     so we initialized each slot/button to a concrete command object that does nothing (NoCommand) as default.
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        // Just like the other slots, undo starts off with a NoCommand, so pressing undo before any other button won't
        //     do anything at all.
        undoCommand = noCommand;
    }

    // The setCommand() method takes a slot position and an On and Off command to be stored in that slot. It puts these
    //     commands in the on and off arrays for later use.
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] =  onCommand;
        offCommands[slot] = offCommand;
    }

    // When the On or Off button is pressed, the hardware (Receiver) takes care of calling the corresponding methods
    //     onButtonWasPushed() or offButtonWasPushed().
    // When a button is pressed, we take the command and first execute it; then we save a reference to it in the
    //     undoCommand instance variable. We do this for both "on" commands and "off" commands.
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }


    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    // When the undo button is pressed, we invoke the undo() method of the command stored in the undoCommand. This
    //     reverses the operation of the last command executed.
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    // We've overwritten toString() to print out each slot and its corresponding command.
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[undo] " + undoCommand.getClass().getName());
        return stringBuff.toString();
    }
}
