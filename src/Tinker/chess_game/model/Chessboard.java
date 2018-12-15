package Tinker.chess_game.model;

import java.util.LinkedList;

public class Chessboard {
    private LinkedList<Tile> board;

    public Chessboard() {
        board = new LinkedList<Tile>();

        initChessboard();
    }

    public void initChessboard() {
        int x = 70;
        int y = 70;

        final int width = 70;
        final int height = 70;

        int fileInt = 65;
        char fileChar = (char)fileInt;
        String file = Character.toString(fileChar);
        int rankInt = 8;
        String rank = Integer.toString(rankInt);

        Tile tile;
        for (int i = 0; i < 64; i++) {
            if (i == 8) {
                x = 70;
                y += 70;
                rankInt--;
                rank = Integer.toString(rankInt);
                fileInt = 65;
                fileChar = (char)fileInt;
                file = Character.toString(fileChar);
            }
            if (i == 16) {
                x = 70;
                y += 70;
                rankInt--;
                rank = Integer.toString(rankInt);
                fileInt = 65;
                fileChar = (char)fileInt;
                file = Character.toString(fileChar);
            }
            if (i == 24) {
                x = 70;
                y += 70;
                rankInt--;
                rank = Integer.toString(rankInt);
                fileInt = 65;
                fileChar = (char)fileInt;
                file = Character.toString(fileChar);
            }
            if (i == 32) {
                x = 70;
                y += 70;
                rankInt--;
                rank = Integer.toString(rankInt);
                fileInt = 65;
                fileChar = (char)fileInt;
                file = Character.toString(fileChar);
            }
            if (i == 40) {
                x = 70;
                y += 70;
                rankInt--;
                rank = Integer.toString(rankInt);
                fileInt = 65;
                fileChar = (char)fileInt;
                file = Character.toString(fileChar);
            }
            if (i == 48) {
                x = 70;
                y += 70;
                rankInt--;
                rank = Integer.toString(rankInt);
                fileInt = 65;
                fileChar = (char)fileInt;
                file = Character.toString(fileChar);
            }
            if (i == 56) {
                x = 70;
                y += 70;
                rankInt--;
                rank = Integer.toString(rankInt);
                fileInt = 65;
                fileChar = (char)fileInt;
                file = Character.toString(fileChar);
            }


            tile = new Tile(x, y, width, height, file, rank);
            board.add(tile);

            x += 70;
            fileInt++;
            fileChar = (char)fileInt;
            file = Character.toString(fileChar);
        }

        for (int i = 0; i < 64; i++) {
            System.out.print(board.get(i).x + ", " + board.get(i).y + " *** ");
            System.out.print(board.get(i).width + ", " + board.get(i).height + " *** ");
            System.out.println(board.get(i).file + ", " + board.get(i).rank + " *** ");
        }
    }
}
