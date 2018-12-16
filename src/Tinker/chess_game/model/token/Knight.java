package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Knight extends ChessToken {
    int[] knightPlayer1ImageCoordinate = { 465, 65, 525, 135 };
    int[] knightPlayer2ImageCoordinate = { 465, 265, 525, 335 };

    public Knight(Player player, int x, int y) {
        super(player, x, y);

    }

    public int[] getTokenImageCoordinate(Player player) {
        if (player == Player.PLAYER1) {
            return knightPlayer1ImageCoordinate;
        } else {
            return knightPlayer2ImageCoordinate;
        }
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
