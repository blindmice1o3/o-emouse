package CountZeroInit.view;

import CountZeroInit.controller.GameboyColor;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    GameboyColor gb;
    String imageAddress;
    Image image;
    int x, y;

    public MyDrawPanel(GameboyColor gb) {
        // The following println() is just to see where MyDrawPanel's constructor is called in the output.
        System.out.println("MyDrawPanel.constructor...");

        this.gb = gb;

    }

    @Override
    public void paintComponent(Graphics g) {
        // The following println() is just to see where MyDrawPanel's paintComponent() is called in the output.
        System.out.println("MyDrawPanel.paintComponent()...");

        // Drawing the Tiles (5 by 5 of tree pictures).
        drawBackground(g);

        // Drawing the LifeForm on board (one monster and one player1).
        drawLifeFormsOnBoard(g);
    }

    public void drawBackground(Graphics g) {
        // The following println() is just to see where MyDrawPanel's drawBackground() is called in the output.
        System.out.println("MyDrawPanel.drawBackground()...");

        x = 5;
        y = 5;

        for (int i = 0; i < gb.getTiles().size(); i++) {
            imageAddress = gb.getTiles().get(i).getImageAddress();
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
        // The following println() is just to see where MyDrawPanel's drawLifeFormsOnBoard() is called in the output.
        System.out.println("MyDrawPanel.drawLifeFormsOnBoard()...");

        // Get Monster from List<LifeForm> lifeFormsOnBoard (it is the first element in this List), store its String imageAddress.
        // Using the stored String imageAddress, create an Image (ImageIcon?) and store it in the instance variable image.
        imageAddress = gb.getLifeFormsOnBoard().get(0).getImageAddress();
        image = new ImageIcon(imageAddress).getImage();

        // Using the Monster's instance variable int col and row, draw the image of the Monster at that position on the
        // panel (doing calculation based on pixel size from the picture file that the String was directing us to;
        // start 5 pixel away from the top and left border of the panel).
        int monsterCol = gb.getLifeFormsOnBoard().get(0).getCol();
        int monsterRow = gb.getLifeFormsOnBoard().get(0).getRow();
        x = (monsterCol * 138) + 5;
        y = (monsterRow * 138) + 5;
        g.drawImage(image, x, y, this);

        // Get player1 from GameboyColor, store its String imageAddress.
        // Using the stored String imageAddress, create an Image (ImageIcon?) and store it in the instance variable image.
        // Draw the image of the player1 at the position specified by player1's instance variable int col and row.
        imageAddress = gb.getPlayer1().getImageAddress();
        image = new ImageIcon(imageAddress).getImage();
        int playerCol = gb.getPlayer1().getCol();
        int playerRow = gb.getPlayer1().getRow();
        x = (playerCol * 138) + 5;
        y = (playerRow * 138) + 5;
        g.drawImage(image, x, y, this);
    }
}
