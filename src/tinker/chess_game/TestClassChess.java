package tinker.chess_game;

import tinker.chess_game.view_controller.ChessGameBorder;

import javax.swing.*;

public class TestClassChess {

    public static final int FRAME_WIDTH = 700;
    public static final int FRAME_HEIGHT = 700;

    public static void main(String[] args) {

        JFrame displayer = new JFrame();
        displayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayer.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        displayer.setLocationRelativeTo(null);          // Centers the frame onto the client's screen.
        displayer.setTitle("Chess");
        //displayer.setLayout( null );
        //displayer.add( new ChessGame() );
        displayer.setContentPane(new ChessGameBorder());
        displayer.setVisible(true);

    } // end main()

} // end TestClassChess class