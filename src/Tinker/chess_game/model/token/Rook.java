package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Rook extends ChessToken {
    public Rook(Player player, int x, int y) {
        super(player, x, y);

        player1ImageCoordinate[0] = 270;
        player1ImageCoordinate[1] = 60;
        player1ImageCoordinate[2] = 330;
        player1ImageCoordinate[3] = 140;

        player2ImageCoordinate[0] = 270;
        player2ImageCoordinate[1] = 265;
        player2ImageCoordinate[2] = 325;
        player2ImageCoordinate[3] = 335;
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
