package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;
import java.awt.*;

public class IntroPanel extends JPanel {
    CountZeroInit countZeroInit;
    String introMessage = "Welcome to the grid, player1.\n\nDefine your handle to continue: \n";

    public IntroPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString(introMessage, (countZeroInit.getDisplayer().getSize().width) / 2 , (countZeroInit.getDisplayer().getSize().height) / 2);

    }
}
