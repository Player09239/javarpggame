package stuff.Entities.Mobs;

import stuff.Entities.Enemy;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Inventory.Items.Essence;
import stuff.Inventory.Items.SpiritCore;

public class Spirit extends Enemy {
    public Spirit(long maxhp, long atk, long mincash, long maxcash) {
        super(maxhp, atk, "Spirit", mincash, maxcash);
    }

    public Item[] dropItems() {
        int essence = (int)(Math.random() * 2);

        double randomForSpiritCore = Math.random();
        int spiritCore;
        if (randomForSpiritCore <= 0.15) {
            spiritCore = 1;
        } else spiritCore = 0;

        Item[] loot = new Item[2];

        if (essence != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new Essence(essence);
                    break;
                }
            }
        }

        if (spiritCore != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new SpiritCore(spiritCore);
                    break;
                }
            }
        }

        return loot;
    }
}
