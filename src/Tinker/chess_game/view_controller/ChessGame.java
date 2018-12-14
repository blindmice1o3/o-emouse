package Tinker.chess_game.view_controller;

import Tinker.chess_game.model.token.ChessToken;
import Tinker.chess_game.model.token.Pawn;
import Tinker.chess_game.model.token.Rook;

import javax.swing.*;
import java.awt.*;

public class ChessGame extends JPanel {

    public enum Player {
        PLAYER1, PLAYER2;
    }

    String imageAddressWolfman = "src/CountZeroInit/model/icons/Wolfman.png";
    ImageIcon iiWolfman;
    Image imageWolfman;

    Image imageChessTokens;
    ChessToken pawn1;
    ChessToken rook1;

    public ChessGame() {
        iiWolfman = new ImageIcon(imageAddressWolfman);
        imageWolfman = iiWolfman.getImage();

        pawn1 = new Pawn(Player.PLAYER1, 70, 490);
        rook1 = new Rook(Player.PLAYER1, 70, 560);
        imageChessTokens = pawn1.getImageChessTokens();

    }

    @Override
    public void paintComponent(Graphics g) {

        // Paints the background grey, which is used as a grey margin/border (can use later for icons of captured tokens).
        super.paintComponent(g);

        // Draws chessboard with light (yellow) and dark (blue) squares.
        drawChessBoard(g);

        g.drawImage(imageChessTokens, pawn1.getX(), pawn1.getY(), pawn1.getX()+70, pawn1.getY()+70,
                60, 60, 120, 140, null);
        g.drawImage(imageChessTokens, rook1.getX(), rook1.getY(), rook1.getX()+70, rook1.getY()+70,
                270, 60, 330, 140, null);

        g.drawImage(imageWolfman, 350, 70, 420, 140, 0, 0, 256, 256, null);

    }

    public void drawChessBoard(Graphics g) {

        // Create a border around the board.
        g.setColor(Color.BLACK);
        g.fillRect(68, 68, 564, 564);

        // Create a blue large-square background, this acts as the board's dark-color squares.
        g.setColor(Color.BLUE);
        g.fillRect(70, 70, 560, 560);

        // Create and position the board's light-color squares.
        g.setColor(Color.YELLOW);
        int xLightSquare = 0;
        int yLightSquare = 0;
        for (int i = 0; i < 32; i++) {
            if (i == 0) { xLightSquare = 70; yLightSquare = 70; }
            if (i == 4) { xLightSquare = 140; yLightSquare = 140; }
            if (i == 8) { xLightSquare = 70; yLightSquare = 210; }
            if (i == 12) { xLightSquare = 140; yLightSquare = 280; }
            if (i == 16) { xLightSquare = 70; yLightSquare = 350; }
            if (i == 20) { xLightSquare = 140; yLightSquare = 420; }
            if (i == 24) { xLightSquare = 70; yLightSquare = 490; }
            if (i == 28) { xLightSquare = 140; yLightSquare = 560; }

            g.fillRect(xLightSquare, yLightSquare, 70, 70);
            xLightSquare = xLightSquare + 140;
        }

    } // end drawChessBoard(Graphics)

} // end ChessGame class
