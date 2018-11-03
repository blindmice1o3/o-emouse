package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;

public class MonsterListStateCommand implements Command {
    GameboyColor gb;

    public MonsterListStateCommand(GameboyColor gb) {
        // The following println() is just to see where MonsterListStateCommand's constructor is called in the output.
        System.out.println("MonsterListStateCommand.constructor...");

        this.gb = gb;
    }

    @Override
    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("MonsterListStateCommand.execute()...");

        gb.setCurrentState(gb.getMonsterListState());

    }
}
