package tinker.animation;

import javax.swing.*;

public class SpriteMovingJFrame extends JFrame {
    JPanel panel;

    public static void main(String[] args) {

        SpriteMovingJFrame frame = new SpriteMovingJFrame();
        frame.start();

    }

    public SpriteMovingJFrame() {

        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new SpriteMoving();
        this.setContentPane( panel );

    }

    public void start() {

        this.setVisible(true);
        SpriteMoving spritePanel = (SpriteMoving)panel;
        spritePanel.getTimer().start();

    }

}
