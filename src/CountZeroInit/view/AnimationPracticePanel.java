package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPracticePanel extends JPanel
        implements ActionListener {
    CountZeroInit countZeroInit;

    String imageAddress = "src/CountZeroInit/model/icons/wolfman.png";
    ImageIcon ii;

    private final int DELAY = 50;

    Image image;
    Timer timer;
    int xImage, yImage;

    int dx2 = 100;
    int dy2 = 100;


    public AnimationPracticePanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;
        this.setSize(600, 400);


        ii = new ImageIcon(imageAddress);
        image = ii.getImage();

        xImage = 0;
        yImage = 0;


        timer = new Timer(DELAY, this);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawImage(g);
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, xImage, yImage, dx2, dy2, 0, 0, 256, 256, null);
        Toolkit.getDefaultToolkit().sync();
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if ( xImage < (this.getWidth() / 2) ) {
            xImage = xImage + 1;
            dx2 = dx2 + 1;
        } else {
            yImage = yImage +1;
            dy2 = dy2 +1;
        }

        repaint();
    }

    public Timer getTimer() {
        return timer;
    }
}
