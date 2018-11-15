package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.items.Item;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ItemListPanel extends JPanel {
    CountZeroInit countZeroInit;
    List<Item> myItemList;

    public ItemListPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

        myItemList = countZeroInit.getPlayer1().getMyItemList();


        JList itemList = new JList(myItemList.toArray());
        add(itemList);
    }
/*
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString(myItemList.toString(), 10, 10);
    }
*/
}
