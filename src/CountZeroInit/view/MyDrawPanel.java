package CountZeroInit.view;

import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.creatures.ThunderMouse;
import CountZeroInit.model.map.Map;
import CountZeroInit.model.map.MapSpec;
import CountZeroInit.model.surroundings.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyDrawPanel extends JPanel {
    //Monster thunderMouse = new ThunderMouse("Winnie", "pooh");
    //Image thunderMouseImage = new ImageIcon(thunderMouse.getImageAddress()).getImage();
    Map map;
    Monster monster;
    Image monsterImage;
    Humanoid humanoid;
    Image humanoidImage;

    public MyDrawPanel(Map map) {
        this.map = map;
    }

    @Override
    public void paintComponent(Graphics g) {
        /*
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
        */
        MapSpec mapSpec = map.getMapSpec();
        List<LifeForm> lifeFormsOnBoard = mapSpec.getLifeFormsOnBoard();

        if (lifeFormsOnBoard.get(0) instanceof Monster) {
            monster = (Monster)lifeFormsOnBoard.get(0);
            monsterImage = new ImageIcon(monster.getImageAddress()).getImage();
        }
        if (lifeFormsOnBoard.get(1) instanceof Humanoid) {
            humanoid = (Humanoid)lifeFormsOnBoard.get(1);
            humanoidImage = new ImageIcon(humanoid.getImageAddress()).getImage();
        }


        List<Tile> tiles = mapSpec.getTiles();

        String imageAddress1 = tiles.get(0).getImageAddress();
        String imageAddress2 = tiles.get(1).getImageAddress();
        String imageAddress3 = tiles.get(2).getImageAddress();

        String imageAddress4 = tiles.get(3).getImageAddress();
        //String imageAddress5 = tiles.get(4).getImageAddress();
        String imageAddress6 = tiles.get(5).getImageAddress();

        String imageAddress7 = tiles.get(6).getImageAddress();
        String imageAddress8 = tiles.get(7).getImageAddress();
        //String imageAddress9 = tiles.get(8).getImageAddress();

        Image image = new ImageIcon(imageAddress1).getImage();

        g.drawImage(image,10, 10, this);
        image = new ImageIcon(imageAddress2).getImage();
        g.drawImage(image, 148, 10, this);
        image = new ImageIcon(imageAddress3).getImage();
        g.drawImage(image, 286, 10, this);

        image = new ImageIcon(imageAddress4).getImage();
        g.drawImage(image, 10, 148,this);
        //image = new ImageIcon(imageAddress5).getImage();
        g.drawImage(monsterImage, 148, 148, this);
        image = new ImageIcon(imageAddress6).getImage();
        g.drawImage(image, 286, 148, this);

        image = new ImageIcon(imageAddress7).getImage();
        g.drawImage(image, 10, 286, this);
        image = new ImageIcon(imageAddress8).getImage();
        g.drawImage(image, 148, 286, this);
        //image = new ImageIcon(imageAddress9).getImage();
        g.drawImage(humanoidImage, 286, 286, this);
    }
}
