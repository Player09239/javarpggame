package stuff.Inventory.BaseItemClasses;

import stuff.Entities.Player;

public class Leggings extends Gear {
    public Leggings(String name, long amt) {
        super(name, amt);
    }

    public void equip(Player plr) {
        plr.equip(this, "leggingsSlot");
    }
}
