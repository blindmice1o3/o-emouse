package HeadFirst.DesignPatterns.Ch06CommandPattern;

// A Command object (like an Order from the Diner example or the set of commands assigned to each button of the remote
//     control object) that works on one of our vendor provided class (the Light class; which comes with two methods:
//     on() and off().

// This is a command, so we have to implement the Command interface.
public class LightOnCommand implements Command {
    Light light;

    // The constructor is passed the specific light that this command is going to control - say the living room light -
    //     and stashes it in the light instance variable. When execute gets called, this is the light object that is
    //     going to be the Receiver of the request.
    public LightOnCommand(Light light) {
        this.light = light;
    }

    // The execute method calls the on() method on the receiving object, which is the light we are controlling.
    public void execute() {
        light.on();
    }

    public void undo() { light.off(); }
}
