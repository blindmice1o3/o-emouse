package MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import java.awt.*;

public class IntroFramePanel extends JPanel {
    //////////////////////////////////
    /////////// Seed Hunt ////////////
    //////////////////////////////////
    JPanel mainDisplayPanel;
    JPanel secondaryDisplayPanel;
    JPanel inputTextPanel;

    int width;
    int height;
    Font guiFont;

    JTextField inputTextField;
    JButton inventoryButton;
    JButton pauseButton;

    public IntroFramePanel(int width, int height) {
        this.width = width;
        this.height = height;
        guiFont = new Font("SansSerif", Font.BOLD, 8);
        setFont(guiFont);

        mainDisplayPanel = new CyberpunkWallpapersPanel(this.width-50, this.height-50);
        mainDisplayPanel.repaint();

        secondaryDisplayPanel = new JPanel();
        inputTextPanel = new JPanel();

        inputTextField = new JTextField("player1's input: ", 30);
        inventoryButton = new JButton("inventory");
        pauseButton = new JButton("pause");

        //
        mainDisplayPanel.add(inventoryButton);
        //

        inputTextPanel.setLayout(new FlowLayout());
        inputTextPanel.add(inputTextField);

        secondaryDisplayPanel.setLayout(new GridLayout(3, 1));
        //secondaryDisplayPanel.add(inventoryButton);
        secondaryDisplayPanel.add(pauseButton);

        this.setSize(this.getWidth(), this.getHeight());
        this.setLayout(new BorderLayout());

        this.add(inputTextPanel, BorderLayout.SOUTH);
        this.add(secondaryDisplayPanel, BorderLayout.EAST);
        this.add(mainDisplayPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
