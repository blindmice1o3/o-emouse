package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;

public class MonsterListStateCommand implements Command {
    GameboyColor gb;

    public MonsterListStateCommand(GameboyColor gb) {
        this.gb = gb;
    }

    @Override
    public void execute() {
        gb.setCurrentState(gb.getMonsterListState());
    }
}
