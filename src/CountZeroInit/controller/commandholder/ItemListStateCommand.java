package CountZeroInit.controller.commandholder;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.controller.state.ItemListState;

public class ItemListStateCommand implements Command {
    GameboyColor gb;

    public ItemListStateCommand(GameboyColor gb) {
        // The following println() is just to see where ItemListStateCommand's constructor is called in the output.
        System.out.println("ItemListStateCommand.constructor...");

        this.gb = gb;
    }

    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("ItemListStateCommand.execute()...");

        gb.setCurrentState(gb.getItemListState());

        ItemListState itemListState = (ItemListState)gb.getItemListState();
        itemListState.setPlayer();
    }
}
