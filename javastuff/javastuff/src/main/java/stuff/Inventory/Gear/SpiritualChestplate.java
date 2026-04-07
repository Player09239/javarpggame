package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class SpiritualChestplate extends Chestplate {
    public SpiritualChestplate(long amt) {
        super("Spiritual Chestplate", amt);
    }

    @Override
    public int getHpBuff() {
        return 65;
    }

    @Override
    public int getAtkBuff() {
        return 11;
    }
}
