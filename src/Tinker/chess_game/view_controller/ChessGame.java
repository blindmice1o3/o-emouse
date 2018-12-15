package Tinker.chess_game.view_controller;

import Tinker.chess_game.model.ChessBoard;
import Tinker.chess_game.model.token.*;

import javax.swing.*;
import java.awt.*;

public class ChessGame extends JPanel {

    public enum Player {
        PLAYER1, PLAYER2;
    }
    ChessBoard board;

    Player whoseTurn = Player.PLAYER1;
    boolean gameOver = false;

    String imageAddressChessTokens = "src/CountZeroInit/model/icons/chess_tokens.png";
    ImageIcon iiChessTokens;
    Image imageChessTokens;

    ChessToken pawn1a, pawn2a, pawn3a, pawn4a, pawn5a, pawn6a, pawn7a, pawn8a,
            rook1a, rook2a, knight1a, knight2a, bishop1a, bishop2a, queen1a, king1a;
    ChessToken pawn1b, pawn2b, pawn3b, pawn4b, pawn5b, pawn6b, pawn7b, pawn8b,
            rook1b, rook2b, knight1b, knight2b, bishop1b, bishop2b, queen1b, king1b;

    public ChessGame() {
        this.setFocusable(true);
        this.requestFocus();

        board = new ChessBoard();

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

        drawChessTokenPlayer2(g);

        ImageIcon imageIconWolfman = new ImageIcon("src/CountZeroInit/model/icons/wolfman.png");
        Image imageWolfman = imageIconWolfman.getImage();
        g.drawImage(imageWolfman, 280, 350, 350, 420, 0, 0, 256, 256, null);

        ImageIcon imageIconFishmonk = new ImageIcon("src/CountZeroInit/model/icons/3fish_blue_spirit.png");
        Image imageFishmonk = imageIconFishmonk.getImage();
        g.drawImage(imageFishmonk, 350, 350, 420, 420, 0, 0, 256, 256, null);

        ImageIcon imageIconRobot = new ImageIcon("src/CountZeroInit/model/icons/robot_flat_head.png");
        Image imageRobot = imageIconRobot.getImage();
        g.drawImage(imageRobot, 280, 280, 350, 350, 0, 0, 256, 256, null);

        ImageIcon imageIconMonkey = new ImageIcon("src/CountZeroInit/model/icons/5monkey.jpg");
        Image imageMonkey = imageIconMonkey.getImage();
        g.drawImage(imageMonkey, 350, 280, 420, 350, 0, 0, 256, 256, null);

    }

    public void drawChessTokenPlayer1(Graphics g) {
        // Draws PLAYER1's Pawn tokens.
        g.drawImage(imageChessTokens, pawn1a.getX()+6, pawn1a.getY()+6, pawn1a.getX()+62, pawn1a.getY()+62,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn2a.getX()+6, pawn2a.getY()+6, pawn2a.getX()+62, pawn2a.getY()+62,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn3a.getX()+6, pawn3a.getY()+6, pawn3a.getX()+62, pawn3a.getY()+62,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn4a.getX()+6, pawn4a.getY()+6, pawn4a.getX()+62, pawn4a.getY()+62,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn5a.getX()+6, pawn5a.getY()+6, pawn5a.getX()+62, pawn5a.getY()+62,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn6a.getX()+6, pawn6a.getY()+6, pawn6a.getX()+62, pawn6a.getY()+62,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn7a.getX()+6, pawn7a.getY()+6, pawn7a.getX()+62, pawn7a.getY()+62,
                60, 60, 120, 140, null);

        g.drawImage(imageChessTokens, pawn8a.getX()+6, pawn8a.getY()+6, pawn8a.getX()+62, pawn8a.getY()+62,
                60, 60, 120, 140, null);


        // Draws PLAYER1's Rook tokens.
        g.drawImage(imageChessTokens, rook1a.getX()+6, rook1a.getY()+6, rook1a.getX()+62, rook1a.getY()+62,
                270, 60, 330, 140, null);

        g.drawImage(imageChessTokens, rook2a.getX()+6, rook2a.getY()+6, rook2a.getX()+62, rook2a.getY()+62,
                270, 60, 330, 140, null);


        // Draws PLAYER1's Knight tokens.
        g.drawImage(imageChessTokens, knight1a.getX()+6, knight1a.getY()+6, knight1a.getX()+62, knight1a.getY()+62,
                465, 65, 525, 135, null);

        g.drawImage(imageChessTokens, knight2a.getX()+6, knight2a.getY()+6, knight2a.getX()+62, knight2a.getY()+62,
                465, 65, 525, 135, null);


        // Draws PLAYER1's Bishop tokens.
        g.drawImage(imageChessTokens, bishop1a.getX()+6, bishop1a.getY()+6, bishop1a.getX()+62, bishop1a.getY()+62,
                675, 65, 735, 135, null);

        g.drawImage(imageChessTokens, bishop2a.getX()+6, bishop2a.getY()+6, bishop2a.getX()+62, bishop2a.getY()+62,
                675, 65, 735, 135, null);


        // Draws PLAYER1's Queen token.
        g.drawImage(imageChessTokens, queen1a.getX()+6, queen1a.getY()+6, queen1a.getX()+62, queen1a.getY()+62,
                860, 65, 930, 145, null);


        // Draws PLAYER1's King token.
        g.drawImage(imageChessTokens, king1a.getX()+6, king1a.getY()+6, king1a.getX()+62, king1a.getY()+62,
                1080, 65, 1135, 135, null);

    }

