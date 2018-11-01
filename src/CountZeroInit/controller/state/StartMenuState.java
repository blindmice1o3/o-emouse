package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.controller.commandholder.*;

public class StartMenuState implements State {
    private GameboyColor gb;
    int startMenuCommandsIndex;
    int startMenuCommandsSize;
    Command[] startMenuCommands;

    public StartMenuState(GameboyColor gb) {
        this.gb = gb;
        loadStartMenuCommands();
    }

    public void loadStartMenuCommands() {
        startMenuCommands = new Command[] { new MonsterListStateCommand(gb),
                                new MyMonsterListStateCommand(gb),
                                new ItemListStateCommand(gb),
                                new ExitKeyCommand(gb) };

        startMenuCommandsIndex = 0;
        startMenuCommandsSize = startMenuCommands.length;
    }

    @Override
    public void aButtonPressed() {
        Command currentCommand = startMenuCommands[startMenuCommandsIndex];
        currentCommand.execute();
    }

    @Override
    public void bButtonPressed() {
        gb.setCurrentState(gb.getGameState());
    }

    @Override
    public void selectButtonPressed() {

    }

    @Override
    public void startButtonPressed() {
        gb.setCurrentState(gb.getGameState());
    }

    @Override
    public void upButtonPressed() {
        if (startMenuCommandsIndex > 0) {
            startMenuCommandsIndex--;
        } else {
            startMenuCommandsIndex = startMenuCommandsSize;
        }
    }

    @Override
    public void downButtonPressed() {
        if (startMenuCommandsIndex < startMenuCommandsSize) {
            startMenuCommandsIndex++;
        } else {
            startMenuCommandsIndex = 0;
        }
    }

    @Override
    public void rightButtonPressed() {

    }

    @Override
    public void leftButtonPressed() {

    }
}
