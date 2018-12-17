package Tinker.chess_game.model;

import Tinker.chess_game.model.token.ChessToken;

import java.awt.*;

public class Tile {
    public static final int width = 70;
    public static final int height = 70;

    private String rankAndFile;
    private int x, y;
    private Color color;

    private ChessToken token;

    public Tile(String rankAndFile, int x, int y, Color color) {
        this.rankAndFile = rankAndFile;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public boolean hasToken() {
        return token != null;
    }

    public void setToken(ChessToken token) {
        this.token = token;
    }

    public ChessToken getToken() {
        return token;
    }

    public void setTokenNull() { token = null; }

    public String getRankAndFile() {
        return rankAndFile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() { return color; }
}
