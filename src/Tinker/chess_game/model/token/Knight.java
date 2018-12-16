package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Knight extends ChessToken {
    public Knight(Player player, int x, int y) {
        super(player, x, y);

        player1ImageCoordinate[0] = 465;
        player1ImageCoordinate[1] = 65;
        player1ImageCoordinate[2] = 525;
        player1ImageCoordinate[3] = 135;

        player2ImageCoordinate[0] = 465;
        player2ImageCoordinate[1] = 265;
        player2ImageCoordinate[2] = 525;
        player2ImageCoordinate[3] = 335;
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }

}
