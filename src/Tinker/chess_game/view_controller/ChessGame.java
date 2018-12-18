package Tinker.chess_game.view_controller;

import Tinker.chess_game.model.ChessSet;
import Tinker.chess_game.model.Tile;
import Tinker.chess_game.model.token.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

public class ChessGame extends JPanel
        implements MouseListener {

    public enum Player {
        PLAYER1, PLAYER2;
    }

    ChessSet chessSet;
    Player whoseTurn = Player.PLAYER1;
    boolean gameOver = false;

    Map<String, Tile> board;
    List<ChessToken> player1ChessTokenSet;
    List<ChessToken> player2ChessTokenSet;

    Image imageChessTokens;

    String rankMouseClicked;
    String fileMouseClicked;

    public ChessGame() {

        this.setSize(new Dimension(560, 560));
        this.setLocation(new Point(((700 - 560) / 2), ((700 - 560) / 2)));
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 3, false));


        chessSet = new ChessSet(Player.PLAYER1, Player.PLAYER2);
        player1ChessTokenSet = chessSet.getChessTokenSetPlayer1().getTokenSet();
        player2ChessTokenSet = chessSet.getChessTokenSetPlayer2().getTokenSet();
        board = chessSet.getChessBoard().getBoard();

        imageChessTokens = player1ChessTokenSet.get(0).getImageChessTokens();

        rankMouseClicked = "";
        fileMouseClicked = "";

        setChessTokenOnChessBoard();

        this.addMouseListener(this);
        this.setFocusable(true);
        this.requestFocus();

        //startGame();

    } // **** end ChessGame() constructor ****

    /*
    public void startGame() {

        while(!gameOver) {
          if (whoseTurn == Player.PLAYER1) {        // if it's player1's turn
              getMouseSelection(whoseTurn);             // get player1's token selection (to be moved)
              checkMouseSelection();                    // make sure it's a token selected and it's player1's token
                                                        // get player1's destination Tile selection (where to be moved to)
                                                        // check that it's a move the selected token is eligible to do
                                                        // check if player2's token is on the selected destination Tile
          } else {                                  // otherwise it's player2's turn
               getMouseSelection(whoseTurn);            // the movements are reversed (instead of page_bottom to page_top,
               checkMouseSelection(                     //     it's page_top to page_bottom)
          }
        }

    } // **** end startGame() ****
    */

    @Override
    public void paintComponent(Graphics g) {

        // Paints the background grey, which is used as a grey margin/border (can use later for icons of captured tokens).
        super.paintComponent(g);

        // Draws chessboard with light (yellow) and dark (blue) squares.
        drawChessBoard(g);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ImageIcon imageIconWolfman = new ImageIcon("src/CountZeroInit/model/icons/wolfman.png");
        Image imageWolfman = imageIconWolfman.getImage();
        g.drawImage(imageWolfman, 210 + 5, 280 + 5, 280 - 5, 350 - 5, 0, 0, 256, 256, null);

        ImageIcon imageIconFishmonk = new ImageIcon("src/CountZeroInit/model/icons/3fish_blue_spirit.png");
        Image imageFishmonk = imageIconFishmonk.getImage();
        g.drawImage(imageFishmonk, 280 + 5, 280 + 5, 350 - 5, 350 - 5, 0, 0, 256, 256, null);

        ImageIcon imageIconRobot = new ImageIcon("src/CountZeroInit/model/icons/robot_flat_head.png");
        Image imageRobot = imageIconRobot.getImage();
        g.drawImage(imageRobot, 210 + 5, 210 + 5, 280 - 5, 280 - 5, 0, 0, 256, 256, null);

        ImageIcon imageIconMonkey = new ImageIcon("src/CountZeroInit/model/icons/5monkey.jpg");
        Image imageMonkey = imageIconMonkey.getImage();
        g.drawImage(imageMonkey, 280 + 5, 210 + 5, 350 - 5, 280 - 5, 0, 0, 256, 256, null);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    } // **** end paintComponent(Graphics) ****

    public String translateMouseClickToFile(MouseEvent e) {

        int xMouseClick = e.getX();

        if ((xMouseClick >= 0) && (xMouseClick < 70)) {
            return "A";
        } else if ((xMouseClick >= 70) && (xMouseClick < 140)) {
            return "B";
        } else if ((xMouseClick >= 140) && (xMouseClick < 210)) {
            return "C";
        } else if ((xMouseClick >= 210) && (xMouseClick < 280)) {
            return "D";
        } else if ((xMouseClick >= 280) && (xMouseClick < 350)) {
            return "E";
        } else if ((xMouseClick >= 350) && (xMouseClick < 420)) {
            return "F";
        } else if ((xMouseClick >= 420) && (xMouseClick < 490)) {
            return "G";
        } else if ((xMouseClick >= 490) && (xMouseClick < 560)) {
            return "H";
        } else {
            return "";
        }

    } // **** end translateMouseClickToFile(MouseEvent) ****

    public String translateMouseClickToRank(MouseEvent e) {

        int yMouseClick = e.getY();

        if ((yMouseClick >= 0) && (yMouseClick < 70)) {
            return "8";
        } else if ((yMouseClick >= 70) && (yMouseClick < 140)) {
            return "7";
        } else if ((yMouseClick >= 140) && (yMouseClick < 210)) {
            return "6";
        } else if ((yMouseClick >= 210) && (yMouseClick < 280)) {
            return "5";
        } else if ((yMouseClick >= 280) && (yMouseClick < 350)) {
            return "4";
        } else if ((yMouseClick >= 350) && (yMouseClick < 420)) {
            return "3";
        } else if ((yMouseClick >= 420) && (yMouseClick < 490)) {
            return "2";
        } else if ((yMouseClick >= 490) && (yMouseClick < 560)) {
            return "1";
        } else {
            return "";
        }

    } // **** end translateMouseClickToRank(MouseEvent) ****

    public void setChessTokenOnChessBoard() {

        board.get("2A").setToken(player1ChessTokenSet.get(0));
        board.get("2B").setToken(player1ChessTokenSet.get(1));
        board.get("2C").setToken(player1ChessTokenSet.get(2));
        board.get("2D").setToken(player1ChessTokenSet.get(3));
        board.get("2E").setToken(player1ChessTokenSet.get(4));
        board.get("2F").setToken(player1ChessTokenSet.get(5));
        board.get("2G").setToken(player1ChessTokenSet.get(6));
        board.get("2H").setToken(player1ChessTokenSet.get(7));

        board.get("1A").setToken(player1ChessTokenSet.get(8));
        board.get("1B").setToken(player1ChessTokenSet.get(10));
        board.get("1C").setToken(player1ChessTokenSet.get(12));
        board.get("1D").setToken(player1ChessTokenSet.get(14));
        board.get("1E").setToken(player1ChessTokenSet.get(15));
        board.get("1F").setToken(player1ChessTokenSet.get(13));
        board.get("1G").setToken(player1ChessTokenSet.get(11));
        board.get("1H").setToken(player1ChessTokenSet.get(9));

        board.get("7A").setToken(player2ChessTokenSet.get(0));
        board.get("7B").setToken(player2ChessTokenSet.get(1));
        board.get("7C").setToken(player2ChessTokenSet.get(2));
        board.get("7D").setToken(player2ChessTokenSet.get(3));
        board.get("7E").setToken(player2ChessTokenSet.get(4));
        board.get("7F").setToken(player2ChessTokenSet.get(5));
        board.get("7G").setToken(player2ChessTokenSet.get(6));
        board.get("7H").setToken(player2ChessTokenSet.get(7));

        board.get("8A").setToken(player2ChessTokenSet.get(8));
        board.get("8B").setToken(player2ChessTokenSet.get(10));
        board.get("8C").setToken(player2ChessTokenSet.get(12));
        board.get("8D").setToken(player2ChessTokenSet.get(14));
        board.get("8E").setToken(player2ChessTokenSet.get(15));
        board.get("8F").setToken(player2ChessTokenSet.get(13));
        board.get("8G").setToken(player2ChessTokenSet.get(11));
        board.get("8H").setToken(player2ChessTokenSet.get(9));

    } // **** end setChessTokenOnChessBoard() ****

    public void drawChessBoard(Graphics g) {

        ChessToken token = player1ChessTokenSet.get(0);
        int[] imageCoor = new int[4];
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (Tile tile : board.values()) {
            g.setColor(tile.getColor());
            g.fillRect(tile.getX(), tile.getY(), Tile.width, Tile.height);

            if (tile.hasToken()) {
                imageCoor = tile.getToken().getTokenImageCoordinate(tile.getToken().getPlayer());
                x1 = imageCoor[0];
                y1 = imageCoor[1];
                x2 = imageCoor[2];
                y2 = imageCoor[3];

                g.drawImage(imageChessTokens, tile.getX() + 5, tile.getY() + 5,
                        (tile.getX() + Tile.width) - 5, (tile.getY() + Tile.height) - 5,
                        x1, y1, x2, y2, null);
            }
        }

        g.setColor(Color.RED);
        g.drawString(whoseTurn.toString(), 50, 50);

    } // **** end drawChessBoard(Graphics) ****

    public enum Click {
        FIRST, SECOND;
    }
    boolean successfulTokenMove = false;
    Click selection = Click.FIRST;
    ChessToken selectedToken = null;

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("Mouse clicked: (" + e.getX() + ", " + e.getY() + "),\n" +
                "Rank/File: (" + translateMouseClickToRank(e) + "/" + translateMouseClickToFile(e) + ")\n" +
                "MouseEvent source => " + e.getSource().getClass());

            ////////////////////////////////////////////////////////////////////////////

        Tile selectedTile = board.get( translateMouseClickToRank(e) + translateMouseClickToFile(e) );

        // If client is selecting a token to move and has selected a Tile that actually has a Token on it... see who it belong to.
        if ( (selection == Click.FIRST) && (selectedTile.hasToken()) && (selectedTile.getToken().getPlayer() == whoseTurn)) {
            // store this selected token and let the else statement take care of which Tile to place the token.
            selectedToken = selectedTile.getToken();
            selectedTile.setToken(null);

            //selectedTile draw square around itself with YELLOW color.

            System.out.println("First click - inside if clause. WHOSETURN---------->" + whoseTurn);
            this.repaint();

            selection = Click.SECOND;
        }
        // Else client is selecting a position to place the selectedToken.
        else if ( (selection == Click.SECOND) && (!selectedTile.hasToken()) ) {
            selectedTile.setToken(selectedToken);
            selectedToken = null;
            successfulTokenMove = true;

            System.out.println("Second click - inside else clause. WHOSETURN---------->" + whoseTurn);
            this.repaint();

            selection = Click.FIRST;
        }

            ////////////////////////////////////////////////////////////////////////////

        if (successfulTokenMove && whoseTurn == Player.PLAYER1) {
            whoseTurn = Player.PLAYER2;
            successfulTokenMove = false;
        }
        else if (successfulTokenMove && whoseTurn == Player.PLAYER2) {
            whoseTurn = Player.PLAYER1;
            successfulTokenMove = false;
        }

    } // **** end mouseClicked(MouseEvent) ****

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

} // **** end ChessGame class ****