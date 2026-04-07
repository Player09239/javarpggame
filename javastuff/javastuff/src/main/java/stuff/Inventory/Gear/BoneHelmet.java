package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class BoneHelmet extends Helmet {
    public BoneHelmet(long amt) {
        super("Bone Helmet", amt);
    }

    @Override
    public int getHpBuff() {
        return 18;
    }

    @Override
    public int getAtkBuff() {
        return 4;
    }
}
