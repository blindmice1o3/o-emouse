package tinker.MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import java.awt.*;

public class MoonRocksItsNotWhatYoureThinking extends JFrame {
    Toolkit awt;
    int frameWidth;
    int frameHeight;

    //public static int moveCounter = 0;
    private Player player1;

    JPanel framePanel;

    public MoonRocksItsNotWhatYoureThinking() {
        awt = Toolkit.getDefaultToolkit();
        frameWidth = awt.getScreenSize().width;
        frameHeight = awt.getScreenSize().height - 37;      // -40 pixels to try to account for start/Windows bar.

        framePanel = new IntroFramePanel(frameWidth, frameHeight);
        framePanel.setVisible(true);

        setSize(frameWidth, frameHeight);
        System.out.println(this.getWidth() + ", " +  this.getHeight());
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(framePanel);

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
