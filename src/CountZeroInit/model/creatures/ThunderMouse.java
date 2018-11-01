package CountZeroInit.model.creatures;

import CountZeroInit.model.items.Armor;
import CountZeroInit.model.items.Item;
import CountZeroInit.model.items.Weapon;

public class ThunderMouse extends Monster {


    public ThunderMouse(String name, String type) {
        super(name, type);
        setImageAddress("src/CountZeroInit/view/lightning.png");
    }

}
