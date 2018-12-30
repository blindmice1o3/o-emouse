package Tinker.chess_game.view_controller;

import Tinker.chess_game.TestClassChess;
import javax.swing.*;
import java.awt.*;

public class ChessGameBorder extends JPanel {

    ChessGame chessGame;

    public ChessGameBorder() {

        this.setSize( new Dimension(TestClassChess.FRAME_WIDTH, TestClassChess.FRAME_HEIGHT) );

        chessGame = new ChessGame();

        this.setLayout(null);

        this.add(chessGame);

    } // **** end ChessGameBorder() constructor ****

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, TestClassChess.FRAME_WIDTH, TestClassChess.FRAME_HEIGHT);

    } // **** end paintComponent(Graphics) ****

} // **** end ChessGameBorder class ****