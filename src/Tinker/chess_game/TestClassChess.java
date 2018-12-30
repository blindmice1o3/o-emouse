package Tinker.chess_game;

import Tinker.chess_game.view_controller.ChessGame;
import Tinker.chess_game.view_controller.ChessGameBorder;

import javax.swing.*;

public class TestClassChess {

    public static void main(String[] args) {

        JFrame displayer = new JFrame();
        displayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int gameWidth = 700;
        int gameHeight = 700;

        displayer.setSize(gameWidth, gameHeight);
        displayer.setLocationRelativeTo(null);          // Centers the frame onto the client's screen.
        displayer.setTitle("Chess");
        //displayer.setLayout( null );
        //displayer.add( new ChessGame() );
        displayer.setContentPane(new ChessGameBorder());
        displayer.setVisible(true);

    } // end main()

} // end TestClassChess class