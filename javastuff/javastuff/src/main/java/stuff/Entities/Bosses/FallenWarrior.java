package stuff.Entities.Bosses;

import stuff.Entities.*;
import stuff.Inventory.Item;
import stuff.Inventory.Items.RottenFlesh;
import stuff.Inventory.Items.Wood;

public class FallenWarrior extends Enemy {
    private long tornadoSkillCooldown = 5;

    public FallenWarrior(long maxhp, long atk, long mincash, long maxcash) {
        super(maxhp, atk, "[BOSS] Fallen Warrior", mincash, maxcash);
    }

    public long tornadoSkill() {
        if (tornadoSkillCooldown == 0) {
            tornadoSkillCooldown = 5;
            return (long)Math.pow(atk, 1.3);
        } else {
            tornadoSkillCooldown--;
            return atk;
        }
    }

    public String getTornadoSkill() {
        return "(" + tornadoSkillCooldown + ") Tornado";
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
