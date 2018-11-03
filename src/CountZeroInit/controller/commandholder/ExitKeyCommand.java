package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.controller.state.GameState;

public class ExitKeyCommand implements Command {
    GameboyColor gb;

    public ExitKeyCommand(GameboyColor gb) {
        // The following println() is just to see where ExitKeyCommand's constructor is called in the output.
        System.out.println("ExitKeyCommand.constructor...");

        this.gb = gb;
    }

    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("ExitKeyCommand.execute()...");

        gb.setCurrentState(gb.getGameState());

        GameState gameState = (GameState)gb.getGameState();
        gameState.setPlayer();
    }
}
