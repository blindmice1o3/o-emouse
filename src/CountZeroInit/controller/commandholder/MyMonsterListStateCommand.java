package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.controller.state.MyMonsterListState;

public class MyMonsterListStateCommand implements Command {
    CountZeroInit countZeroInit;

    public MyMonsterListStateCommand(CountZeroInit countZeroInit) {
        // The following println() is just to see where MyMonsterListStateCommand's constructor is called in the output.
        System.out.println("MyMonsterListStateCommand.constructor...");

        this.countZeroInit = countZeroInit;
    }

    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("MyMonsterListStateCommand.execute()...");

        countZeroInit.setCurrentState(countZeroInit.getMyMonsterListState());

        MyMonsterListState myMonsterListState = (MyMonsterListState) countZeroInit.getMyMonsterListState();
        myMonsterListState.setPlayer();
    }
}
