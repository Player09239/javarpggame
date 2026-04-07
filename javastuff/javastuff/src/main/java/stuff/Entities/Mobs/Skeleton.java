package stuff.Entities.Mobs;

import stuff.Entities.Enemy;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Inventory.Items.Bone;

public class Skeleton extends Enemy {
    public Skeleton(long maxhp, long atk, long mincash, long maxcash) {
        super(maxhp, atk, "Skeleton", mincash, maxcash);
    }

    public Item[] dropItems() {
        int bone = (int)(Math.random() * 4);

        Item[] loot = new Item[1];

        if (bone != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new Bone(bone);
                    break;
                }
            }
        }

        return loot;
    }
}
