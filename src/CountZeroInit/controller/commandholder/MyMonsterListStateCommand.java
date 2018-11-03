package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.controller.state.MyMonsterListState;

public class MyMonsterListStateCommand implements Command {
    GameboyColor gb;

    public MyMonsterListStateCommand(GameboyColor gb) {
        // The following println() is just to see where MyMonsterListStateCommand's constructor is called in the output.
        System.out.println("MyMonsterListStateCommand.constructor...");

        this.gb = gb;
    }

    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("MyMonsterListStateCommand.execute()...");

        gb.setCurrentState(gb.getMyMonsterListState());

        MyMonsterListState myMonsterListState = (MyMonsterListState)gb.getMyMonsterListState();
        myMonsterListState.setPlayer();
    }
}
