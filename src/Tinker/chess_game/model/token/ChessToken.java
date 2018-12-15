package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public abstract class ChessToken {
    public static final int width = 70;
    public static final int height = 70;

    private Player player;
    private int x, y;

    public ChessToken(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;
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
