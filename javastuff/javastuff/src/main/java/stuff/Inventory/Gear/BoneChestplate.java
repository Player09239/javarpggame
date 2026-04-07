package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;

public class BoneChestplate extends Chestplate {
    public BoneChestplate(long amt) {
        super("Bone Chestplate", amt);
    }

    @Override
    public int getHpBuff() {
        return 27;
    }

    @Override
    public int getAtkBuff() {
        return 4;
    }
}
