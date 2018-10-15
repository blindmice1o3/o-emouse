package HeadFirst.DesignPatterns.Ch06CommandPattern;

// Idea is to make a new kind of Command that can execute other Commands... and more than one of them!
public class MacroCommand implements Command {
    Command[] commands;

    // Take an array of Commands and store them in the MacroCommand.
    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        // When the macro gets executed by the remote, execute those commands one at a time.
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].undo();
        }
    }
}
