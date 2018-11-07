package CountZeroInit.controller.state;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.Humanoid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntroState implements State {
    private GameboyColor gb;
    Humanoid player1;

    public IntroState(GameboyColor gb) {
        // The following println() is just to see where IntroState's constructor is called in the output.
        System.out.println("IntroState.constructor...");

        this.gb = gb;
        player1 = gb.getPlayer1();

    }

    @Override
    public void aButtonPressed() {
        // The following println() is just to see where aButtonPressed() is called in the output.
        System.out.println("IntroState.aButtonPressed()...");

    }

    @Override
    public void bButtonPressed() {
        // The following println() is just to see where bButtonPressed() is called in the output.
        System.out.println("IntroState.bButtonPressed()...");

    }

    @Override
    public void selectButtonPressed() {
        // The following println() is just to see where selectButtonPressed() is called in the output.
        System.out.println("IntroState.selectButtonPressed()...");

    }

    @Override
    public void startButtonPressed() {
        // The following println() is just to see where startButtonPressed() is called in the output.
        System.out.println("IntroState.startButtonPressed()...");


        System.out.println("Hello player1\nWhat is your name?\n");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            player1.setName(input.readLine());
        } catch (IOException exception) {
            System.out.println("failed to readLine() for player1.setName()");
        }

        System.out.println("\nIt's nice to meet you " + player1.getName() + ".\n");
        System.out.println("\nA wild " + gb.getLifeFormsOnBoard().get(0).getType() + " appeared!\nWould you like to:\n(Keep it) or (Leave it alone)?");

        String player1Response = "";

        try {
            player1Response = input.readLine();
        } catch (IOException exception) {
            System.out.println("failed to readLine() for player1Response");
        }

        if (player1Response.startsWith("keep")) {
            System.out.println("Okay, let's go nab our first Monster!");
            gb.setCurrentState(gb.getGameState());
            gb.update();
        } else if (player1Response.startsWith("leave")) {
            System.out.println("You've made PETA proud!");
        } else {
            System.out.println("I don't understand your command.");
        }

    }

    @Override
    public void upButtonPressed() {
        // The following println() is just to see where upButtonPressed() is called in the output.
        System.out.println("IntroState.upButtonPressed()...");

    }

    @Override
    public void downButtonPressed() {
        // The following println() is just to see where downButtonPressed() is called in the output.
        System.out.println("IntroState.downButtonPressed()...");

    }

    @Override
    public void rightButtonPressed() {
        // The following println() is just to see where rightButtonPressed() is called in the output.
        System.out.println("IntroState.rightButtonPressed()...");

    }

    @Override
    public void leftButtonPressed() {
        // The following println() is just to see where leftButtonPressed() is called in the output.
        System.out.println("IntroState.leftButtonPressed()...");

    }
}
