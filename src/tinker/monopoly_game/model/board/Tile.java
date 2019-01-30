package tinker.monopoly_game.model.board;

public class Tile {

    private int boardPosition;
    private TileType type;
    private TileSpec spec;

    public Tile(int boardPosition, TileType type, TileSpec spec) {
        this.boardPosition = boardPosition;
        this.type = type;
        this.spec = spec;
    } // **** end Tile(int, TileType, TileSpec) constructor ****

} // **** end Tile class ****
