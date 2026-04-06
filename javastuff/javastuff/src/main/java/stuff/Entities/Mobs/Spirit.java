package stuff.Entities.Mobs;

import stuff.Entities.Enemy;
import stuff.Inventory.Item;
import stuff.Inventory.Items.RottenFlesh;
import stuff.Inventory.Items.Wood;

public class Spirit extends Enemy {
    public Spirit(long maxhp, long atk, long mincash, long maxcash) {
        super(maxhp, atk, "Spirit", mincash, maxcash);
    }

    public Item[] dropItems() {
        int rottenFlesh = (int)(Math.random() * 4);

        double randomForWood = Math.random();
        int wood;
        if (randomForWood <= 0.25) {
            wood = 1;
        } else wood = 0;

        return new Item[] {
            new Wood(wood),
            new RottenFlesh(rottenFlesh)
        };
    }
}
