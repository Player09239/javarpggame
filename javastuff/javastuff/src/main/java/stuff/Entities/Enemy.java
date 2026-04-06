package stuff.Entities;

import stuff.Inventory.BaseItemClasses.Item;
import stuff.Utilities.*;

public class Enemy {
    protected long maxhp;
    protected long hp;
    protected long atk;
    protected String name;
    protected long level = 1;

    protected long mincash;
    protected long maxcash;

    public Enemy(long maxhp, long atk, String name, long mincash, long maxcash) {
        this.maxhp = maxhp;
        this.hp = maxhp;
        this.atk = atk;
        this.name = name;

        this.mincash = mincash;
        this.maxcash = maxcash;
    }

    static String colorHp(long max, long hp) {
        double pct = (double) hp / max * 100;

        if (pct > 75) {
            return Color.green(new Util().abbreviate(hp));
        } else if (pct > 50) {
            return Color.yellow(new Util().abbreviate(hp));
        } else if (pct > 25) {
            return Color.orange(new Util().abbreviate(hp));
        } else {
            return Color.red(new Util().abbreviate(hp));
        }
    }

    public void takeDamage(long dmg) {
        hp -= dmg;
    }

    public boolean checkIfAlive() {
        return hp > 0;
    }

    public String displayHealth() {
        return ":: Health   " + colorHp(maxhp, hp) + "/" + new Util().abbreviate(maxhp) + " ::";
    }

    public long getAtk() {
        return atk;
    }

    public void resetHealth() {
        hp = maxhp;
    }

    public void changeMaxHealth(long newHp) {
        maxhp = newHp;
    }

    public long getHp() {
        return hp;
    }

    public long getMaxHp() {
        return maxhp;
    }

    public String getName() {
        return name;
    }

    public long rewardCash() {
        return (long)(Math.random() * (maxcash - mincash + 1)) + mincash;
    }

    public void setLevel(long lv) {
        level = lv;
    } 

    public void scale() {
        maxhp = (long)(maxhp * (level * 1.12));
        atk = (long)(atk * (level * 1.12));
        mincash = (long)(mincash * (level * 1.107));
        maxcash = (long)(maxcash * (level * 1.107));
        hp = maxhp;
    }

    public long getLevel() {
        return level;
    }

    public Item[] dropItems() {
        return new Item[0];
    }
}
