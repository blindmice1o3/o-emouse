package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.items.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class ItemListPanel extends JPanel
        implements KeyListener {
    CountZeroInit countZeroInit;
    List<Item> myItemList;
    JList itemList;
    String arrowImageAddress;
    Image arrowImage;

    public ItemListPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

        arrowImageAddress = "src/CountZeroInit/model/menuicons/right_arrow.png";
        arrowImage = new ImageIcon(arrowImageAddress).getImage();

        myItemList = countZeroInit.getPlayer1().getMyItemList();
        itemList = new JList(myItemList.toArray());


        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        countZeroInit.getCurrentState().gameKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);


        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(arrowImage, 250, 8,265, 23, 0,0,120,120, null);
        this.add(itemList);

    }
}
