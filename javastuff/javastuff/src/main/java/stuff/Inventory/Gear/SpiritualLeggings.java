package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class SpiritualLeggings extends Leggings {
    public SpiritualLeggings(long amt) {
        super("Spiritual Leggings", amt);
    }

    @Override
    public int getHpBuff() {
        return 52;
    }

    @Override
    public int getAtkBuff() {
        return 14;
    }
}
