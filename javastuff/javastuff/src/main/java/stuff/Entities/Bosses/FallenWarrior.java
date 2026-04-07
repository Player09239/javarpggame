package stuff.Entities.Bosses;

import stuff.Entities.*;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Inventory.Items.*;

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

    public java.lang.String getTornadoSkill() {
        return "(" + tornadoSkillCooldown + ") Tornado";
    }

    public Item[] dropItems() {
        int fragment = (int)(Math.random() * 4);

        double randomForSoul = Math.random();
        int soul;
        if (randomForSoul <= 0.1) {
            soul = 1;
        } else soul = 0;

        Item[] loot = new Item[2];

        if (fragment != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new WarriorArmorFragment(fragment);
                    break;
                }
            }
        }

        if (soul != 0) {
            for (int i = 0; i < 2; i++) {
                if (loot[i] == null) {
                    loot[i] = new WarriorSoul(soul);
                    break;
                }
            }
        }

        return loot;
    }
}
