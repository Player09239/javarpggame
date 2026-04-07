package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class BoneLeggings extends Leggings {
    public BoneLeggings(long amt) {
        super("Bone Leggings", amt);
    }

    @Override
    public int getHpBuff() {
        return 20;
    }

    @Override
    public int getAtkBuff() {
        return 5;
    }
}
