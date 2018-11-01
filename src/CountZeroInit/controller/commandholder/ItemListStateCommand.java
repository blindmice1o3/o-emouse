package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;

public class ItemListStateCommand implements Command {
    GameboyColor gb;

    public ItemListStateCommand(GameboyColor gb) {
        this.gb = gb;
    }

    public void execute() {
        gb.setCurrentState(gb.getItemListState());
    }
}
