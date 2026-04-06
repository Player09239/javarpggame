package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class WoodenLeggings extends Leggings {
    public WoodenLeggings(long amt) {
        super("Wooden Leggings", amt);
    }

    @Override
    public int getHpBuff() {
        return 6;
    }

    @Override
    public int getAtkBuff() {
        return 2;
    }
}
