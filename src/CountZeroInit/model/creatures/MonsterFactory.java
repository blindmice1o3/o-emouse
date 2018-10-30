package CountZeroInit.model.creatures;

import CountZeroInit.model.items.Armor;
import CountZeroInit.model.items.Item;
import CountZeroInit.model.items.Weapon;

public abstract class MonsterFactory {


    public Monster orderMonster(String name, String type) {
        Monster monster;

        monster = createMonster(name, type);

        monster.equipMonster();

        return monster;
    }

    public abstract Monster createMonster(String name, String type);



    public abstract Weapon createWeapon();
    public abstract Armor createArmor();
    public abstract Item[] createItems();

}
