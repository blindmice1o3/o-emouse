package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.LifeForm;

public class MyMonsterListState implements State {
    private GameboyColor gb;
    Humanoid player1;
    int numberOfMonsters;
    int currentIndexForSelectingMonster;

    public MyMonsterListState(GameboyColor gb) {
        this.gb = gb;
    }

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
        currentIndexForSelectingMonster = 0;
        numberOfMonsters = player1.monsters.size();

        System.out.println(numberOfMonsters);
        System.out.println(currentIndexForSelectingMonster);
    }

    @Override
    public void aButtonPressed() {
        // prints out the Monster selected by the currentIndexForSelectingMonster
        // actually no... it's going to display a list of things that can be done...
        // such as selecting the first Monster to be swap in the monsters[] position with the next Monster selected with aButtonPress()
        // such as displaying stats about that selected Monster's description and class
        // such as displaying [the soon to be added feature] the 4 skills each Monster will have
        // such as displaying [the soon to be added feature] xp points, level, xp needed for next level
        System.out.println(player1.monsters.get(currentIndexForSelectingMonster));
    }

    @Override
    public void bButtonPressed() {
        // Undo button ???
    }

    @Override
    public void selectButtonPressed() {

    }

    @Override
    public void startButtonPressed() {
        gb.setCurrentState(gb.getGameState());
    }

    @Override
    public void upButtonPressed() {
        if (currentIndexForSelectingMonster > 0) {
            currentIndexForSelectingMonster--;
        } else {
            currentIndexForSelectingMonster = (numberOfMonsters - 1);
        }
    }

    @Override
    public void downButtonPressed() {
        if (currentIndexForSelectingMonster < (numberOfMonsters-1)) {
            currentIndexForSelectingMonster++;
        } else {
            currentIndexForSelectingMonster = 0;
        }
    }

    @Override
    public void rightButtonPressed() {

    }

    @Override
    public void leftButtonPressed() {

    }
}
