package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel
        implements KeyListener {
    CountZeroInit countZeroInit;
    String imageAddress;
    Image image;
    int x, y;

    public GamePanel(CountZeroInit countZeroInit) {
        // The following println() is just to see where GamePanel's constructor is called in the output.
        System.out.println("GamePanel.constructor...");

        this.countZeroInit = countZeroInit;

        setFocusable(true);
        // TODO: not sure if have to setRequestFocus (doesn't seem like it)
        //requestFocus();
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        // The following println() is just to see where GamePanel's paintComponent() is called in the output.
        System.out.println("GamePanel.paintComponent()...");

        // Drawing the Tiles (5 by 5 of tree pictures).
        drawBackground(g);

        // Drawing the LifeForm on board (one monster and one player1).
        drawLifeFormsOnBoard(g);

    }

    public void drawBackground(Graphics g) {
        // The following println() is just to see where GamePanel's drawBackground() is called in the output.
        System.out.println("GamePanel.drawBackground()...");

        x = 5;
        y = 5;

        for (int i = 0; i < countZeroInit.getTiles().size(); i++) {
            imageAddress = countZeroInit.getTiles().get(i).getImageAddress();
            image = new ImageIcon(imageAddress).getImage();

            g.drawImage(image, x, y, this);

            x = x + 138;
            if (i % 5 == 4) {
                y = y + 138;
                x = 5;
            }

        }
    }

    public void drawLifeFormsOnBoard(Graphics g) {
        // The following println() is just to see where GamePanel's drawLifeFormsOnBoard() is called in the output.
        System.out.println("GamePanel.drawLifeFormsOnBoard()...");

        // Get Monster from List<LifeForm> lifeFormsOnBoard (it is the first element in this List), store its String imageAddress.
        // Using the stored String imageAddress, create an Image (ImageIcon?) and store it in the instance variable image.
        imageAddress = countZeroInit.getLifeFormsOnBoard().get(0).getImageAddress();
        image = new ImageIcon(imageAddress).getImage();

        // Using the Monster's instance variable int col and row, draw the image of the Monster at that position on the
        // panel (doing calculation based on pixel size from the picture file that the String was directing us to;
        // start 5 pixel away from the top and left border of the panel).
        int monsterCol = countZeroInit.getLifeFormsOnBoard().get(0).getCol();
        int monsterRow = countZeroInit.getLifeFormsOnBoard().get(0).getRow();
        x = (monsterCol * 138) + 5;
        y = (monsterRow * 138) + 5;
        g.drawImage(image, x, y, this);

        // Get player1 from CountZeroInit, store its String imageAddress.
        // Using the stored String imageAddress, create an Image (ImageIcon?) and store it in the instance variable image.
        // Draw the image of the player1 at the position specified by player1's instance variable int col and row.
        imageAddress = countZeroInit.getPlayer1().getImageAddress();
        image = new ImageIcon(imageAddress).getImage();
        int playerCol = countZeroInit.getPlayer1().getCol();
        int playerRow = countZeroInit.getPlayer1().getRow();
        x = (playerCol * 138) + 5;
        y = (playerRow * 138) + 5;
        g.drawImage(image, x, y, this);
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
}
