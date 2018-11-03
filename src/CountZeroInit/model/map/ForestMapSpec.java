package CountZeroInit.model.map;

import CountZeroInit.model.creatures.*;
import CountZeroInit.model.items.CardboardShoulderPads;
import CountZeroInit.model.items.LightningShockWeapon;
import CountZeroInit.model.items.PlasticSpork;
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


        Humanoid player1 = new Humanoid("Quiet Riot", "humanoid");
        player1.getInventory().add(new PlasticSpork("plastic spork of player1"));
        player1.getInventory().add(new CardboardShoulderPads("cardboard shoulder pads of player1", 2));
        player1.getInventory().add(new LightningShockWeapon("lightning shock weapon of player1", 1));

        player1.getMyMonsterList().add(new ThunderMouse("Baby Brown", "bear"));
        player1.getMyMonsterList().add(new ThunderMouse("Bluee Cooie", "piglet"));

        lifeFormsOnBoard.add(MonsterFactory.orderMonster("Winnie the Pooh", "bear"));
        lifeFormsOnBoard.add(player1);
    }
}
