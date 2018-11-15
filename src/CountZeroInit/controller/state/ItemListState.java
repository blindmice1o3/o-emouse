package CountZeroInit.controller.state;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.creatures.Humanoid;

import java.awt.event.KeyEvent;

public class ItemListState implements State {
    private CountZeroInit countZeroInit;
    Humanoid player1;
    int numberOfItems;
    int currentIndexForSelectingItem;

    public ItemListState(CountZeroInit countZeroInit) {
        // The following println() is just to see where ItemListState's constructor is called in the output.
        System.out.println("ItemListState.constructor...");

        this.countZeroInit = countZeroInit;
    }
    public void gameKeyPressed(int keyCode) {

        switch (keyCode) {
            case KeyEvent.VK_W:
                upButtonPressed();
                break;
            case KeyEvent.VK_S:
                downButtonPressed();
                break;
            case KeyEvent.VK_A:
                leftButtonPressed();
                break;
            case KeyEvent.VK_D:
                rightButtonPressed();
                break;
        }
        // refresh picture?
        countZeroInit.getDisplayer().redrawPanel();
    }

    public void setPlayer() {
        // The following println() is just to see where setPlayer() is called in the output.
        System.out.println("ItemListState.setPlayer()...");

        // Sets ItemListState's instance variable player1 to refer to the CountZeroInit object's player1 object.
        player1 = countZeroInit.getPlayer1();

        // Initiate the currentIndexForSelectingItem instance variable to 0 by default.
        // Initiate the numberOfItems instance variable to however many the player1 object has in its myItemList ArrayList.
        currentIndexForSelectingItem = 0;
        numberOfItems = player1.getMyItemList().size();

        // The following println() are just to see if setPlayer() is really setting our player1 variable and we're
        // really getting player1's inventory size.
        System.out.println("ItemListState.setPlayer() initiating numberOfItems variable: " + numberOfItems);
        System.out.println("ItemListState.setPlayer()... this is player1's inventory: " + player1.getMyItemList());
    }

    @Override
    public void aButtonPressed() {
        // So far just printing out the selected item, rather than executing a command for using the selected item.

        // The following println() is just to see where aButtonPressed() is called in the output.
        System.out.println("ItemListState.aButtonPressed()...");

        System.out.println(player1.getMyItemList().get(currentIndexForSelectingItem));
    }

    @Override
    public void bButtonPressed() {
        // Undo button ???

        // The following println() is just to see where bButtonPressed() is called in the output.
        System.out.println("ItemListState.bButtonPressed()...");

    }

    @Override
    public void selectButtonPressed() {
        // The following println() is just to see where selectButtonPressed() is called in the output.
        System.out.println("ItemListState.selectButtonPressed()...");

    }

    @Override
    public void startButtonPressed() {
        // The following println() is just to see where startButtonPressed() is called in the output.
        System.out.println("ItemListState.startButtonPressed()...");

        countZeroInit.setCurrentState(countZeroInit.getGameState());
    }

    @Override
    public void upButtonPressed() {
        // The following println() is just to see where upButtonPressed() is called in the output.
        System.out.println("ItemListState.upButtonPressed()...");

        if (currentIndexForSelectingItem > 0) {
            currentIndexForSelectingItem--;
        } else {
            currentIndexForSelectingItem = (numberOfItems-1);
        }
    }

    @Override
    public void downButtonPressed() {
        // The following println() is just to see where downButtonPressed() is called in the output.
        System.out.println("ItemListState.downButtonPressed()...");

        if (currentIndexForSelectingItem < (numberOfItems-1)) {
            currentIndexForSelectingItem++;
        } else {
            currentIndexForSelectingItem = 0;
        }
    }

    @Override
    public void rightButtonPressed() {
        // The following println() is just to see where rightButtonPressed() is called in the output.
        System.out.println("ItemListState.rightButtonPressed()...");

    }

    @Override
    public void leftButtonPressed() {
        // The following println() is just to see where leftButtonPressed() is called in the output.
        System.out.println("ItemListState.leftButtonPressed()...");

    }

    @Override
    public String toString() {
        return "ItemList";
    }
}
