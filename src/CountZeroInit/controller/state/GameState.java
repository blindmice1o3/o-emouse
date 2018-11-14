package CountZeroInit.controller.state;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.creatures.Humanoid;

import java.awt.event.KeyEvent;

public class GameState implements State {
    private CountZeroInit countZeroInit;
    Humanoid player1;

    public GameState(CountZeroInit countZeroInit) {
        // The following println() is just to see where GameState's constructor is called in the output.
        System.out.println("GameState.constructor...");

        this.countZeroInit = countZeroInit;
        setPlayer();
    }

    public void setPlayer() {
        // The following println() is just to see where setPlayer() is called in the output.
        System.out.println("GameState.setPlayer()...");

        // Sets GameState's instance variable player1 to refer to the CountZeroInit object's player1 object.
        player1 = countZeroInit.getPlayer1();


        // The following println() are just to see if setPlayer() is really setting our player1 variable and we're
        // really getting player1's inventory and monster list.
        System.out.println("GameState.setPlayer() initialized the player1 instance variable's inventory as: " + player1.getMyItemList());
        System.out.println("GameState.setPlayer() initiatized the player1 instance variable's monster list as: " + player1.getMyMonsterList());
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

        countZeroInit.setCurrentState(countZeroInit.getStartMenuState());
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

        //countZeroInit.update();
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

       // countZeroInit.update();
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

        //countZeroInit.update();
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

        //countZeroInit.update();
    }

    @Override
    public String toString() {
        return "GameState";
    }
}
