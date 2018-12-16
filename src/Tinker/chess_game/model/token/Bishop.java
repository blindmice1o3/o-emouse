package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Bishop extends ChessToken {
    int[] bishopPlayer1ImageCoordinate = { 675, 65, 735, 135 };
    int[] bishopPlayer2ImageCoordinate = { 675, 265, 725, 335 };

    public Bishop(Player player, int x, int y) {
        super(player, x, y);

    }

    public int[] getTokenImageCoordinate(Player player) {
        if (player == Player.PLAYER1) {
            return bishopPlayer1ImageCoordinate;
        } else {
            return bishopPlayer2ImageCoordinate;
        }
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
