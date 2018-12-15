package Tinker.chess_game.view_controller;

import Tinker.chess_game.model.token.*;

import javax.swing.*;
import java.awt.*;

public class ChessGame extends JPanel {

    public enum Player {
        PLAYER1, PLAYER2;
    }

    String imageAddressWolfman = "src/CountZeroInit/model/icons/Wolfman.png";
    ImageIcon iiWolfman;
    Image imageWolfman;

    String imageAddressChessTokens = "src/CountZeroInit/model/icons/chess_tokens.png";
    ImageIcon iiChessTokens;
    Image imageChessTokens;

    ChessToken pawn1a, pawn2a, pawn3a, pawn4a, pawn5a, pawn6a, pawn7a, pawn8a,
            rook1a, rook2a, knight1a, knight2a, bishop1a, bishop2a, queen1a, king1a;
    ChessToken pawn1b, pawn2b, pawn3b, pawn4b, pawn5b, pawn6b, pawn7b, pawn8b,
            rook1b, rook2b, knight1b, knight2b, bishop1b, bishop2b, queen1b, king1b;

    public ChessGame() {
        iiWolfman = new ImageIcon(imageAddressWolfman);
        imageWolfman = iiWolfman.getImage();

        initImageChessTokens();

        initChessTokenPlayer1();
        initChessTokenPlayer2();
    }

    public void initChessTokenPlayer1() {
        pawn1a = new Pawn(Player.PLAYER1, 70, 490);
        pawn2a = new Pawn(Player.PLAYER1, 140, 490);
        pawn3a = new Pawn(Player.PLAYER1, 210, 490);
        pawn4a = new Pawn(Player.PLAYER1, 280, 490);
        pawn5a = new Pawn(Player.PLAYER1, 350, 490);
        pawn6a = new Pawn(Player.PLAYER1, 420, 490);
        pawn7a = new Pawn(Player.PLAYER1, 490, 490);
        pawn8a = new Pawn(Player.PLAYER1, 560, 490);

        rook1a = new Rook(Player.PLAYER1, 70, 560);
        rook2a = new Rook(Player.PLAYER1, 560, 560);

        knight1a = new Knight(Player.PLAYER1, 140, 560);
        knight2a = new Knight(Player.PLAYER1, 490, 560);

        bishop1a = new Bishop(Player.PLAYER1, 210, 560);
        bishop2a = new Bishop(Player.PLAYER1, 420, 560);

        queen1a = new Queen(Player.PLAYER1, 280, 560);
        king1a = new King(Player.PLAYER1, 350, 560);

    }

    public void initChessTokenPlayer2() {
        pawn1b = new Pawn(Player.PLAYER2, 70, 140);
        pawn2b = new Pawn(Player.PLAYER2, 140, 140);
        pawn3b = new Pawn(Player.PLAYER2, 210, 140);
        pawn4b = new Pawn(Player.PLAYER2, 280, 140);
        pawn5b = new Pawn(Player.PLAYER2, 350, 140);
        pawn6b = new Pawn(Player.PLAYER2, 420, 140);
        pawn7b = new Pawn(Player.PLAYER2, 490, 140);
        pawn8b = new Pawn(Player.PLAYER2, 560, 140);

        rook1b = new Rook(Player.PLAYER2, 70, 70);
        rook2b = new Rook(Player.PLAYER2, 560, 70);

        knight1b = new Knight(Player.PLAYER2, 140, 70);
        knight2b = new Knight(Player.PLAYER2, 490, 70);

        bishop1b = new Bishop(Player.PLAYER2, 210, 70);
        bishop2b = new Bishop(Player.PLAYER2, 420, 70);

        queen1b = new Queen(Player.PLAYER2, 280, 70);
        king1b = new King(Player.PLAYER2, 350, 70);

    }

    @Override
    public void paintComponent(Graphics g) {

        // Paints the background grey, which is used as a grey margin/border (can use later for icons of captured tokens).
        super.paintComponent(g);

        // Draws chessboard with light (yellow) and dark (blue) squares.
        drawChessBoard(g);

        drawChessTokenPlayer1(g);



    }

    public void drawChessTokenPlayer1(Graphics g) {
        // Draws PLAYER1's Pawn tokens.
        g.drawImage(imageChessTokens, pawn1a.getX(), pawn1a.getY(), pawn1a.getX()+70, pawn1a.getY()+70,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn2a.getX(), pawn2a.getY(), pawn2a.getX()+70, pawn2a.getY()+70,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn3a.getX(), pawn3a.getY(), pawn3a.getX()+70, pawn3a.getY()+70,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn4a.getX(), pawn4a.getY(), pawn4a.getX()+70, pawn4a.getY()+70,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn5a.getX(), pawn5a.getY(), pawn5a.getX()+70, pawn5a.getY()+70,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn6a.getX(), pawn6a.getY(), pawn6a.getX()+70, pawn6a.getY()+70,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn7a.getX(), pawn7a.getY(), pawn7a.getX()+70, pawn7a.getY()+70,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn8a.getX(), pawn8a.getY(), pawn8a.getX()+70, pawn8a.getY()+70,
                60, 60, 120, 140, null);

        // Draws PLAYER1's Rook tokens.
        g.drawImage(imageChessTokens, rook1a.getX(), rook1a.getY(), rook1a.getX()+70, rook1a.getY()+70,
                270, 60, 330, 140, null);

        g.drawImage(imageChessTokens, rook2a.getX(), rook2a.getY(), rook2a.getX()+70, rook2a.getY()+70,
                270, 60, 330, 140, null);

        // Draws PLAYER1's Knight tokens.
        g.drawImage(imageChessTokens, knight1a.getX(), knight1a.getY(), knight1a.getX()+70, knight1a.getY()+70,
                465, 65, 525, 135, null);

        g.drawImage(imageChessTokens, knight2a.getX(), knight2a.getY(), knight2a.getX()+70, knight2a.getY()+70,
                465, 65, 525, 135, null);

        // Draws PLAYER1's Bishop tokens.
        g.drawImage(imageChessTokens, bishop1a.getX(), bishop1a.getY(), bishop1a.getX()+70, bishop1a.getY()+70,
                675, 65, 735, 135, null);

        g.drawImage(imageChessTokens, bishop2a.getX(), bishop2a.getY(), bishop2a.getX()+70, bishop2a.getY()+70,
                675, 65, 735, 135, null);

        // Draws PLAYER1's Queen token.
        g.drawImage(imageChessTokens, queen1a.getX(), queen1a.getY(), queen1a.getX()+70, queen1a.getY()+70,
                860, 65, 930, 145, null);

        // Draws PLAYER1's King token.
        g.drawImage(imageChessTokens, king1a.getX(), king1a.getY(), king1a.getX()+70, king1a.getY()+70,
                1080, 65, 1135, 135, null);

        // Draws wolfman.png image at 8/e (rank/file).
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

    public void initImageChessTokens() {
        iiChessTokens = new ImageIcon(imageAddressChessTokens);
        imageChessTokens = iiChessTokens.getImage();
    } // end initImageChessTokens()

} // end ChessGame class
