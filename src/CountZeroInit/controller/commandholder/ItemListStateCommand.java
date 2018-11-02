package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.controller.state.ItemListState;

public class ItemListStateCommand implements Command {
    GameboyColor gb;

    public ItemListStateCommand(GameboyColor gb) {
        this.gb = gb;
    }

    public void execute() {

        gb.setCurrentState(gb.getItemListState());

        ItemListState itemListState = (ItemListState)gb.getItemListState();
        itemListState.setPlayer();
    }
}
