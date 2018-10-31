package CountZeroInit.model.map;

import CountZeroInit.model.creatures.*;
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

        lifeFormsOnBoard.add(MonsterFactory.orderMonster("Winnie", "pooh"));
        lifeFormsOnBoard.add(new Humanoid("Quiet Riot", "humanoid"));
    }
}
