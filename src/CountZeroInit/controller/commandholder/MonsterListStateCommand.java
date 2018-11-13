package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.CountZeroInit;

public class MonsterListStateCommand implements Command {
    CountZeroInit countZeroInit;

    public MonsterListStateCommand(CountZeroInit countZeroInit) {
        // The following println() is just to see where MonsterListStateCommand's constructor is called in the output.
        System.out.println("MonsterListStateCommand.constructor...");

        this.countZeroInit = countZeroInit;
    }

    @Override
    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("MonsterListStateCommand.execute()...");

        countZeroInit.setCurrentState(countZeroInit.getMonsterListState());

    }
}
