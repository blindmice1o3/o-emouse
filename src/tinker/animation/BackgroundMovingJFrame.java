package tinker.animation;

import javax.swing.*;

public class BackgroundMovingJFrame extends JFrame {
    JPanel panel;

    public static void main(String[] args) {

        BackgroundMovingJFrame frame = new BackgroundMovingJFrame();
        frame.start();

    }

    public BackgroundMovingJFrame() {

        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new BackgroundMoving();
        this.setContentPane( panel );

    }

    public void start() {

        this.setVisible(true);
        BackgroundMoving backgroundPanel = (BackgroundMoving)panel;
        backgroundPanel.getTimer().start();

    }

}