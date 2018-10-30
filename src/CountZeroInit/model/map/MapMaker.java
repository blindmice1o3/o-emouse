package CountZeroInit.model.map;

import CountZeroInit.model.surroundings.Grass;
import CountZeroInit.model.surroundings.Tile;

public class MapMaker {
    Map map;


    public MapMaker(MapSpec mapSpec) {
        map = new Map(mapSpec);
    }

    public void go() {

        for (int col = 0; col < 20; col++) {
            for (int row = 0; row < 20; row++) {
               //map.gameBoard[col][row] = new Grass(col, row);
            }
        };
    }
}
