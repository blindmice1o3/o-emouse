package CountZeroInit.model.map;

import CountZeroInit.model.surroundings.Grass;
import CountZeroInit.model.surroundings.Tile;
import CountZeroInit.model.surroundings.Walkable;

public class Map {
    private Tile[][] gameBoard;
    private MapSpec mapSpec;

    public Map(MapSpec mapSpec) {
        gameBoard = new Tile[20][20];
        this.mapSpec = mapSpec;

        setGameBoard();
        setLifeFormColRow();
    }

    public void setGameBoard() {
        int i = 0;
        for (int col = 0; col < 20; col++) {
            for (int row = 0; row < 20; row++) {
                gameBoard[col][row] = mapSpec.tiles.get(i);
                i++;
            }
        }
    }

    public void setLifeFormColRow() {
        if (gameBoard[0][4] instanceof Walkable) {
            mapSpec.lifeFormsOnBoard.get(0).setCol(0);
            mapSpec.lifeFormsOnBoard.get(0).setRow(4);
        }
    }

    public Tile[][] getGameBoard() {
        return gameBoard;
    }
}
