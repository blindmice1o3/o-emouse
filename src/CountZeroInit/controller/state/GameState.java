package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.Humanoid;

public class GameState implements State {
    private GameboyColor gb;
    Humanoid player1;

    public GameState(GameboyColor gb) {
        // The following println() is just to see where GameState's constructor is called in the output.
        System.out.println("GameState.constructor...");

        this.gb = gb;
    }

    public void setPlayer() {
        // The following println() is just to see where setPlayer() is called in the output.
        System.out.println("GameState.setPlayer()...");

        // Sets GameState's instance variable player1 to refer to the GameboyColor object's player1 object.
        player1 = gb.getPlayer1();


        // The following println() are just to see if setPlayer() is really setting our player1 variable and we're
        // really getting player1's inventory and monster list.
        System.out.println("GameState.setPlayer() initialized the player1 instance variable's inventory as: " + player1.getInventory());
        System.out.println("GameState.setPlayer() initiatized the player1 instance variable's monster list as: " + player1.getMyMonsterList());
    }

    @Override
    public void aButtonPressed() {
        // The following println() is just to see where aButtonPressed() is called in the output.
        System.out.println("GameState.aButtonPressed()...");
    }

    @Override
    public void bButtonPressed() {
        // The following println() is just to see where bButtonPressed() is called in the output.
        System.out.println("GameState.bButtonPressed()...");
    }

    @Override
    public void selectButtonPressed() {
        // The following println() is just to see where selectButtonPressed() is called in the output.
        System.out.println("GameState.selectButtonPressed()...");
    }

    @Override
    public void startButtonPressed() {
        // The following println() is just to see where startButtonPressed() is called in the output.
        System.out.println("GameState.startButtonPressed()...");

        gb.setCurrentState(gb.getStartMenuState());
    }

    @Override
    public void upButtonPressed() {
        // The following println() is just to see where upButtonPressed() is called in the output.
        System.out.println("GameState.upButtonPressed()...");

       if (player1.getRow() != 0) {
           player1.setRow((player1.getRow() - 1));
       } else {
           // maybe cycle back to the bottom of the map...
       }

       // refresh picture?


        //gb.update();
    }

    @Override
    public void downButtonPressed() {
        // The following println() is just to see where downButtonPressed() is called in the output.
        System.out.println("GameState.downButtonPressed()...");

        if (player1.getRow() != 19) {
            player1.setRow((player1.getRow() + 1));
        } else {
            // maybe cycle back to top of the map...
        }

        // refresh picture?


       // gb.update();
    }

    @Override
    public void rightButtonPressed() {
        // The following println() is just to see where rightButtonPressed() is called in the output.
        System.out.println("GameState.rightButtonPressed()...");

        if (player1.getCol() != 19) {
            player1.setCol((player1.getCol() + 1));
        } else {
            // maybe cycle back to left of the map...
        }

        // refresh picture?


        //gb.update();
    }

    @Override
    public void leftButtonPressed() {
        // The following println() is just to see where leftButtonPressed() is called in the output.
        System.out.println("GameState.leftButtonPressed()...");

        if (player1.getCol() != 0) {
            player1.setCol((player1.getCol() - 1));
        } else {
            // maybe cycle back to right of the map...
        }

        // refresh picture?


        //gb.update();
    }
}
