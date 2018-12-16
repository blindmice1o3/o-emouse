package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Pawn extends ChessToken {
    int[] pawnPlayer1ImageCoordinate = { 60, 60, 120, 140 };
    int[] pawnPlayer2ImageCoordinate = { 60, 265, 120, 340 };

    public Pawn(Player player, int x, int y) {
        super(player, x, y);

    }

    public int[] getTokenImageCoordinate(Player player) {
        if (player == Player.PLAYER1) {
            return pawnPlayer1ImageCoordinate;
        } else {
            return pawnPlayer2ImageCoordinate;
        }
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }

}
