package Tinker.chess_game.model;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class ChessSet {
    ChessBoard board;

    ChessTokenSetPlayer1 tokenSetPlayer1;
    ChessTokenSetPlayer2 tokenSetPlayer2;

    public ChessSet(Player player1, Player player2) {
        board = new ChessBoard();

        tokenSetPlayer1 = new ChessTokenSetPlayer1(player1);
        tokenSetPlayer2 = new ChessTokenSetPlayer2(player2);

    }

}
