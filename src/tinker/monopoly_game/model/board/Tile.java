package tinker.monopoly_game.model.board;

import java.util.HashMap;

public class Tile {

    private int boardPosition;
    private ItemType type;
    private MapOfSpecs mapOfSpecs;

    public Tile(int boardPosition, ItemType type, MapOfSpecs mapOfSpecs) {
        this.boardPosition = boardPosition;
        this.type = type;
        this.mapOfSpecs = mapOfSpecs;
    } // **** end Tile(int, ItemType, MapOfSpecs) constructor ****

    public int getBoardPosition() {
        return boardPosition;
    }

    public String toString() {
        return "\n(boardPosition: " + boardPosition + ")"
                + "\n(type: " + type + ")"
                + "\n(mapOfSpecs: " + mapOfSpecs + ")";
    }

} // **** end Tile class ****
