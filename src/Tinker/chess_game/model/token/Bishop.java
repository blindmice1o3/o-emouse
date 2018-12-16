package Tinker.chess_game.model.token;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class Bishop extends ChessToken {
    public Bishop(Player player, int x, int y) {
        super(player, x, y);

        player1ImageCoordinate[0] = 675;
        player1ImageCoordinate[1] = 65;
        player1ImageCoordinate[2] = 735;
        player1ImageCoordinate[3] = 135;

        player2ImageCoordinate[0] = 675;
        player2ImageCoordinate[1] = 265;
        player2ImageCoordinate[2] = 725;
        player2ImageCoordinate[3] = 335;
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }
}
