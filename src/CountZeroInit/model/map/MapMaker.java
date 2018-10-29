package CountZeroInit.model.map;

import CountZeroInit.model.surroundings.Grass;
import CountZeroInit.model.surroundings.Tile;

public class MapMaker {
    MapSpec mapSpec;

    public MapMaker(MapSpec mapSpec) {
        this.mapSpec = mapSpec;
    }

    public void go() {
        gameBoard = new Tile[20][20];

        for (int col = 0; col < 20; col++) {
            for (int row = 0; row < 20; row++) {
                gameBoard[col][row] = new Grass();
            }
        }
    }
}
