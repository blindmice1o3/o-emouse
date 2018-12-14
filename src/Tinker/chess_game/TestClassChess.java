package Tinker.chess_game;

import Tinker.chess_game.token.ChessToken;

public class TestClassChess {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.displayChessBoard();

        /*
        // displays each value of the ChessToken enum on one row with a ", " separator inbetween the values unless it's
        // the last value of the ChessToken enum (in which case, it inserts a new line).
        int count = 0;
        int lengthChessTokenEnum = ChessToken.values().length;
        for (ChessToken token : ChessToken.values()) {

            System.out.print(token);

            if (count < lengthChessTokenEnum-1) {
                System.out.print(", ");
            } else {
                System.out.println("\n");
            }

            count++;

        }
        */
    } // end main()

} // end TestClassChess class