package CountZeroInit.model.map;

import CountZeroInit.model.surroundings.Tile;
import CountZeroInit.model.surroundings.Walkable;

import java.util.List;

public class Map {
    private Tile[][] gameBoard;
    private MapSpec mapSpec;

    public Map(MapSpec mapSpec) {
        gameBoard = new Tile[5][5];
        this.mapSpec = mapSpec;

        setGameBoard();
        setLifeFormColRow();
    }

    public void setGameBoard() {
        int i = 0;
        List<Tile> floorPlan = mapSpec.getTiles();

        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 5; row++) {
                gameBoard[col][row] = floorPlan.get(i);
                i++;
            }
        }
    }

    public void setLifeFormColRow() {
        if (gameBoard[0][2] instanceof Walkable) {
            mapSpec.lifeFormsOnBoard.get(0).setCol(0);
            mapSpec.lifeFormsOnBoard.get(0).setRow(2);
        }

        if (gameBoard[2][3] instanceof Walkable) {
            mapSpec.lifeFormsOnBoard.get(1).setCol(2);
            mapSpec.lifeFormsOnBoard.get(1).setRow(3);
        }
    }

    public Tile[][] getGameBoard() {
        return gameBoard;
    }
    public MapSpec getMapSpec() { return mapSpec; }
}
