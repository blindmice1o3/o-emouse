package CountZeroInit.view;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        /*
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
        */

        Image image = new ImageIcon("src/CountZeroInit/view/tree.png").getImage();
        g.drawImage(image,10, 10, this);
        g.drawImage(image, 148, 10, this);
        g.drawImage(image, 286, 10, this);

        g.drawImage(image, 10, 148,this);
        g.drawImage(image, 148, 148, this);
        g.drawImage(image, 286, 148, this);

        g.drawImage(image, 10, 286, this);
        g.drawImage(image, 148, 286, this);
        g.drawImage(image, 286, 286, this);
    }
}
