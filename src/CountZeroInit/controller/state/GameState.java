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

        numberOfItems = player1.getInventory().size();

        System.out.println(numberOfItems);
        System.out.println(player1.getInventory());
        System.out.println(player1.getMyMonsterList());
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

        gb.setCurrentState(gb.getStartMenuState());
    }

    @Override
    public void upButtonPressed() {
       System.out.println("upButtonPressed() for GameState class");

       if (player1.getCol() != 0) {
           player1.setCol((player1.getCol() - 1));
       } else {
           // maybe cycle back to the bottom of the map...
       }

       // refresh picture?
    }

    @Override
    public void downButtonPressed() {
        System.out.println("downButtonPressed() for GameState class");

        if (player1.getCol() != 19) {
            player1.setCol((player1.getCol() + 1));
        } else {
            // maybe cycle back to top of the map...
        }

        // refresh picture?
    }

    @Override
    public void rightButtonPressed() {
        System.out.println("rightButtonPressed() for GameState class");

        if (player1.getRow() != 19) {
            player1.setRow((player1.getRow() + 1));
        } else {
            // maybe cycle back to left of the map...
        }

        // refresh picture?
    }

    @Override
    public void leftButtonPressed() {
        System.out.println("leftButtonPressed() for GameState class");

        if (player1.getRow() != 0) {
            player1.setRow((player1.getRow() - 1));
        } else {
            // maybe cycle back to right of the map...
        }

        // refresh picture?
    }
}
