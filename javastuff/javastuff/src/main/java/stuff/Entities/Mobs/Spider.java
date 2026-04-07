package stuff.Entities.Mobs;

import stuff.Entities.Enemy;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Inventory.Items.Web;

public class Spider extends Enemy {
    public Spider(long maxhp, long atk, long mincash, long maxcash) {
        super(maxhp, atk, "Spider", mincash, maxcash);
    }

    public Item[] dropItems() {
        int string = (int)(Math.random() * 2);

        double randomForWeb = Math.random();
        int web;
        if (randomForWeb <= 0.3) {
            web = 1;
        } else web = 0;

        Item[] loot = new Item[2];

        if (string != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new stuff.Inventory.Items.String(string);
                    break;
                }
            }
        }

        if (web != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new Web(web);
                    break;
                }
            }
        }

        return loot;
    }
}
