package CountZeroInit.view;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.surroundings.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyDrawPanel extends JPanel {
    GameboyColor gb;

    String monsterImageAddress;
    String humanoidImageAddress;

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

        List<Tile> tiles = gb.getCurrentMap().getMapSpec().getTiles();
        List<LifeForm> lifeFormsOnBoard = gb.getCurrentMap().getMapSpec().getLifeFormsOnBoard();
        String imageAddress;
        Image image;
        int x = 10;
        int y = 10;
        int tileCounter = 0;

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

        int col = 0;
        int row = 0;
        int iterationCounter = 0;
        x=10;
        y=10;
        for (int i = 0; i < tiles.size(); i++) {
            if (lifeFormsOnBoard.get(0).getCol() == col && lifeFormsOnBoard.get(0).getRow() == row) {
                imageAddress = lifeFormsOnBoard.get(0).getImageAddress();
                image = new ImageIcon(imageAddress).getImage();
                g.drawImage(image, x, y, this);
            }
            if (lifeFormsOnBoard.get(1).getCol() == col && lifeFormsOnBoard.get(1).getRow() == row) {
                imageAddress = lifeFormsOnBoard.get(1).getImageAddress();
                System.out.println("Player1 image: " + imageAddress);
                image = new ImageIcon(imageAddress).getImage();
                g.drawImage(image, x, y, this);
            }


            x = x + 138;
            row++;
            if (iterationCounter % 5 == 4) {
                y = y + 138;
                col++;
                x = 10;
            }
        }

        /*
        String imageAddress1 = tiles.get(0).getImageAddress();
        String imageAddress2 = tiles.get(1).getImageAddress();
        String imageAddress3 = tiles.get(2).getImageAddress();

        String imageAddress4 = tiles.get(3).getImageAddress();
        //String imageAddress5 = tiles.get(4).getImageAddress();
        monsterImageAddress = lifeFormsOnBoard.get(0).getImageAddress();
        String imageAddress6 = tiles.get(5).getImageAddress();

        String imageAddress7 = tiles.get(6).getImageAddress();
        String imageAddress8 = tiles.get(7).getImageAddress();
        //String imageAddress9 = tiles.get(8).getImageAddress();
        humanoidImageAddress = lifeFormsOnBoard.get(1).getImageAddress();


        Image image = new ImageIcon(imageAddress1).getImage();
        g.drawImage(image,10, 10, this);
        image = new ImageIcon(imageAddress2).getImage();
        g.drawImage(image, 148, 10, this);
        image = new ImageIcon(imageAddress3).getImage();
        g.drawImage(image, 286, 10, this);

        image = new ImageIcon(imageAddress4).getImage();
        g.drawImage(image, 10, 148,this);
        //image = new ImageIcon(imageAddress5).getImage();
        image = new ImageIcon(monsterImageAddress).getImage();
        g.drawImage(image, 148, 148, this);
        image = new ImageIcon(imageAddress6).getImage();
        g.drawImage(image, 286, 148, this);

        image = new ImageIcon(imageAddress7).getImage();
        g.drawImage(image, 10, 286, this);
        image = new ImageIcon(imageAddress8).getImage();
        g.drawImage(image, 148, 286, this);
        //image = new ImageIcon(imageAddress9).getImage();
        image = new ImageIcon(humanoidImageAddress).getImage();
        g.drawImage(image, 286, 286, this);
        */
    }
}
