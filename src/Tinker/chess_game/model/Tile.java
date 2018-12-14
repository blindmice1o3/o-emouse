package Tinker.chess_game.model;

import Tinker.chess_game.model.token.ChessToken;

public class Tile {
    int x, y;
    int width, height;

    String file, rank;

    ChessToken token;

    public Tile(int x, int y, int width, int height, String file, String rank) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.file = file;
        this.rank = rank;
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
}
