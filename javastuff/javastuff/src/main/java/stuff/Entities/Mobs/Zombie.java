package stuff.Entities.Mobs;

import stuff.Entities.Enemy;

public class Zombie extends Enemy {
    public Zombie(int maxhp, int atk, int mincash, int maxcash) {
        super(maxhp, atk, "Zombie", mincash, maxcash);
    }
}
