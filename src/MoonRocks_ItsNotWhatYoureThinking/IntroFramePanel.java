package MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import javax.swing.JPanel;
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

        int mainDisplayPanelWidth = (int)(this.getWidth() * (4/5));
        int mainDisplayPanelHeight = (int) (this.getHeight() * (4/5));


        mainDisplayPanel = new CyberpunkWallpapersPanel(mainDisplayPanelWidth, mainDisplayPanelHeight);
        mainDisplayPanel.repaint();
        //mainDisplayPanel.setSize(mainDisplayPanelWidth, mainDisplayPanelHeight);
        secondaryDisplayPanel = new JPanel();
        inputTextPanel = new JPanel();

        inputTextField = new JTextField("player1's input: ", 30);
        inventoryButton = new JButton("inventory");
        pauseButton = new JButton("pause");

        inputTextPanel.setLayout(new FlowLayout());
        inputTextPanel.add(inputTextField);

        secondaryDisplayPanel.setLayout(new GridLayout(3, 1));
        secondaryDisplayPanel.add(inventoryButton);
        secondaryDisplayPanel.add(pauseButton);

        this.setSize(this.getWidth(), this.getHeight());
        this.setLayout(new BorderLayout());

        this.add(inputTextPanel, BorderLayout.SOUTH);
        this.add(secondaryDisplayPanel, BorderLayout.EAST);
        this.add(mainDisplayPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
