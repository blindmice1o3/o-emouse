package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

import javax.swing.*;
import java.awt.*;

public abstract class ChessToken {
    Player player;
    int x, y;

    String imageAddressChessTokens = "src/CountZeroInit/model/icons/chess_tokens.png";
    ImageIcon iiChessTokens;
    Image imageChessTokens;

    public ChessToken(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;

        initImage();
    }

    public abstract boolean isValueMove(int futureCol, int futureRow);

    public void initImage() {
        iiChessTokens = new ImageIcon(imageAddressChessTokens);
        imageChessTokens = iiChessTokens.getImage();
    }

    public Image getImageChessTokens() {
        return imageChessTokens;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
