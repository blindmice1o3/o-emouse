package Tinker.chess_game;

import Tinker.chess_game.token.ChessToken;

public class ChessBoard {
    private final int row = 8;
    private final int col = 8;

    private int[][] board;

    public ChessBoard() {
        initChessBoard();
    }

    public void initChessBoard() {
        board = new int[col][row];

        board[0][0] = 2;
        board[1][0] = 2;
        board[2][0] = 2;

        board[0][1] = 3;
        board[0][2] = 3;

        board[1][1] = 4;
        board[1][2] = 4;

        board[2][1] = 5;
        board[2][2] = 5;
    }

    public void displayChessBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

}
