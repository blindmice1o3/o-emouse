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
    String imageAddress;

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

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getImageAddress() {
        return imageAddress;
    }
}
