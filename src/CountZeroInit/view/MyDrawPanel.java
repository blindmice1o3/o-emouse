package CountZeroInit.view;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.surroundings.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyDrawPanel extends JPanel {
    GameboyColor gb;
    //List<Tile> tiles;
    //List<LifeForm> lifeFormsOnBoard;
    String imageAddress;
    Image image;

    public MyDrawPanel(GameboyColor gb) {
        // The following println() is just to see where MyDrawPanel's constructor is called in the output.
        System.out.println("MyDrawPanel.constructor...");

        this.gb = gb;
        //tiles = gb.getTiles();
        //lifeFormsOnBoard = gb.getLifeFormsOnBoard();
    }

    @Override
    public void paintComponent(Graphics g) {
        // The following println() is just to see where MyDrawPanel's paintComponent() is called in the output.
        System.out.println("MyDrawPanel.paintComponent()...");

        /*
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
        */

        int x = 5;
        int y = 5;
        int tileCounter = 0;

        // Drawing the Tiles (5 by 5 of tree pictures).
        for (int i = 0; i < gb.getTiles().size(); i++) {
            imageAddress = gb.getTiles().get(i).getImageAddress();
            image = new ImageIcon(imageAddress).getImage();
            g.drawImage(image, x, y, this);

            x = x + 138;
            if (tileCounter % 5 == 4) {
                y = y + 138;
                x = 5;
            }

            tileCounter++;
        }

        // Drawing the LifeForm on board.
        imageAddress = gb.getLifeFormsOnBoard().get(0).getImageAddress();
        image = new ImageIcon(imageAddress).getImage();

        int monsterCol = gb.getLifeFormsOnBoard().get(0).getCol();
        int monsterRow = gb.getLifeFormsOnBoard().get(0).getRow();
        x = (monsterCol * 138) + 5;
        y = (monsterRow * 138) + 5;
        g.drawImage(image, x, y, this);

        imageAddress = gb.getPlayer1().getImageAddress();
        image = new ImageIcon(imageAddress).getImage();
        int playerCol = gb.getPlayer1().getCol();
        int playerRow = gb.getPlayer1().getRow();
        x = (playerCol * 138) + 5;
        y = (playerRow * 138) + 5;
        g.drawImage(image, x, y, this);

    }
}
