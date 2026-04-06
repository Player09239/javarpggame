package stuff.Inventory.BaseItemClasses;

import stuff.Entities.Player;

public class Chestplate extends Gear {
    public Chestplate(String name, long amt) {
        super(name, amt);
    }

    public void equip(Player plr) {
        plr.equip(this, "chestSlot");
    }
}
