package MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import java.awt.*;

public class Act1SeedHunt extends JPanel {
    JPanel displayPanel;
    JPanel buttonPanel;
    JPanel inputPanel;
    Font guiFont;

    JTextField inputTextField;
    JButton inventoryButton;
    JButton pauseButton;

    public Act1SeedHunt() {
        displayPanel = new PicturePanel();
        buttonPanel = new JPanel();
        inputPanel = new JPanel();
        guiFont = new Font("SansSerif", Font.BOLD, 8);

        setFont(guiFont);

        inputTextField = new JTextField("player1's input: ", 30);
        inventoryButton = new JButton("inventory");
        pauseButton = new JButton("pause");

        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputTextField);

        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(inventoryButton);
        buttonPanel.add(pauseButton);

        displayPanel.setSize(480, 360);


        setSize(600, 480);
        setLayout(new BorderLayout());

        add(inputPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.EAST);
        add(displayPanel, BorderLayout.CENTER);

        setVisible(true);
    }

}
