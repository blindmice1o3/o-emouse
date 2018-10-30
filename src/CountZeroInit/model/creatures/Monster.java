package CountZeroInit.model.creatures;

import CountZeroInit.model.items.Armor;
import CountZeroInit.model.items.Item;
import CountZeroInit.model.items.Weapon;

public abstract class Monster extends LifeForm {
    Weapon weapon;
    Armor armor;
    Item[] items;


    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setItems(Item[] items){
        this.items = items;
    }

    public void equipMonster() {

    }

}
