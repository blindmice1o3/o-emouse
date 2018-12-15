package Tinker.chess_game.model;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    // WHEN THE VALUES PRINTS OUT, it's unordered!!!
    private Map<String, Tile> board;

    public ChessBoard() {
        // ChessBoard is now stored as a HashMap instead of a LinkedList.
        board = new HashMap<String, Tile>();

        // Instantiate the 64 Tile objects and put them in a HashMap to represent the ChessBoard.
        initChessBoard();
    }

    public void initChessBoard() {
    // Tile's constructor requires arguments: (1) String rankAndFile, (2) int x, and (3) int y.
    // Another way to say this is, a name and coordinate point are used to instantiate a Tile object.

    // Local variables to feed the Tile's constructor:
        // The first Tile's rank is "8".
        int rankInt = 8;
        String rank = makeStringRank(rankInt);

        // The first Tile's file is "A" (determined by an int that is casted to a char that is supplied to find its
        // corresponding String).
        int fileInt = 65;
        String file = makeStringFile(fileInt);

        // The first Tile's location (x, y).
        int x = 0;
        int y = 0;

        // Local variable to store the Tile object that's to be instantiated inside the nested for-loop.
        Tile tile;

        // TODO: Write the comment to explain how this nested for-loop instantiates 64 Tile objects and put() them into the HashMap referred to as board.
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

        // This console output is just to verify that the 64 Tile objects were instantiated and put() into the HashMap board.
        for(Tile tile1: board.values()) {
            System.out.println(tile1.getRankAndFile() + ", " + tile1.getX() + ", " + tile1.getY());
        }
    }

    // Private helper method used to keep ChessBoard's implementation code more tidy and readable.
    private String makeStringRank(int rankInt) {
        return Integer.toString(rankInt);
    }

    // Private helper method used to keep ChessBoard's implementation code more tidy and readable.
    private String makeStringFile(int fileInt) {
        char fileChar = (char)fileInt;
        return Character.toString(fileChar);
    }
}
