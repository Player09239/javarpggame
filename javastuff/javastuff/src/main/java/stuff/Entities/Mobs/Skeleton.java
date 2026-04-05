package stuff.Entities.Mobs;

import stuff.Entities.Enemy;

public class Skeleton extends Enemy {
    public Skeleton(int maxhp, int atk, int mincash, int maxcash) {
        super(maxhp, atk, "Skeleton", mincash, maxcash);
    }
}
