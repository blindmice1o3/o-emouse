package Tinker.chess_game.model;

import java.util.HashMap;
import java.util.Map;

public class Chessboard {
    // WHEN THE VALUES PRINTS OUT, it's unordered!!!
    private Map<String, Tile> board;

    public Chessboard() {
        // Chessboard is now stored as a HashMap instead of a LinkedList.
        board = new HashMap<String, Tile>();

        // Instantiate the 64 Tile objects and put them in a HashMap to represent the Chessboard.
        initChessboard();
    }

    public void initChessboard() {
    // Variables to feed the Tile's constructor... each Tile's rankAndFile (String) and its location (int x, int y).

        // First Tile's rank is "8".
        int rankInt = 8;
        String rank = makeStringRank(rankInt);

        // First Tile's file is "A" (determined by an int that is casted to a char that is supplied to find its
        // corresponding String.
        int fileInt = 65;
        String file = makeStringFile(fileInt);

        // First Tile's location (x, y).
        int x = 0;
        int y = 0;

        // Local variable to store the Tile object that's to be instantiated inside the nested for-loop.
        Tile tile;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tile = new Tile(rank + file, x, y);
                board.put(tile.getRankAndFile(), tile);

                x += Tile.width;
                fileInt++;
                file = makeStringFile(fileInt);
            }

            x = 0;
            y += Tile.height;
            rankInt--;
            rank = makeStringRank(rankInt);
            fileInt = 65;
            file = makeStringFile(fileInt);

        }

        for(Tile tile1: board.values()) {
            System.out.println(tile1.getRankAndFile() + ", " + tile1.getX() + ", " + tile1.getY());
        }
    }

    private String makeStringRank(int rankInt) {
        return Integer.toString(rankInt);
    }

    private String makeStringFile(int fileInt) {
        char fileChar = (char)fileInt;
        return Character.toString(fileChar);
    }
}
