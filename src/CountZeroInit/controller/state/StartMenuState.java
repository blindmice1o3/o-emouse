package CountZeroInit.controller.state;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.controller.commandholder.*;

public class StartMenuState implements State {
    private CountZeroInit countZeroInit;
    int startMenuCommandsIndex;
    int startMenuCommandsSize;
    Command[] startMenuCommands;

    public StartMenuState(CountZeroInit countZeroInit) {
        // The following println() is just to see where StartMenuState's constructor is called in the output.
        System.out.println("StartMenuState.constructor...");

        this.countZeroInit = countZeroInit;
        loadStartMenuCommands();
    }

    public void loadStartMenuCommands() {
        // The following println() is just to see where loadStartMenuCommands() is called in the output.
        System.out.println("StartMenuState.loadStartMenuCommands()...");

        // Instantiate an array to hold Command objects; initialize that array to hold 4 concrete command objects that
        // are instantiated during the startMenuCommands[]'s initialization.
        startMenuCommands = new Command[] { new MonsterListStateCommand(countZeroInit),
                                new MyMonsterListStateCommand(countZeroInit),
                                new ItemListStateCommand(countZeroInit),
                                new ExitKeyCommand(countZeroInit) };

        // Initiate the startMenuCommandsIndex instance variable to 0 by default.
        // Initiate the startMenuCommandsSize instance variable to however many the startMenuCommands[] array was initialized with.
        startMenuCommandsIndex = 0;
        startMenuCommandsSize = startMenuCommands.length;
    }

    @Override
    public void aButtonPressed() {
        // The following println() is just to see where aButtonPressed() is called in the output.
        System.out.println("StartMenuState.aButtonPressed()...");

        // Calls execute() on whichever concreteCommand the index had selected.
        Command currentCommand = startMenuCommands[startMenuCommandsIndex];
        currentCommand.execute();
    }

    @Override
    public void bButtonPressed() {
        // The following println() is just to see where bButtonPressed() is called in the output.
        System.out.println("StartMenuState.bButtonPressed()...");

        // Calls execute() on the exitKeyCommand stored in index=3 of the startMenuCommands[] array. Should set current state to GameState.
        Command exitKeyCommand = startMenuCommands[3];
        exitKeyCommand.execute();
    }

    @Override
    public void selectButtonPressed() {
        // The following println() is just to see where selectButtonPressed() is called in the output.
        System.out.println("StartMenuState.selectButtonPressed()...");

    }

    @Override
    public void startButtonPressed() {
        // The following println() is just to see where startButtonPressed() is called in the output.
        System.out.println("StartMenuState.startButtonPressed()...");

        // Calls execute() on the exitKeyCommand stored in index=3 of the startMenuCommands[] array. Should set current state to GameState.
        Command exitKeyCommand = startMenuCommands[3];
        exitKeyCommand.execute();
    }

    @Override
    public void upButtonPressed() {
        // The following println() is just to see where upButtonPressed() is called in the output.
        System.out.println("StartMenuState.upButtonPressed()...");

        if (startMenuCommandsIndex > 0) {       // && (startMenuCommandsIndex != 3)
            startMenuCommandsIndex--;           // or we can try to make the fourth element in the array not included in the condition
        } else {
            startMenuCommandsIndex = (startMenuCommandsSize-1);
        }
    }

    @Override
    public void downButtonPressed() {
        // The following println() is just to see where downButtonPressed() is called in the output.
        System.out.println("StartMenuState.downButtonPressed()...");

        if (startMenuCommandsIndex < (startMenuCommandsSize-1)) {   // && (startMenuCommandsIndex != 3)
            startMenuCommandsIndex++;                               // or we can try to make the fourth element in the array not included in the condition
        } else {
            startMenuCommandsIndex = 0;
        }
    }

    @Override
    public void rightButtonPressed() {
        // The following println() is just to see where rightButtonPressed() is called in the output.
        System.out.println("StartMenuState.rightButtonPressed()...");

    }

    @Override
    public void leftButtonPressed() {
        // The following println() is just to see where leftButtonPressed() is called in the output.
        System.out.println("StartMenuState.leftButtonPressed()...");

    }

    @Override
    public String toString() {
        return "StartMenuState";
    }
}
