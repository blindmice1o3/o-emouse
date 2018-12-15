package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Pawn extends ChessToken {

    public Pawn(Player player, int x, int y) {
        super(player, x, y);

    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }

}
