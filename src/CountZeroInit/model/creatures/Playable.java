package CountZeroInit.model.creatures;

import CountZeroInit.model.items.Item;

import java.util.ArrayList;
import java.util.List;

public interface Playable {
    List<Item> myItemList = new ArrayList<Item>(40);
    List<Monster> myMonsterList = new ArrayList<Monster>(6);


    public Monster getMonster(int i);
    public void keepMonster(Monster monster);

}
