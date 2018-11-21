package CountLegacyInit;

import javax.swing.*;
import java.awt.*;

public class CountLegacyStart extends JFrame {
    JPanel framePanel;
    int width;
    int height;

    JPanel displayPanel;
    JPanel textInputPanel;

    JTextField textInput;

    public CountLegacyStart() {
        width = 600;
        height = 480;

        framePanel = new JPanel();
        framePanel.setPreferredSize(new Dimension(width, height));

        displayPanel = new BackgroundDisplayPanel(width, height-80);
        displayPanel.setPreferredSize( new Dimension(width, height-80));
        displayPanel.setVisible(true);
        displayPanel.repaint();

        textInputPanel = new JPanel();
        textInput = new JTextField("player1's input: ", 30);
        textInputPanel.add(textInput);

        framePanel.setLayout(new BorderLayout());
        framePanel.add(displayPanel, BorderLayout.CENTER);
        framePanel.add(textInputPanel, BorderLayout.SOUTH);
        framePanel.setVisible(true);

        this.setContentPane(framePanel);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        this.setVisible(true);
        this.repaint();
    }

    public static void main(String[] args) {
        CountLegacyStart countLegacyStart = new CountLegacyStart();
        countLegacyStart.init();
    }
}
