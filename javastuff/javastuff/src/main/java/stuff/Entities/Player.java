package stuff.Entities;

import stuff.Inventory.BaseItemClasses.Gear;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Utilities.*;

public class Player {
    private long maxhp;
    private long hp;
    private long atk;
    private long cash;
    private long level = 100000;
    private long xp;

    private Item headSlot;
    private Item chestSlot;
    private Item leggingsSlot;
    private Item bootsSlot;

    private Item[] inventory = new Item[100];

    private long healthlv;
    private long atklv;
    
    public Player(long maxhp, long atk) {
        this.maxhp = maxhp;
        this.hp = maxhp;
        this.atk = atk;
        this.cash = 0;

        this.healthlv = 1;
        this.atklv = 1;
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

    public long getCash() {
        return cash;
    }

    public void addCash(long amount) {
        cash += amount;
    }

    public void removeCash(long amount) {
        cash -= amount;
    }

    public void resetHealth() {
        hp = maxhp;
    }

    public long getAtkLv() {
        return atklv;
    }

    public long getHealthLv() {
        return healthlv;
    }

    public void addHealthLv(long amount) {
        healthlv += amount;
    }

    public void addAtkLv(long amount) {
        atklv += amount;
    }

    public void changeMaxHealth(long newHp) {
        maxhp = newHp;
    }

    public void changeAtk(long newatk) {
        atk = newatk;
    }

    public long getHp() {
        return hp;
    }

    public long getMaxHp() {
        return maxhp;
    }

    public long getLevel() {
        return level;
    }

    public long getXp() {
        return xp;
    }

    public void scale() {
        maxhp = (long)(100 * ((level * 1.12) * (healthlv * 1.29)));
        atk = (long)(7 * (level * 1.12) * (atklv * 1.29));
        hp = maxhp;
    }

    public void addXp(long amt) {
        xp += amt;

        while (xp >= Math.pow(level, 1.26) + 50) {
            xp -= Math.pow(level, 1.26) + 50;
            level += 1;
        }

        scale();
    }

    public void addtoInventory(Item item) {
        boolean added = false;
        for (Item v : inventory) {
            if (v != null && v.getClass() == item.getClass()) {
                v.addtoStack(item.amount());
                added = true;
                break;
            }
        }

        if (!added) {
            for (int i = 0; i < 100; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    added = true;
                    break;
                }
            }
            if (!added) System.out.println("WARN   | Inventory Full.");
        }
    }

    public void removeFromInventory(Item item, long amt) {
        for (Item v : inventory) {
            if (v != null) {
                if (v.itemName() == null ? item.itemName() == null : v.itemName().equals(item.itemName())) {
                    v.removeStackAmt(amt);
                    if (v.amount() <= 0) {
                        v = null;
                    }
                }
            }
        }
    }

    public Item[] getInventory() {
        return inventory;
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public void equip(Item item, String slot) {
        if (item instanceof Gear) {
            if (null == slot) return; else switch (slot) {
                case "headSlot" -> {
                    headSlot = item;
                    removeFromInventory(item, 1);
                    headSlot.setStackamt(1);
                }
                case "chestSlot" -> {
                    chestSlot = item;
                    removeFromInventory(item, 1);
                    chestSlot.setStackamt(1);
                }
                case "leggingsSlot" -> {
                    leggingsSlot = item;
                    removeFromInventory(item, 1);
                    leggingsSlot.setStackamt(1);
                }
                case "bootsSlot" -> {
                    bootsSlot = item;
                    removeFromInventory(item, 1);
                    bootsSlot.setStackamt(1);
                }
                default -> {
                    return;
                }
            }
        }
    }
}
