package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;
import stuff.Entities.*;

public class BoneBoots extends Boots {
    public BoneBoots(long amt) {
        super("Bone Boots", amt);
    }

    @Override
    public int getHpBuff() {
        return 16;
    }

    @Override
    public int getAtkBuff() {
        return 4;
    }

    public void craft(Player plr) {
        
    }
}
