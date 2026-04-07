package stuff.Inventory.Gear;

import stuff.Inventory.BaseItemClasses.*;
import stuff.Entities.*;

public class SpiritualBoots extends Boots {
    public SpiritualBoots(long amt) {
        super("Spiritual Boots", amt);
    }

    @Override
    public int getHpBuff() {
        return 45;
    }

    @Override
    public int getAtkBuff() {
        return 10;
    }

    public void craft(Player plr) {
        
    }
}
