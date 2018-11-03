package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;

public class MonsterListState implements State {
    private GameboyColor gb;

    public MonsterListState(GameboyColor gb) {
        // The following println() is just to see where MonsterListState's constructor is called in the output.
        System.out.println("MonsterListState.constructor...");

        this.gb = gb;
    }


    // !!!!! CURRENTLY WORKING ON !!!!!


    @Override
    public void aButtonPressed() {
        // The following println() is just to see where aButtonPressed() is called in the output.
        System.out.println("MonsterListState.aButtonPressed()...");

    }

    @Override
    public void bButtonPressed() {
        // The following println() is just to see where bButtonPressed() is called in the output.
        System.out.println("MonsterListState.bButtonPressed()...");

    }

    @Override
    public void selectButtonPressed() {
        // The following println() is just to see where selectButtonPressed() is called in the output.
        System.out.println("MonsterListState.selectButtonPressed()...");

    }

    @Override
    public void startButtonPressed() {
        // The following println() is just to see where startButtonPressed() is called in the output.
        System.out.println("MonsterListState.startButtonPressed()...");

    }

    @Override
    public void upButtonPressed() {
        // The following println() is just to see where upButtonPressed() is called in the output.
        System.out.println("MonsterListState.upButtonPressed()...");

    }

    @Override
    public void downButtonPressed() {
        // The following println() is just to see where downButtonPressed() is called in the output.
        System.out.println("MonsterListState.downButtonPressed()...");

    }

    @Override
    public void rightButtonPressed() {
        // The following println() is just to see where rightButtonPressed() is called in the output.
        System.out.println("MonsterListState.rightButtonPressed()...");

    }

    @Override
    public void leftButtonPressed() {
        // The following println() is just to see where leftButtonPressed() is called in the output.
        System.out.println("MonsterListState.leftButtonPressed()...");

    }
}
