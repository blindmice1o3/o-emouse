package Tinker.chess_game.model;

import Tinker.chess_game.model.token.ChessToken;

import java.awt.*;

public class Tile {
    public static final int WIDTHBORDER = 70;
    public static final int HEIGHTBORDER = 70;
    public static final int WIDTHTILE = WIDTHBORDER - 10;
    public static final int HEIGHTTILE = HEIGHTBORDER - 10;

    private String rankAndFile;
    private Color colorTile;
    private Color colorBorder;
    private int xBorder, yBorder, xTile, yTile;

    private ChessToken token;

    public Tile(String rankAndFile, int xBorder, int yBorder, Color colorTile) {

        this.rankAndFile = rankAndFile;

        this.xBorder = xBorder;
        this.yBorder = yBorder;

        this.xTile = xBorder + 5;
        this.yTile = yBorder + 5;

        this.colorBorder = colorTile;       // Initially have the color of the border be the same as the color of the tile.
        this.colorTile = colorTile;

    } // end Tile(String, int, int, Color) constructor

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

    public int getXBorder() {
        return xBorder;
    }

    public int getYBorder() {
        return yBorder;
    }

    public int getXTile() { return xTile; }

    public int getYTile() { return yTile; }

    public Color getColorTile() { return colorTile; }

    public Color getColorBorder() { return colorBorder; }

    public void setColorBorder(Color colorBorder) {
        this.colorBorder = colorBorder;
    }
}
