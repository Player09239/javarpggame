package stuff.Inventory.BaseItemClasses;

import stuff.Entities.Player;

public class Helmet extends Gear {
    public Helmet(String name, long amt) {
        super(name, amt);
    }

    public void equip(Player plr) {
        plr.equip(this, "headSlot");
    }
}
