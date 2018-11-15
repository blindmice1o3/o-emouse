package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.creatures.Monster;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MonsterListPanel extends JPanel {
    CountZeroInit countZeroInit;
    List<Monster> allMonsterList;

    public MonsterListPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString("MonsterListPanel", 10, 10);
    }
}
