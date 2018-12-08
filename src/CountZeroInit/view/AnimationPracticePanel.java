package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPracticePanel extends JPanel
        implements ActionListener {
    CountZeroInit countZeroInit;
    String imageAddress = "src/CountLegacyInit/icons/wolfman.png";
    ImageIcon ii;

    private final int DELAY = 25;

    Image image;
    Timer timer;
    int xImage, yImage;


    public AnimationPracticePanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;
        this.setSize(600, 400);


        ii = new ImageIcon(imageAddress);
        image = ii.getImage();

        xImage = 0;
        yImage = 0;


        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawImage(g);
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, xImage, yImage, 25, 25, 0, 0, 256, 256, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        xImage++;

        repaint();
    }
}
