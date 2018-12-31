package count_zero_init.view;

import count_zero_init.controller.CountZeroInit;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {
    CountZeroInit countZeroInit;

    public BattlePanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString("BattlePanel", 10, 10);
    }
}
