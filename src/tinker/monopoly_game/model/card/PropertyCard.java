package tinker.monopoly_game.model.card;

import tinker.monopoly_game.model.board.ItemType;
import tinker.monopoly_game.model.board.MapOfSpecs;

public class PropertyCard {

    private String owner;

    private int boardPosition;
    private ItemType type;
    private MapOfSpecs mapOfSpecs;

    public PropertyCard(int boardPosition, ItemType type, MapOfSpecs mapOfSpecs) {
        this.boardPosition = boardPosition;
        this.type = type;
        this.mapOfSpecs = mapOfSpecs;
    } // **** end PropertyCard(int, ItemType, MapOfSpecs) constructor ****

    public int getBoardPosition() {
        return boardPosition;
    }

    public ItemType getItemType() {
        return type;
    }

    public MapOfSpecs getMapOfSpecs() {
        return mapOfSpecs;
    }

} // **** end PropertyCard class ****
