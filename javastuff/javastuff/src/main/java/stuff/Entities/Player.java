package stuff.Entities;

import java.util.Scanner;

import dev.mccue.json.Json;
import dev.mccue.json.JsonArray;
import dev.mccue.json.JsonDecodeException;
import dev.mccue.json.JsonDecoder;
import dev.mccue.json.JsonObject;
import stuff.Inventory.BaseItemClasses.Gear;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.UI.Menu;
import stuff.Utilities.Color;
import stuff.Utilities.ItemCreate;
import stuff.Utilities.Util;

public class Player {
    private long maxhp;
    private long hp;
    private long atk;
    private long cash;
    private long level = 1;
    private long xp;
    private long defense;
    private long realhp;

    private Item headSlot;
    private Item chestSlot;
    private Item leggingsSlot;
    private Item bootsSlot;

    private int hpBuff = 0;
    private int atkBuff = 0;

    private static Item[] inventory = new Item[100];

    private long healthlv;
    private long atklv;
    
    public Player(long maxhp, long atk) {
        this.maxhp = maxhp;
        this.hp = maxhp;
        this.atk = atk;
        this.cash = 0;
        this.realhp = maxhp;

        this.healthlv = 1;
        this.atklv = 1;
    }

    public String colorHp(long max, long realhp) {
        double pct = (double) realhp / max * 100;

        if (pct > 100) {
            return Color.cyan(new Util().abbreviate(realhp));
        } else if (pct > 75) {
            return Color.green(new Util().abbreviate(realhp));
        } else if (pct > 50) {
            return Color.yellow(new Util().abbreviate(realhp));
        } else if (pct > 25) {
            return Color.orange(new Util().abbreviate(realhp));
        } else {
            return Color.red(new Util().abbreviate(realhp));
        }
    }

    public void takeDamage(long dmg) {
        realhp -= dmg;
    }

    public boolean checkIfAlive() {
        return realhp > 0;
    }

    public String displayHealth() {
        return ":: Health   " + colorHp(maxhp, realhp) + "/" + new Util().abbreviate(maxhp) + " ::";
    }

    public long getSolidAtk() {
        return atk;
    }

    private long minmax(double min, double max) {
        return (long) ((long)(Math.random() * (max - min + 1)) + min);
    }

    public long getHpBuff() {
        return hpBuff;
    }

    public long getAtkBuff() {
        return atkBuff;
    }

    public long getAtk() {
        return minmax(atk * 0.9, atk * 1.1);
    }

    public long getCritAtk() {
        return (long) Math.round(minmax(atk * 0.9, atk * 1.1) * 1.5);
    }

    public long getCash() {
        return cash;
    }

    public long getDefense() {
        return defense;
    }

    public void addCash(long amount) {
        cash += amount;
    }

    public long getRealHp() {
        return realhp;
    }

    public void removeCash(long amount) {
        cash -= amount;
    }

    public void resetHealth() {
        hp = maxhp;
        realhp = hp + defense;
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
        return realhp;
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
        maxhp = (long)(100 * ((level * 1.06) * (healthlv * 1.13)));
        atk = (long)(7 * (level * 1.06) * (atklv * 1.13));
        hp = maxhp;

        int atkBuff = 0;
        long newDefense = 0;

        if (headSlot != null) {
            atkBuff += headSlot.getAtkBuff();
            newDefense += headSlot.getHpBuff();
        }
        if (chestSlot != null) {
            atkBuff += chestSlot.getAtkBuff();
            newDefense += chestSlot.getHpBuff();
        }
        if (leggingsSlot != null) {
            atkBuff += leggingsSlot.getAtkBuff();
            newDefense += leggingsSlot.getHpBuff();
        }
        if (bootsSlot != null) {
            atkBuff += bootsSlot.getAtkBuff();
            newDefense += bootsSlot.getHpBuff();
        }

        atk += atkBuff;
        defense = newDefense;

        realhp = maxhp + defense;
    }

    public void addXp(long amt) {
        xp += amt;

        while (xp >= Math.pow(level, 1.26) + 50) {
            xp -= Math.pow(level, 1.26) + 50;
            level += 1;
        }

        scale();
    }