    public void drawChessTokenPlayer2(Graphics g) {
        // Draws PLAYER2's Pawn tokens.
        g.drawImage(imageChessTokens, pawn1b.getX()+6, pawn1b.getY()+6, pawn1b.getX()+62, pawn1b.getY()+62,
                60, 265, 120, 340, null);

        g.drawImage(imageChessTokens, pawn2b.getX()+6, pawn2b.getY()+6, pawn2b.getX()+62, pawn2b.getY()+62,
                60, 265, 120, 340, null);

        g.drawImage(imageChessTokens, pawn3b.getX()+6, pawn3b.getY()+6, pawn3b.getX()+62, pawn3b.getY()+62,
                60, 265, 120, 340, null);

        g.drawImage(imageChessTokens, pawn4b.getX()+6, pawn4b.getY()+6, pawn4b.getX()+62, pawn4b.getY()+62,
                60, 265, 120, 340, null);

        g.drawImage(imageChessTokens, pawn5b.getX()+6, pawn5b.getY()+6, pawn5b.getX()+62, pawn5b.getY()+62,
                60, 265, 120, 340, null);

        g.drawImage(imageChessTokens, pawn6b.getX()+6, pawn6b.getY()+6, pawn6b.getX()+62, pawn6b.getY()+62,
                60, 265, 120, 340, null);

        g.drawImage(imageChessTokens, pawn7b.getX()+6, pawn7b.getY()+6, pawn7b.getX()+62, pawn7b.getY()+62,
                60, 265, 120, 340, null);

        g.drawImage(imageChessTokens, pawn8b.getX()+6, pawn8b.getY()+6, pawn8b.getX()+62, pawn8b.getY()+62,
                60, 265, 120, 340, null);


        // Draws PLAYER2's Rook tokens.
        g.drawImage(imageChessTokens, rook1b.getX()+6, rook1b.getY()+6, rook1b.getX()+62, rook1b.getY()+62,
                270, 265, 325, 335, null);

        g.drawImage(imageChessTokens, rook2b.getX()+6, rook2b.getY()+6, rook2b.getX()+62, rook2b.getY()+62,
                270, 265, 325, 335, null);


        // Draws PLAYER2's Knight tokens.
        g.drawImage(imageChessTokens, knight1b.getX()+6, knight1b.getY()+6, knight1b.getX()+62, knight1b.getY()+62,
                465, 265, 525, 335, null);

        g.drawImage(imageChessTokens, knight2b.getX()+6, knight2b.getY()+6, knight2b.getX()+62, knight2b.getY()+62,
                465, 265, 525, 335, null);


        // Draws PLAYER2's Bishop tokens.
        g.drawImage(imageChessTokens, bishop1b.getX()+6, bishop1b.getY()+6, bishop1b.getX()+62, bishop1b.getY()+62,
                675, 265, 725, 335, null);

        g.drawImage(imageChessTokens, bishop2b.getX()+6, bishop2b.getY()+6, bishop2b.getX()+62, bishop2b.getY()+62,
                675, 265, 725, 335, null);


        // Draws PLAYER2's Queen token.
        g.drawImage(imageChessTokens, queen1b.getX()+6, queen1b.getY()+6, queen1b.getX()+62, queen1b.getY()+62,
                865, 260, 940, 340, null);


        // Draws PLAYER2's King token.
        g.drawImage(imageChessTokens, king1b.getX()+6, king1b.getY()+6, king1b.getX()+62, king1b.getY()+62,
                1080, 265, 1135, 335, null);

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
