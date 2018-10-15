package HeadFirst.DesignPatterns.Ch06CommandPattern;

public class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    // Just like the LightOnCommand, we get passed the instance of the stereo we are going to be controlling and we store
    // it in a local instance variable.
    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    // To carry out this request, we need to call three methods on the stereo: first, turn it on, then set it to play
    // the CD, and finally set the volume to 11.
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume();
    }

    public void undo() {
        stereo.off();
    }
}
