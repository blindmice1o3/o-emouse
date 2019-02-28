package tinker.pocket_monsters_game;

import javax.swing.*;

public class GameFrame extends JFrame {

    public static final int GAME_FRAME_WIDTH = 480;
    public static final int GAME_FRAME_HEIGHT = 600;

    JPanel gameScreenPanel;

    public GameFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Off-brand Pocket Monsters");

        setSize(GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
        setLocationRelativeTo(null);

        gameScreenPanel = new GameScreenPanel(GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
        setContentPane( gameScreenPanel );

        setVisible(true);

    } // **** end GameFrame() constructor

    public static void main(String[] args) {

        new GameFrame();

    } // **** end main(String[]) ****

} // **** end GameFrame class ****
