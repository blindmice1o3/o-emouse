package SetGameStateCannabis;

import javax.swing.*;

public class SetGameStateCannabis extends JFrame {
    public static int moveCounter = 0;
    private Player player1;

    JPanel gamePanel;
    State gameState;

    public SetGameStateCannabis() {

        gamePanel = new Act1SeedHunt();
        setContentPane(gamePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(75, 75);
        setSize(600, 480);


        player1 = new Player();

    }

    public void initGame() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SetGameStateCannabis setGameStateCannabis = new SetGameStateCannabis();
        setGameStateCannabis.initGame();
    }
}
