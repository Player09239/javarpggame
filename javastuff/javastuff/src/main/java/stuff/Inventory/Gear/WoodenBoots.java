package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class WoodenBoots extends Boots {
    public WoodenBoots(long amt) {
        super("Wooden Boots", amt);
    }

    @Override
    public int getHpBuff() {
        return 5;
    }

    @Override
    public int getAtkBuff() {
        return 1;
    }
}
