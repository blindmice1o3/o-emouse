package tinker.animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpriteMoving extends JPanel
        implements ActionListener {

    String imageAddress = "src/count_zero_init/model/icons/player.gif";

    private final int DELAY = 300;
    Timer timer;


    ImageIcon ii;
    Image imageSpriteSouth;
    int dx1, dy1, dx2, dy2;

    int sx1, sy1, sx2, sy2;
    int oneTwo = 1;

    public SpriteMoving() {

        this.setSize(600, 400);

        ii = new ImageIcon(imageAddress);
        imageSpriteSouth = ii.getImage();

        dx1 = 0;
        dy1 = 0;
        dx2 = 48;
        dy2 = 48;

        sx1 = 0;
        sy1 = 0;
        sx2 = 16;
        sy2 = 16;

        timer = new Timer(DELAY, this);

    }

    @Override
    public void paintComponent(Graphics g) {

        //super.paintComponent(g);

        this.setDoubleBuffered(true);

        g.drawImage(imageSpriteSouth, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (oneTwo == 1) {
            sx1 = 0;
            sy1 = 0;
            sx2 = 16;
            sy2 = 16;

            oneTwo = 2;
        }
        else if (oneTwo == 2) {
            sx1 = 16;
            sy1 = 0;
            sx2 = 32;
            sy2 = 16;

            oneTwo = 1;
        }

        repaint();

    }

    public Timer getTimer() {
        return timer;
    }

}
