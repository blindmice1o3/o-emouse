package count_zero_init.model.map;

import count_zero_init.model.creatures.LifeForm;
import count_zero_init.model.surroundings.Tile;


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
