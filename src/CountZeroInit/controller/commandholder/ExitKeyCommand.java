package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.controller.state.GameState;

public class ExitKeyCommand implements Command {
    GameboyColor gb;

    public ExitKeyCommand(GameboyColor gb) {
        this.gb = gb;
    }

    public void execute() {

        gb.setCurrentState(gb.getGameState());

        GameState gameState = (GameState)gb.getGameState();
        gameState.setPlayer();
    }
}
