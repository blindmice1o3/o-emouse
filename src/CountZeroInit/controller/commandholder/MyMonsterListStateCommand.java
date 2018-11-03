package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.controller.state.MyMonsterListState;

public class MyMonsterListStateCommand implements Command {
    GameboyColor gb;

    public MyMonsterListStateCommand(GameboyColor gb) {
        this.gb = gb;
    }

    public void execute() {
        gb.setCurrentState(gb.getMyMonsterListState());

        MyMonsterListState myMonsterListState = (MyMonsterListState)gb.getMyMonsterListState();
        myMonsterListState.setPlayer();
    }
}
