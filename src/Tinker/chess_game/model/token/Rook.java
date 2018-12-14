package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Rook extends ChessToken {

    public Rook(Player player, int x, int y) {
        super(player, x, y);

    }

    public boolean isValueMove(int futureCol, int futureRow) {
        return false;
    }
}
