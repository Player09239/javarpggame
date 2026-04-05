package stuff.Entities.Mobs;

import stuff.Entities.Enemy;

public class Spirit extends Enemy {
    public Spirit(int maxhp, int atk, int mincash, int maxcash) {
        super(maxhp, atk, "Spirit", mincash, maxcash);
    }
}
