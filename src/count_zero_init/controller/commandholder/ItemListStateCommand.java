package count_zero_init.controller.commandholder;

import count_zero_init.controller.CountZeroInit;
import count_zero_init.controller.state.ItemListState;

public class ItemListStateCommand implements Command {
    CountZeroInit countZeroInit;

    public ItemListStateCommand(CountZeroInit countZeroInit) {
        // The following println() is just to see where ItemListStateCommand's constructor is called in the output.
        System.out.println("ItemListStateCommand.constructor...");

        this.countZeroInit = countZeroInit;
    }

    public void execute() {
        // The following println() is just to see where execute() is called in the output.
        System.out.println("ItemListStateCommand.execute()...");

        countZeroInit.setCurrentState(countZeroInit.getItemListState());

        ItemListState itemListState = (ItemListState) countZeroInit.getItemListState();
        itemListState.setPlayer();
    }
}
