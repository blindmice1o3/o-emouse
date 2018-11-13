package CountZeroInit.controller.state;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.creatures.Humanoid;

public class MyMonsterListState implements State {
    private CountZeroInit countZeroInit;
    Humanoid player1;
    int numberOfMonsters;
    int currentIndexForSelectingMonster;

    public MyMonsterListState(CountZeroInit countZeroInit) {
        // The following println() is just to see where MyMonsterListState's constructor is called in the output.
        System.out.println("MyMonsterListState.constructor...");

        this.countZeroInit = countZeroInit;
    }

    public void setPlayer() {
        // The following println() is just to see where setPlayer() is called in the output.
        System.out.println("MyMonsterListState.setPlayer()...");

        // Sets MyMonsterListState's instance variable player1 to refer to the CountZeroInit object's player1 object.
        player1 = countZeroInit.getPlayer1();

        // Initiate the currentIndexForSelectingMonster instance variable to 0 by default.
        // Initiate the numberOfMonsters instance variable to however many the player1 object has in its myMonsterList ArrayList.
        currentIndexForSelectingMonster = 0;
        numberOfMonsters = player1.getMyMonsterList().size();

        // The following println() are just to see if setPlayer() is really setting our player1 variable and we're
        // really getting player1's monster list size.
        System.out.println("MyMonsterListState.setPlayer() initiating numberOfMonster variable: " + numberOfMonsters);
    }

    @Override
    public void aButtonPressed() {
        // prints out the Monster selected by the currentIndexForSelectingMonster

        // actually no... it's going to display a list of things that can be done...
        // such as selecting the first Monster to be swap in the monsters[] position with the next Monster selected with aButtonPress()
        // such as displaying stats about that selected Monster's description and class
        // such as displaying [the soon to be added feature] the 4 skills each Monster will have
        // such as displaying [the soon to be added feature] xp points, level, xp needed for next level

        // The following println() is just to see where aButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.aButtonPressed()...");

        System.out.println(player1.getMyMonsterList().get(currentIndexForSelectingMonster));
    }

    @Override
    public void bButtonPressed() {
        // Undo button ???

        // The following println() is just to see where bButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.bButtonPressed()...");

    }

    @Override
    public void selectButtonPressed() {
        // The following println() is just to see where selectButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.selectButtonPressed()...");

    }

    @Override
    public void startButtonPressed() {
        // The following println() is just to see where startButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.startButtonPressed()...");

        countZeroInit.setCurrentState(countZeroInit.getGameState());
    }

    @Override
    public void upButtonPressed() {
        // The following println() is just to see where upButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.upButtonPressed()...");

        if (currentIndexForSelectingMonster > 0) {
            currentIndexForSelectingMonster--;
        } else {
            currentIndexForSelectingMonster = (numberOfMonsters - 1);
        }
    }

    @Override
    public void downButtonPressed() {
        // The following println() is just to see where downButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.downButtonPressed()...");

        if (currentIndexForSelectingMonster < (numberOfMonsters-1)) {
            currentIndexForSelectingMonster++;
        } else {
            currentIndexForSelectingMonster = 0;
        }
    }

    @Override
    public void rightButtonPressed() {
        // The following println() is just to see where rightButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.rightButtonPressed()...");

    }

    @Override
    public void leftButtonPressed() {
        // The following println() is just to see where leftButtonPressed() is called in the output.
        System.out.println("MyMonsterListState.leftButtonPressed()...");

    }

    @Override
    public String toString() {
        return "MyMonsterListState";
    }
}
