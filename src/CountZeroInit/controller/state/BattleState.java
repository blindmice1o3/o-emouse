package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;

public class BattleState implements State {
    private GameboyColor gb;

    public BattleState(GameboyColor gb) {
        this.gb = gb;
    }

    public void initiateBattle() {
        // while (/*monsters still have hp*/) {
            // a.fight(b);
            // b.fight(a);
        // }
    }



    @Override
    public void aButtonPressed() {

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
