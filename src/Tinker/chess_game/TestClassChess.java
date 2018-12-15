package Tinker.chess_game;


import Tinker.chess_game.model.Chessboard;
import Tinker.chess_game.view_controller.ChessGame;

import javax.swing.*;

public class TestClassChess {

    public static void main(String[] args) {

        JFrame displayer = new JFrame();
        displayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int gameWidth = 725;
        int gameHeight = 725;

        displayer.setSize(gameWidth, gameHeight);
        displayer.setLocationRelativeTo(null);
        displayer.setTitle("Chess");

        displayer.setContentPane(new ChessGame());
        displayer.setVisible(true);



        Chessboard board = new Chessboard();

    } // end main()

} // end TestClassChess class