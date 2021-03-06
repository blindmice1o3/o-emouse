package count_zero_init.model.map;

import count_zero_init.model.creatures.*;
import count_zero_init.model.items.CardboardShoulderPads;
import count_zero_init.model.items.LightningShockWeapon;
import count_zero_init.model.items.PlasticSpork;
import count_zero_init.model.surroundings.Tree;

import java.util.ArrayList;

public class ForestMap extends Map {

    public ForestMap() {
        lifeFormsOnBoard = new ArrayList();
        tiles = new ArrayList();

        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 5; row++) {
                tiles.add(new Tree(col, row));
            }
        }


        Humanoid player1 = new Humanoid("humanoid");
        player1.getMyItemList().add(new PlasticSpork("plastic spork of player1"));
        player1.getMyItemList().add(new CardboardShoulderPads("cardboard shoulder pads of player1", 2));
        player1.getMyItemList().add(new LightningShockWeapon("lightning shock weapon of player1", 1));

        player1.getMyMonsterList().add(new ThunderMouse("Baby Brown", "bear"));
        player1.getMyMonsterList().add(new ThunderMouse("Bluee Cooie", "piglet"));


        player1.setCol(1);
        player1.setRow(4);

        Monster monster1 = MonsterFactory.orderMonster("Winnie the Pooh", "bear");
        monster1.setCol(1);
        monster1.setRow(0);


        lifeFormsOnBoard.add(monster1);
        lifeFormsOnBoard.add(player1);
    }
}
