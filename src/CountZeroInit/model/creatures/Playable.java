package CountZeroInit.model.creatures;

import CountZeroInit.model.items.Item;

import java.util.ArrayList;
import java.util.List;

public interface Playable {
    List<Item> inventory = new ArrayList<Item>(40);

    List<Monster> monsters = new ArrayList<Monster>(6);

    public void keepMonster(Monster monster);
    public Monster getMonster(int i);
}
