package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Queen extends ChessToken {
    public Queen(Player player, int x, int y) {
        super(player, x, y);

        player1ImageCoordinate[0] = 860;
        player1ImageCoordinate[1] = 65;
        player1ImageCoordinate[2] = 930;
        player1ImageCoordinate[3] = 145;

        player2ImageCoordinate[0] = 865;
        player2ImageCoordinate[1] = 260;
        player2ImageCoordinate[2] = 940;
        player2ImageCoordinate[3] = 340;
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
