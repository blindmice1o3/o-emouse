package CountZeroInit.model.map;

import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.creatures.MonsterFactory;
import CountZeroInit.model.surroundings.Tile;

import java.util.ArrayList;
import java.util.List;

public class ForestMapSpec extends MapSpec {

    public ForestMapSpec() {
        lifeFormsOnBoard = new ArrayList();
        monstersOnBoard = new ArrayList();
    }
}
