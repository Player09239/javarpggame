package stuff.Entities.Mobs;

import stuff.Entities.Enemy;
import stuff.Inventory.Item;
import stuff.Inventory.Items.RottenFlesh;
import stuff.Inventory.Items.Wood;

public class Zombie extends Enemy {
    public Zombie(long maxhp, long atk, long mincash, long maxcash) {
        super(maxhp, atk, "Zombie", mincash, maxcash);
    }

    public Item[] dropItems() {
        int rottenFlesh = (int)(Math.random() * 4);

        double randomForWood = Math.random();
        int wood;
        if (randomForWood <= 0.25) {
            wood = 1;
        } else wood = 0;

        Item[] loot = new Item[2];

        if (rottenFlesh != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new RottenFlesh(rottenFlesh);
                    break;
                }
            }
        }

        if (wood != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new Wood(wood);
                    break;
                }
            }
        }

        return loot;
    }
}
