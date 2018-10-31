package CountZeroInit.model.map;

import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.creatures.MonsterFactory;
import CountZeroInit.model.creatures.ThunderMouse;
import CountZeroInit.model.surroundings.Grass;
import CountZeroInit.model.surroundings.Tile;

import java.util.ArrayList;
import java.util.List;

public class ForestMapSpec extends MapSpec {

    public ForestMapSpec() {
        lifeFormsOnBoard = new ArrayList();
        tiles = new ArrayList();

        for (int col = 0; col < 20; col++) {
            for (int row = 0; row < 20; row++) {
                tiles.add(new Grass(col, row));
            }
        }

        lifeFormsOnBoard.add(new ThunderMouse("pooh", "bear"));
    }
}