    public static void addtoInventory(Item item) {
        boolean added = false;
        for (Item v : inventory) {
            if (v != null && v.getClass() == item.getClass()) {
                v.addtoStack(item.amount());
                added = true;
                System.out.println("DEBUG   > " + item.itemName() + " stacked in inventory");
                break;
            }
        }

        if (!added) {
            for (int i = 0; i < 100; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    added = true;
                    System.out.println("DEBUG   > " + item.itemName() + " added to inventory");
                    break;
                }
            }
            if (!added) System.out.println("WARN   | Inventory Full.");
        }
    }

    public void removeFromInventory(Item item, long amt) {
        for (int i = 0; i < inventory.length; i++) {
            Item v = inventory[i];
            if (v != null && (v.itemName() == null ? item.itemName() == null : v.itemName().equals(item.itemName()))) {
                v.removeStackAmt(amt);
                if (v.amount() <= 0) {
                    inventory[i] = null;
                }
                break;
            }
        }
    }

    public boolean checkForItemFromInventory(String name, long amt) {
        boolean exists = false;

        for (Item v : getInventory()) {
            if (v != null) {
                if (v.itemName() == name) {
                    if (v.amount() >= amt) {
                        exists = true;
                        break;
                    }
                }
            }
        }

        return exists;
    }

    public boolean checkIfPlayerIsAliveAndHealthIsNotNegativeAndIsFightingLevel703ZombieWhilstWearingWoodenChestplateAndIsLevel28() {
        return true;
    }

    public Item[] getInventory() {
        return inventory;
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public void equip(Item item, String slot) {
        if (item instanceof Gear) {
            if (slot == null) return; else switch (slot) {
                case "headSlot" -> {
                    if (headSlot != null) {
                        addtoInventory(headSlot);
                    }
                    headSlot = item;
                    removeFromInventory(item, 1);
                    headSlot.setStackamt(1);
                }
                case "chestSlot" -> {
                    if (chestSlot != null) {
                        addtoInventory(chestSlot);
                    }
                    chestSlot = item;
                    removeFromInventory(item, 1);
                    chestSlot.setStackamt(1);
                }
                case "leggingsSlot" -> {
                    if (leggingsSlot != null) {
                        addtoInventory(leggingsSlot);
                    }
                    leggingsSlot = item;
                    removeFromInventory(item, 1);
                    leggingsSlot.setStackamt(1);
                }
                case "bootsSlot" -> {
                    if (bootsSlot != null) {
                        addtoInventory(bootsSlot);
                    }
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

    @SuppressWarnings("UnnecessaryReturnStatement")
    public void unequip(Item item, String slot) {
        if (item instanceof Gear) {
            if (slot == null) return; else switch (slot) {
                case "headSlot" -> {
                    if (headSlot != null) {
                        addtoInventory(headSlot);
                        headSlot = null;
                    }
                }
                case "chestSlot" -> {
                    if (chestSlot != null) {
                        addtoInventory(chestSlot);
                        chestSlot = null;
                    }
                }
                case "leggingsSlot" -> {
                    if (leggingsSlot != null) {
                        addtoInventory(leggingsSlot);
                        leggingsSlot = null;
                    }
                }
                case "bootsSlot" -> {
                    if (bootsSlot != null) {
                        addtoInventory(bootsSlot);
                        bootsSlot = null;
                    }
                }
                default -> {
                    return;
                }
            }
        }
    }

    public Item getHeadSlot() {
        return headSlot;
    }

    public Item getChestSlot() {
        return chestSlot;
    }

    public Item getLeggingsSlot() {
        return leggingsSlot;
    }

    public Item getBootsSlot() {
        return bootsSlot;
    }

    public void loadPlayer(Json json, Scanner input) {
        record i() {
            static Item fromJson(Json json) {
                return ItemCreate.create(
                    JsonDecoder.field(json, "itemName", JsonDecoder::string),
                    JsonDecoder.field(json, "amount", JsonDecoder::long_)
                );
            }
        }

        record inv() {
            static void fromJson(Json json) {
                JsonObject invObj = JsonDecoder.field(json, "inventory", JsonDecoder::object);
                JsonArray invArr = JsonDecoder.field(invObj, "inventory", JsonDecoder::array);

                Item[] inventory = new Item[100];

                for (Json v : invArr) {
                    String name = JsonDecoder.field(v, "itemName", JsonDecoder::string);
                    long amt = JsonDecoder.field(v, "amount", JsonDecoder::long_);

                    Item item = ItemCreate.create(name, amt);
                    addtoInventory(item);
                }
            }
        }

        

        maxhp = JsonDecoder.field(json, "maxhp", JsonDecoder::long_);
        hp = JsonDecoder.field(json, "hp", JsonDecoder::long_);
        atk = JsonDecoder.field(json, "atk", JsonDecoder::long_);
        cash = JsonDecoder.field(json, "cash", JsonDecoder::long_);
        level = JsonDecoder.field(json, "level", JsonDecoder::long_);
        xp = JsonDecoder.field(json, "xp", JsonDecoder::long_);
        defense = JsonDecoder.field(json, "defense", JsonDecoder::long_);
        realhp = JsonDecoder.field(json, "realhp", JsonDecoder::long_);

        try {
            headSlot = JsonDecoder.optionalField(json, "headSlot", i::fromJson).orElse(null);
        } catch (JsonDecodeException e) {
            headSlot = null;
        }

        try {
            chestSlot = JsonDecoder.optionalField(json, "chestSlot", i::fromJson).orElse(null);
        } catch (JsonDecodeException e) {
            chestSlot = null;
        }

        try {
            leggingsSlot = JsonDecoder.optionalField(json, "leggingsSlot", i::fromJson).orElse(null);
        } catch (JsonDecodeException e) {
            leggingsSlot = null;
        }

        try {
            bootsSlot = JsonDecoder.optionalField(json, "bootsSlot", i::fromJson).orElse(null);
        } catch (JsonDecodeException e) {
            bootsSlot = null;
        }

        hpBuff = JsonDecoder.field(json, "hpBuff", JsonDecoder::int_);
        atkBuff = JsonDecoder.field(json, "atkBuff", JsonDecoder::int_);

        inv.fromJson(json);

        healthlv = JsonDecoder.field(json, "healthlv", JsonDecoder::long_);
        atklv = JsonDecoder.field(json, "attacklv", JsonDecoder::long_);

        new Menu().menu(input, this);
    }
}
