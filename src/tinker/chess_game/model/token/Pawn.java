package tinker.chess_game.model.token;

import tinker.chess_game.view_controller.ChessGame.Player;

public class Pawn extends ChessToken {
    public Pawn(Player player, int x, int y) {
        super(player, x, y);

        player1ImageCoordinate[0] = 60;
        player1ImageCoordinate[1] = 60;
        player1ImageCoordinate[2] = 120;
        player1ImageCoordinate[3] = 140;

        player2ImageCoordinate[0] = 60;
        player2ImageCoordinate[1] = 265;
        player2ImageCoordinate[2] = 120;
        player2ImageCoordinate[3] = 340;
    }

    public boolean isValidMove(int futureCol, int futureRow) {
        return false;
    }

}
