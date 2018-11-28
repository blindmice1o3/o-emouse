package MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import java.awt.*;

public class MoonRocksItsNotWhatYoureThinking extends JFrame {
    Toolkit awt;
    Dimension screenDimension;
    int frameWidth;
    int frameHeight;

    //public static int moveCounter = 0;
    private Player player1;

    JPanel framePanel;

    public MoonRocksItsNotWhatYoureThinking() {
        awt = Toolkit.getDefaultToolkit();
        screenDimension = awt.getScreenSize();
        frameWidth = (int)screenDimension.getWidth();
        frameHeight = (int)screenDimension.getHeight()-40;      // -40 pixels to try to account for start/Windows bar.
            System.out.println(frameWidth + ", " +  frameHeight);
        framePanel = new IntroFramePanel(frameWidth, frameHeight);
        framePanel.setVisible(true);
        framePanel.repaint();

        this.setContentPane(framePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(0, 0);

        this.setSize(frameWidth, frameHeight);

        player1 = new Player();
    }

    public void setPlayer1Name() {
        player1.setName(JOptionPane.showInputDialog(this, "player1, please input your handle..."));
    }

    public void initGame() {
        this.setVisible(true);
        this.setPlayer1Name();
        System.out.println(player1.getName());
    }

    public static void main(String[] args) {
        MoonRocksItsNotWhatYoureThinking moonRocksItsNotWhatYoureThinking = new MoonRocksItsNotWhatYoureThinking();
        moonRocksItsNotWhatYoureThinking.initGame();
    }
}
