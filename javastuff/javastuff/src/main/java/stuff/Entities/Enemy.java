package stuff.Entities;

public class Enemy {
    protected int maxhp;
    protected int hp;
    protected int atk;
    protected String name;

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
}
