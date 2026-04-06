package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class WoodenChestplate extends Chestplate {
    public WoodenChestplate(long amt) {
        super("Wooden Chestplate", amt);
    }

    @Override
    public int getHpBuff() {
        return 8;
    }

    @Override
    public int getAtkBuff() {
        return 1;
    }
}
