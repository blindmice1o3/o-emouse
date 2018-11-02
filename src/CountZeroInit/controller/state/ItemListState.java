package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.items.PlasticSpork;

import java.util.List;

public class ItemListState implements State {
    private GameboyColor gb;
    Humanoid player1;
    int numberOfItems;
    int currentIndexForSelectingItem;

    public ItemListState(GameboyColor gb) {
        this.gb = gb;
    }

    // !!!!! CURRENTLY WORKING ON !!!!!
    public void setPlayer() {
        // From the list of LifeForm that are on the board at the start of this Map, find and set player.
        System.out.println("!!!!!!!!!!!!!!!!");

        for (LifeForm lifeForm: gb.getCurrentMap().getMapSpec().getLifeFormsOnBoard()) {
            if (lifeForm.getType().equals("humanoid")) {
                player1 = (Humanoid)lifeForm;
            }
        }
        currentIndexForSelectingItem = 0;
        numberOfItems = player1.inventory.size();

        System.out.println(numberOfItems);
        System.out.println(player1.inventory);
        System.out.println(currentIndexForSelectingItem);
    }

    @Override
    public void aButtonPressed() {
        System.out.println(player1.inventory.get(currentIndexForSelectingItem));
    }

    @Override
    public void bButtonPressed() {

    }

    @Override
    public void selectButtonPressed() {

    }

    @Override
    public void startButtonPressed() {

    }

    @Override
    public void upButtonPressed() {
        if (currentIndexForSelectingItem > 0) {
            currentIndexForSelectingItem--;
        } else {
            currentIndexForSelectingItem = numberOfItems;
        }
    }

    @Override
    public void downButtonPressed() {
        if (currentIndexForSelectingItem < (numberOfItems-1)) {
            currentIndexForSelectingItem++;
        } else {
            currentIndexForSelectingItem = 0;
        }
    }

    @Override
    public void rightButtonPressed() {

    }

    @Override
    public void leftButtonPressed() {

    }
}
