package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;

public class IntroPanel extends JPanel {
    CountZeroInit countZeroInit;
    JTextField userWelcomeMessage;
    JTextField userInputField;
    String introMessage = "Welcome to the grid, player1.";

    public IntroPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

        setFocusable(true);

        userWelcomeMessage = new JTextField(introMessage);

        userInputField = new JTextField("To enter the grid, please define your handle: ", 60);
        userInputField.setFocusable(true);

        this.add(userWelcomeMessage);
        this.add(userInputField);

        this.getComponent(1).requestFocus();
    }



}
