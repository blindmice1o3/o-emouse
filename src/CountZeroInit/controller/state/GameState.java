package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.LifeForm;

public class GameState implements State {
    private GameboyColor gb;
    Humanoid player1;
    int numberOfItems;

    public GameState(GameboyColor gb) {
        this.gb = gb;
    }

    // !!!!! CURRENTLY WORKING ON !!!!!
    public void setPlayer() {
        // From the list of LifeForm that are on the board at the start of this Map, find and set player.
        // The following println() is just to see where setPlayer() is called in the output.
        System.out.println("!!!!!!!!!!!!!!!!");
        player1 = gb.getPlayer1();
/*
        for (LifeForm lifeForm: gb.getCurrentMap().getMapSpec().getLifeFormsOnBoard()) {
            if (lifeForm.getType().equals("humanoid")) {
                player1 = (Humanoid)lifeForm;
            }
        }
*/
        numberOfItems = player1.inventory.size();

        System.out.println(numberOfItems);
        System.out.println(player1.inventory);
        System.out.println(player1.monsters);
    }

    @Override
    public void aButtonPressed() {
        System.out.println("Pressed button: A");
    }

    @Override
    public void bButtonPressed() {
        System.out.println("Pressed button: B");
    }

    @Override
    public void selectButtonPressed() {
        System.out.println("Pressed button: select");
    }

    @Override
    public void startButtonPressed() {
        System.out.println("Pressed button: start");
    }

    @Override
    public void upButtonPressed() {
       // if (player1.getLocation())
    }

    @Override
    public void downButtonPressed() {

    }

    @Override
    public void rightButtonPressed() {

    }

    @Override
    public void leftButtonPressed() {

    }
}
