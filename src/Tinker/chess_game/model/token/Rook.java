package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Rook extends ChessToken {
    int[] rookPlayer1ImageCoordinate = { 270, 60, 330, 140 };
    int[] rookPlayer2ImageCoordinate = { 270, 265, 325, 335 };

    public Rook(Player player, int x, int y) {
        super(player, x, y);

    }

    public int[] getTokenImageCoordinate(Player player) {
        if (player == Player.PLAYER1) {
            return rookPlayer1ImageCoordinate;
        } else {
            return rookPlayer2ImageCoordinate;
        }
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
