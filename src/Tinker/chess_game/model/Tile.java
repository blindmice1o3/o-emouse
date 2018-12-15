package Tinker.chess_game.model;

import Tinker.chess_game.model.token.ChessToken;

public class Tile {
    public static final int width = 70;
    public static final int height = 70;

    private String rankAndFile;
    private int x, y;

    private ChessToken token;

    public Tile(String rankAndFile, int x, int y) {
        this.rankAndFile = rankAndFile;
        this.x = x;
        this.y = y;
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

    public String getRankAndFile() {
        return rankAndFile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
