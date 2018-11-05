package CountZeroInit.model.creatures;

import CountZeroInit.model.items.Armor;
import CountZeroInit.model.items.Item;
import CountZeroInit.model.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster extends LifeForm {
    Weapon weapon;
    Armor armor;
    List<Item> items;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
        items = new ArrayList<Item>();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public void addItem(Item item){
        items.add(item);
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public Armor getArmor() {
        return armor;
    }
    public Item getItem(Item item) {
        Item returner = null;
        int i = items.indexOf(item);

        if (i >= 0) {
            returner = items.get(i);
        }

        return returner;
    }

}
