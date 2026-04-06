package stuff.Inventory.BaseItemClasses;

import stuff.Entities.Player;

public class Boots extends Gear {
    public Boots(String name, long amt) {
        super(name, amt);
    }

    public void equip(Player plr) {
        plr.equip(this, "bootsSlot");
    }
}
