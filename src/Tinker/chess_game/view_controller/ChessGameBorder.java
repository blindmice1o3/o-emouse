package Tinker.chess_game.view_controller;

import javax.swing.*;
import java.awt.*;

public class ChessGameBorder extends JPanel {
    ChessGame chessGame;

    public ChessGameBorder() {

        this.setSize( new Dimension(700, 700) );

        chessGame = new ChessGame();

        this.setLayout(null);
        this.add(chessGame);

    } // **** end ChessGameBorder() constructor ****

} // **** end ChessGameBorder class ****
