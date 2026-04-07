package stuff.Utilities;

import stuff.Inventory.Items.*;
import stuff.Inventory.Items.String;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Inventory.Gear.*;

public class ItemCreate {
    public static Item create(java.lang.String name, long amt) {
        if (name == null) return null;
        switch (name) {
            case "Wooden Helmet" -> {
                return new WoodenHelmet(amt);
            }
            case "Wooden Chestplate" -> {
                return new WoodenChestplate(amt);
            }
            case "Wooden Leggings" -> {
                return new WoodenLeggings(amt);
            }
            case "Wooden Boots" -> {
                return new WoodenBoots(amt);
            }
            case "Rotten Flesh" -> {
                return new RottenFlesh(amt);
            }
            case "Bone" -> {
                return new Bone(amt);
            }
            case "String" -> {
                return new String(amt);
            }
            case "Web" -> {
                return new Web(amt);
            }
            case "Wood" -> {
                return new Wood(amt);
            }
            case "Essence" -> {
                return new Essence(amt);
            }
            case "Spirit Core" -> {
                return new SpiritCore(amt);
            }
            case "Bone Helmet" -> {
                return new BoneHelmet(amt);
            }
            case "Bone Chestplate" -> {
                return new BoneChestplate(amt);
            }
            case "Bone Leggings" -> {
                return new BoneLeggings(amt);
            }
            case "Bone Boots" -> {
                return new BoneBoots(amt);
            }
            case "Spiritual Helmet" -> {
                return new SpiritualHelmet(amt);
            }
            case "Spiritual Chestplate" -> {
                return new SpiritualChestplate(amt);
            }
            case "Spiritual Leggings" -> {
                return new SpiritualLeggings(amt);
            }
            case "Spiritual Boots" -> {
                return new SpiritualBoots(amt);
            }
            case "Warrior's Soul" -> {
                return new WarriorSoul(amt);
            }
            case "Warrior Armor Fragment" -> {
                return new WarriorArmorFragment(amt);
            }
            default -> {
                return new Item("Nothing", 0);
            }
        }
    }
}
