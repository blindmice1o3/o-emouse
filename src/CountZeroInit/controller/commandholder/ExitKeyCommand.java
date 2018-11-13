package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.controller.state.GameState;

public class ExitKeyCommand implements Command {
    CountZeroInit countZeroInit;

    public ExitKeyCommand(CountZeroInit countZeroInit) {
        // The following println() is just to see where ExitKeyCommand's constructor is called in the output.
        System.out.println("ExitKeyCommand.constructor...");

        this.countZeroInit = countZeroInit;
    }

    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("ExitKeyCommand.execute()...");

        countZeroInit.setCurrentState(countZeroInit.getGameState());

        GameState gameState = (GameState) countZeroInit.getGameState();
        gameState.setPlayer();
    }
}
