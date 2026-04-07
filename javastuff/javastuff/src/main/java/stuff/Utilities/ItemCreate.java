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
            default -> {
                return new Item("Nothing", 0);
            }
        }
    }
}
