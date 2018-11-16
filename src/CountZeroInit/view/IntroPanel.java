package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroPanel extends JPanel {
    CountZeroInit countZeroInit;
    JTextField userWelcomeMessage;
    String introMessage = "player1, please define your handle to enter the grid: ";

    JTextField userInputField;

    public IntroPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

        this.setFocusable(true);

        userWelcomeMessage = new JTextField(introMessage);
        userWelcomeMessage.setMargin( new Insets(5, 5, 5, 5));
        userWelcomeMessage.setEditable(false);

        userInputField = new JTextField(60);
        userInputField.setMargin( new Insets(5, 5, 5, 5));
        userInputField.setFocusable(true);


        this.add(userWelcomeMessage);
        this.add(userInputField);



        userInputField.requestFocusInWindow();
    }

}
