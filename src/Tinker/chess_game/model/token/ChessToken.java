package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public abstract class ChessToken {
    Player player;
    int x, y;


    public ChessToken(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;
    }

    public abstract boolean isValidMove(int futureCol, int futureRow);


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
