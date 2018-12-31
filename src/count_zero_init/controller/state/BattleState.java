package count_zero_init.controller.state;

import count_zero_init.controller.CountZeroInit;
import count_zero_init.model.creatures.Humanoid;

public class BattleState implements State {
    private CountZeroInit countZeroInit;
    Humanoid player1;

    public BattleState(CountZeroInit countZeroInit) {
        // The following println() is just to see where BattleState's constructor is called in the output.
        System.out.println("BattleState.constructor...");

        this.countZeroInit = countZeroInit;
        player1 = countZeroInit.getPlayer1();
    }
    public void gameKeyPressed(int keyCode) {}

    public void initiateBattle() {
        // The following println() is just to see where initiateBattle() is called in the output.
        System.out.println("BattleState.initiateBattle()...");

        // while (/*monsters still have hp*/) {
            // a.fight(b);
            // b.fight(a);
        // }
    }

    @Override
    public void aButtonPressed() {
        // The following println() is just to see where aButtonPressed() is called in the output.
        System.out.println("BattleState.aButtonPressed()...");

    }

    @Override
    public void bButtonPressed() {
        // The following println() is just to see where bButtonPressed() is called in the output.
        System.out.println("BattleState.bButtonPressed()...");

    }

    @Override
    public void selectButtonPressed() {
        // The following println() is just to see where selectButtonPressed() is called in the output.
        System.out.println("BattleState.selectButtonPressed()...");

    }

    @Override
    public void startButtonPressed() {
        // The following println() is just to see where startButtonPressed() is called in the output.
        System.out.println("BattleState.startButtonPressed()...");

    }

    @Override
    public void upButtonPressed() {
        // The following println() is just to see where upButtonPressed() is called in the output.
        System.out.println("BattleState.upButtonPressed()...");

    }

    @Override
    public void downButtonPressed() {
        // The following println() is just to see where downButtonPressed() is called in the output.
        System.out.println("BattleState.downButtonPressed()...");

    }

    @Override
    public void rightButtonPressed() {
        // The following println() is just to see where rightButtonPressed() is called in the output.
        System.out.println("BattleState.rightButtonPressed()...");

    }

    @Override
    public void leftButtonPressed() {
        // The following println() is just to see where leftButtonPressed() is called in the output.
        System.out.println("BattleState.leftButtonPressed()...");

    }

    @Override
    public String toString() {
        return "Battle";
    }
}
