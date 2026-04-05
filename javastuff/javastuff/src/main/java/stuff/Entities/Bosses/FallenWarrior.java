package stuff.Entities.Bosses;

import stuff.Entities.*;

public class FallenWarrior extends Enemy {
    private int tornadoSkillCooldown = 5;

    public FallenWarrior(int maxhp, int atk, int mincash, int maxcash) {
        super(maxhp, atk, "[BOSS] Fallen Warrior", mincash, maxcash);
    }

    public int tornadoSkill() {
        if (tornadoSkillCooldown == 0) {
            tornadoSkillCooldown = 5;
            return (int)Math.pow(atk, 1.3);
        } else {
            tornadoSkillCooldown--;
            return atk;
        }
    }

    public String getTornadoSkill() {
        return "(" + tornadoSkillCooldown + ") Tornado";
    }
}
