package CountZeroInit.model.creatures;

import CountZeroInit.model.items.Armor;
import CountZeroInit.model.items.Item;
import CountZeroInit.model.items.Weapon;

public class ThunderMouse extends Monster {
    public ThunderMouse(String name, String type) {
        super(name, type);
    }

    public void setWeapon(Weapon weapon) {
        super.setWeapon(weapon);
    }

    public void setArmor(Armor armor) {
        super.setArmor(armor);
    }

    public void setItems(Item[] items) {
        super.setItems(items);
    }
}
