package Tinker.chess_game.model;

import Tinker.chess_game.view_controller.ChessGame.Player;

public class ChessSet {
    private ChessBoard chessBoard;

    private ChessTokenSetPlayer1 chessTokenSetPlayer1;
    private ChessTokenSetPlayer2 chessTokenSetPlayer2;

    public ChessSet(Player player1, Player player2) {
        chessBoard = new ChessBoard();

        chessTokenSetPlayer1 = new ChessTokenSetPlayer1(player1);
        chessTokenSetPlayer2 = new ChessTokenSetPlayer2(player2);

    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public ChessTokenSetPlayer1 getChessTokenSetPlayer1() {
        return  chessTokenSetPlayer1;
    }

    public ChessTokenSetPlayer2 getChessTokenSetPlayer2() {
        return chessTokenSetPlayer2;
    }
}
