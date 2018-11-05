package CountZeroInit.model.map;

import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.surroundings.Tile;


import java.util.List;

public abstract class Map {
    List<LifeForm> lifeFormsOnBoard;
    List<Tile> tiles;

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<LifeForm> getLifeFormsOnBoard() {
        return lifeFormsOnBoard;
    }
}
