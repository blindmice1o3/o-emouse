package CountZeroInit.model.creatures;

import CountZeroInit.model.items.*;

public abstract class MonsterFactory {


    public static Monster orderMonster(String name, String type) {
        Monster monster;

        monster = createMonster(name, type);
        equipMonster(monster);

        return monster;
    }

    public static Monster createMonster(String name, String type) {
        return new ThunderMouse(name, type);
    }

    public static void equipMonster(Monster monster) {
        monster.weapon = createWeapon();
        monster.armor = createArmor();
        monster.items.add(createItem());

    }

    public static Weapon createWeapon() {
        return new LightningShockWeapon("lightningshockweapon", 1);
    }

    public static Armor createArmor() {
        return new CardboardShoulderPads("cardboardshoulderpads", 2);
    }

    public static Item createItem() {
        return new PlasticSpork("plasticspork");
    }

}
