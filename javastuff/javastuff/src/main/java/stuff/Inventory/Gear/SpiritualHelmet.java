package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class SpiritualHelmet extends Helmet {
    public SpiritualHelmet(long amt) {
        super("Spiritual Helmet", amt);
    }

    @Override
    public int getHpBuff() {
        return 50;
    }

    @Override
    public int getAtkBuff() {
        return 10;
    }
}
