package stuff.Entities;

public class Enemy {
    protected int maxhp;
    protected int hp;
    protected int atk;
    protected String name;
    protected int level = 1;

    protected int mincash;
    protected int maxcash;

    public Enemy(int maxhp, int atk, String name, int mincash, int maxcash) {
        this.maxhp = maxhp;
        this.hp = maxhp;
        this.atk = atk;
        this.name = name;

        this.mincash = mincash;
        this.maxcash = maxcash;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
    }

    public boolean checkIfAlive() {
        return hp > 0;
    }

    public String displayHealth() {
        return ":: Health   " + hp + "/" + maxhp + " ::";
    }

    public int getAtk() {
        return atk;
    }

    public void resetHealth() {
        hp = maxhp;
    }

    public void changeMaxHealth(int newHp) {
        maxhp = newHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxhp;
    }

    public String getName() {
        return name;
    }

    public int rewardCash() {
        return (int)(Math.random() * (maxcash - mincash + 1)) + mincash;
    }

    public void setLevel(int lv) {
        level = lv;
    } 

    public void scale() {
        maxhp = (int)(maxhp * (level * 1.12));
        atk = (int)(atk * (level * 1.12));
        mincash = (int)(mincash * (level * 1.107));
        maxcash = (int)(maxcash * (level * 1.107));
        hp = maxhp;
    }

    public int getLevel() {
        return level;
    }
}
