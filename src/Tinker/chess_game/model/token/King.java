package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class King extends ChessToken {
    int[] kingPlayer1ImageCoordinate = { 1080, 65, 1135, 135 };
    int[] kingPlayer2ImageCoordinate = { 1080, 265, 1135, 335 };

    public King(Player player, int x, int y) {
        super(player, x, y);

    }

    public int[] getTokenImageCoordinate(Player player) {
        if (player == Player.PLAYER1) {
            return kingPlayer1ImageCoordinate;
        } else {
            return kingPlayer2ImageCoordinate;
        }
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
