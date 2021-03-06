package tinker.animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundMoving extends JPanel
        implements ActionListener {

    String imageAddress = "src/count_zero_init/model/icons/initBackground.png";
    private final int IMAGEPIXELLENGTH = 2400;
    private final int DELAY = 30;
    Timer timer;

    ImageIcon ii;
    Image image;
    int dx1, dy1, dx2, dy2;
    int sx1, sy1, sx2, sy2;

    public BackgroundMoving() {

        this.setSize(600, 400);

        ii = new ImageIcon(imageAddress);
        image = ii.getImage();

        dx1 = 0;
        dy1 = 0;
        dx2 = 600;
        dy2 = 400;

        sx1 = 0;
        sy1 = 0;
        sx2 = 600;
        sy2 = 400;

        timer = new Timer(DELAY, this);

    }

    @Override
    public void paintComponent(Graphics g) {

        //super.paintComponent(g);

        this.setDoubleBuffered(true);

        drawImage(g);

    }

    public void drawImage(Graphics g) {

        g.drawImage(image, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
        //Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (sx2 < IMAGEPIXELLENGTH) {
            sx1++;
            sx2++;
        }
        else {
            sx1 = (IMAGEPIXELLENGTH/2)-600;
            sx2 = (IMAGEPIXELLENGTH/2);
        }

        repaint();

    }

    public Timer getTimer() {
        return timer;
    }

}
