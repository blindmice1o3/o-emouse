package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.creatures.Monster;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyMonsterListPanel extends JPanel {
    CountZeroInit countZeroInit;
    List<Monster> myMonsterList;

    public MyMonsterListPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

        myMonsterList = countZeroInit.getPlayer1().getMyMonsterList();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString(myMonsterList.toString(),10, 10);
    }
}
