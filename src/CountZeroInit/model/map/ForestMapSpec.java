package CountZeroInit.model.map;

import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.surroundings.Grass;
import CountZeroInit.model.surroundings.Tile;

import java.util.List;

public class ForestMapSpec implements Map {
    Tile[][] gameBoard;
    List<LifeForm> lifeFormsOnBoard;
    List<Monster> monstersOnBoard;

    public ForestMapSpec() {
        
    }


}
