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
        startMenuCommandsIndex = 0;

        startMenuCommands[0] = new MonsterListStateCommand(gb);
        startMenuCommands[1] = new MyMonsterListStateCommand(gb);
        startMenuCommands[2] = new ItemListStateCommand(gb);
        startMenuCommands[3] = new ExitKeyCommand(gb);

        startMenuCommandsSize = startMenuCommands.length;
    }

    @Override
    public void aButtonPressed() {
        Command currentCommand = selectCommand(startMenuCommandsIndex);
        currentCommand.execute();
    }

    public Command selectCommand(int startMenuCommandsIndex) {
        return startMenuCommands[startMenuCommandsIndex];
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
