package CountZeroInit.view;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.surroundings.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyDrawPanel extends JPanel {
    GameboyColor gb;

    public MyDrawPanel(GameboyColor gb) {
        // The following println() is just to see where MyDrawPanel's constructor is called in the output.
        System.out.println("MyDrawPanel.constructor...");

        this.gb = gb;

    }

    @Override
    public void paintComponent(Graphics g) {
        // The following println() is just to see where MyDrawPanel's paintComponent() is called in the output.
        System.out.println("MyDrawPanel.paintComponent()...");

        /*
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
        */

        List<Tile> tiles = gb.getCurrentMap().getTiles();
        List<LifeForm> lifeFormsOnBoard = gb.getCurrentMap().getLifeFormsOnBoard();
        String imageAddress;
        Image image;
        int x = 10;
        int y = 10;
        int tileCounter = 0;

        // Drawing the Tiles (5 by 5 of tree pictures).
        for (int i = 0; i < tiles.size(); i++) {
            imageAddress = tiles.get(i).getImageAddress();
            image = new ImageIcon(imageAddress).getImage();
            g.drawImage(image, x, y, this);

            x = x + 138;
            if (tileCounter % 5 == 4) {
                y = y + 138;
                x = 10;
            }

            tileCounter++;
        }

        // Drawing the LifeForm on board.
        imageAddress = lifeFormsOnBoard.get(0).getImageAddress();
        image = new ImageIcon(imageAddress).getImage();

        int monsterCol = lifeFormsOnBoard.get(0).getCol();
        int monsterRow = lifeFormsOnBoard.get(0).getRow();
        x = (monsterCol * 138) + 10;
        y = (monsterRow * 138) + 10;
        g.drawImage(image, x, y, this);

        imageAddress = lifeFormsOnBoard.get(1).getImageAddress();
        image = new ImageIcon(imageAddress).getImage();
        int playerCol = lifeFormsOnBoard.get(1).getCol();
        int playerRow = lifeFormsOnBoard.get(1).getRow();
        x = (playerCol * 138) + 10;
        y = (playerRow * 138) + 10;
        g.drawImage(image, x, y, this);

    }
}
