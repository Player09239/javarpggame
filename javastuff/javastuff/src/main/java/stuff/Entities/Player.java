package stuff.Entities;

public class Player {
    private int maxhp;
    private int hp;
    private int atk;
    private int cash;

    private int healthlv;
    private int atklv;
    
    public Player(int maxhp, int atk) {
        this.maxhp = maxhp;
        this.hp = maxhp;
        this.atk = atk;
        this.cash = 0;

        this.healthlv = 23435333;
        this.atklv = 13847384;
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

    public int getCash() {
        return cash;
    }

    public void addCash(int amount) {
        cash += amount;
    }

    public void removeCash(int amount) {
        cash -= amount;
    }

    public void resetHealth() {
        hp = maxhp;
    }

    public int getAtkLv() {
        return atklv;
    }

    public int getHealthLv() {
        return healthlv;
    }

    public void addHealthLv(int amount) {
        healthlv += amount;
    }

    public void addAtkLv(int amount) {
        atklv += amount;
    }

    public void changeMaxHealth(int newHp) {
        maxhp = newHp;
    }

    public void changeAtk(int newatk) {
        atk = newatk;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxhp;
    }
}
