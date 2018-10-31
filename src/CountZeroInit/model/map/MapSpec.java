package CountZeroInit.model.map;

import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.surroundings.Tile;

import java.util.List;

public abstract class MapSpec {
    List<LifeForm> lifeFormsOnBoard;
    List<Tile> tiles;

}
