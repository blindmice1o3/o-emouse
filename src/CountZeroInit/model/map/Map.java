package CountZeroInit.model.map;

import CountZeroInit.model.surroundings.Tile;

public class Map {
    private Tile[][] gameBoard;
    private MapSpec mapSpec;

    public Map(MapSpec mapSpec) {
        this.mapSpec = mapSpec;
        gameBoard = new Tile[20][20];
    }

    public void setGameBoard() {

    }

}
