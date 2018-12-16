package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

import javax.swing.*;
import java.awt.*;

public abstract class ChessToken {
    public static final int width = 70;
    public static final int height = 70;

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
    }

    public Image getImageChessTokens() {
        return imageChessTokens;
    }

    public abstract int[] getTokenImageCoordinate(Player player);

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
