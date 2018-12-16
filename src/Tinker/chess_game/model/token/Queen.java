package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Queen extends ChessToken {
    int[] queenPlayer1ImageCoordinate = { 860, 65, 930, 145 };
    int[] queenPlayer2ImageCoordinate = { 865, 260, 940, 340 };

    public Queen(Player player, int x, int y) {
        super(player, x, y);
    }

    public int[] getTokenImageCoordinate(Player player) {
        if (player == Player.PLAYER1) {
            return queenPlayer1ImageCoordinate;
        } else {
            return queenPlayer2ImageCoordinate;
        }
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
