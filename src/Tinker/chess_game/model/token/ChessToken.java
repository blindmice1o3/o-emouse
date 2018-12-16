package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

import javax.swing.*;
import java.awt.*;

public abstract class ChessToken {
    public static final int width = 70;
    public static final int height = 70;

    int[] player1ImageCoordinate;
    int[] player2ImageCoordinate;

    private String imageAddressChessTokens = "src/CountZeroInit/model/icons/chess_tokens.png";
    private ImageIcon iiChessTokens;
    private Image imageChessTokens;

    private Player player;
    private int x, y;

    public ChessToken(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;

        iiChessTokens = new ImageIcon(imageAddressChessTokens);
        imageChessTokens = iiChessTokens.getImage();
        player1ImageCoordinate = new int[4];
        player2ImageCoordinate = new int[4];
    }

    public int[] getTokenImageCoordinate(Player player) {
        if (player == Player.PLAYER1) {
            return player1ImageCoordinate;
        } else {
            return player2ImageCoordinate;
        }
    }

    public Image getImageChessTokens() {
        return imageChessTokens;
    }

    public abstract boolean isValidMove(int futureCol, int futureRow);

    public Player getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
