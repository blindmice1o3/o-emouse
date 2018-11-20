package MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;

public class MoonRocksItsNotWhatYoureThinking extends JFrame {
    public static int moveCounter = 0;
    private Player player1;

    JPanel gamePanel;
    State gameState;

    public MoonRocksItsNotWhatYoureThinking() {

        gamePanel = new Act1Panel();
        setContentPane(gamePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(75, 75);
        setSize(600, 480);

        player1 = new Player();

    }

    public void setPlayer1Name() {
        player1.setName(JOptionPane.showInputDialog(this, "player1, please input your handle..."));
    }

    public void initGame() {
        this.setVisible(true);
        setPlayer1Name();
        System.out.println(player1.getName());
    }

    public static void main(String[] args) {
        MoonRocksItsNotWhatYoureThinking moonRocksItsNotWhatYoureThinking = new MoonRocksItsNotWhatYoureThinking();
        moonRocksItsNotWhatYoureThinking.initGame();
    }
}
