package stuff.UI;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.Inventory.BaseItemClasses.Boots;
import stuff.Inventory.BaseItemClasses.Chestplate;
import stuff.Inventory.BaseItemClasses.Gear;
import stuff.Inventory.BaseItemClasses.Helmet;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Inventory.BaseItemClasses.Leggings;
import stuff.Utilities.Color;
import stuff.Utilities.Util;

public class Armory {
    
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        String head = plr.getHeadSlot() != null ? plr.getHeadSlot().itemName() : null;
        String chest = plr.getChestSlot() != null ? plr.getChestSlot().itemName() : null;
        String leggings = plr.getLeggingsSlot() != null ? plr.getLeggingsSlot().itemName() : null;
        String boots = plr.getBootsSlot() != null ? plr.getBootsSlot().itemName() : null;

        if (head == null) head = "None";
        if (chest == null) chest = "None";
        if (leggings == null) leggings = "None";
        if (boots == null) boots = "None";

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");

        System.out.println(Color.whitebg(">> ( ARMORY ) <<"));

        System.out.println(" ");

        System.out.println("> Gear");
        System.out.println("    | Head: " + head + "  (HP: +" + (plr.getHeadSlot() != null ? plr.getHeadSlot().getHpBuff() : 0) + ")" + " (Atk: +" + (plr.getHeadSlot() != null ? plr.getHeadSlot().getAtkBuff() : 0) + ")");
        System.out.println("    | Chest: " + chest + "  (HP: +" + (plr.getChestSlot() != null ? plr.getChestSlot().getHpBuff() : 0) + ")" + " (Atk: +" + (plr.getChestSlot() != null ? plr.getChestSlot().getAtkBuff() : 0) + ")");
        System.out.println("    | Leggings: " + leggings + "  (HP: +" + (plr.getLeggingsSlot() != null ? plr.getLeggingsSlot().getHpBuff() : 0) + ")" + " (Atk: +" + (plr.getLeggingsSlot() != null ? plr.getLeggingsSlot().getAtkBuff() : 0) + ")");
        System.out.println("    | Boots: " + boots + "  (HP: +" + (plr.getBootsSlot() != null ? plr.getBootsSlot().getHpBuff() : 0) + ")" + " (Atk: +" + (plr.getBootsSlot() != null ? plr.getBootsSlot().getAtkBuff() : 0) + ")");

        System.out.println(" ");

        System.out.println("> Unused Gear");
        for (Item v : plr.getInventory()) {
            if (v instanceof Gear) {
                System.out.println("    " + v.itemName() + " - x" + v.amount());
            }
        }

        System.out.println(" ");
 
        System.out.println("> (1) Equipping Section");
        System.out.println("> (2) Unequipping Section");
        System.out.println("> (3) Exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        int choice = input.nextInt();

        if (choice == 1) {
            equippingsection(input, plr);
        } else if (choice == 2) {
            unequippingsection(input, plr);
        } else if (choice == 3) {
            new Menu().menu(input, plr);
        } else menu(input, plr);
    }

    private void equippingsection(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");

        System.out.println(Color.whitebg(">> ( ARMORY.EQUIPPING_SECTION ) <<"));

        System.out.println(" ");

        System.out.println("> Unused Gear");
        for (Item v : plr.getInventory()) {
            if (v instanceof Gear) {
                System.out.println("    " + v.itemName() + " - x" + v.amount());
            }
        }

        System.out.println(" ");

        System.out.println("Type the name of the item you want to equip.");

        System.out.println(" ");
 
        System.out.println("> (1) Armory");
        System.out.println("> (2) Exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        String response = input.nextLine();

        Integer choice = null;

        try {
            choice = Integer.parseInt(response);
        } catch (NumberFormatException e) {}

        System.out.println(choice); // temp

        if (choice == null) {
            boolean equipped = false;
            for (Item v : plr.getInventory()) {
                if (v instanceof Gear) {
                    if (v.itemName().equals(response)) {
                        if (v instanceof Helmet) {
                            plr.equip(v, "headSlot");
                            equipped = true;
                            break;
                        } else if (v instanceof Chestplate) {
                            plr.equip(v, "chestSlot");
                            equipped = true;
                            break;
                        } else if (v instanceof Leggings) {
                            plr.equip(v, "leggingsSlot");
                            equipped = true;
                            break;
                        } else if (v instanceof Boots) {
                            plr.equip(v, "bootsSlot");
                            equipped = true;
                            break;
                        }
                    }
                }
            }
            if (!equipped) {
                System.out.println("Invaild Item. (Either you don't have it or it doesnt exist)");
                equippingsection(input, plr);
            }
            if (equipped) {
                plr.scale();
                menu(input, plr);
            }
        } else {
            if (choice == 1) {
                menu(input, plr);
            } else if (choice == 2) {
                new Menu().menu(input, plr);
            } else equippingsection(input, plr);
        }
    }

    private void unequippingsection(Scanner input, Player plr) {
        new Util().clearTerminal();

        String head = plr.getHeadSlot() != null ? plr.getHeadSlot().itemName() : null;
        String chest = plr.getChestSlot() != null ? plr.getChestSlot().itemName() : null;
        String leggings = plr.getLeggingsSlot() != null ? plr.getLeggingsSlot().itemName() : null;
        String boots = plr.getBootsSlot() != null ? plr.getBootsSlot().itemName() : null;

        if (head == null) head = "None";
        if (chest == null) chest = "None";
        if (leggings == null) leggings = "None";
        if (boots == null) boots = "None";

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");

        System.out.println(Color.whitebg(">> ( ARMORY.UNEQUIPPING_SECTION ) <<"));

        System.out.println(" ");

        System.out.println("> Gear");
        System.out.println("    | Head: " + head);
        System.out.println("    | Chest: " + chest);
        System.out.println("    | Leggings: " + leggings);
        System.out.println("    | Boots: " + boots);

        System.out.println(" ");

        System.out.println("Type the name of the item you want to unequip.");

        System.out.println(" ");
 
        System.out.println("> (1) Armory");
        System.out.println("> (2) Exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        String response = input.nextLine();

        Integer choice = null;

        try {
            choice = Integer.parseInt(response);
        } catch (NumberFormatException e) {}

        System.out.println(choice); // temp

        if (choice == null) {
            boolean unequipped = false;
            if (head.equals(response) && !head.equals("None")) {
                plr.unequip(plr.getHeadSlot(), "headSlot");
                unequipped = true;
            } else if (chest.equals(response) && !chest.equals("None")) {
                plr.unequip(plr.getChestSlot(), "chestSlot");
                unequipped = true;
            } else if (leggings.equals(response) && !leggings.equals("None")) {
                plr.unequip(plr.getLeggingsSlot(), "leggingsSlot");
                unequipped = true;
            } else if (boots.equals(response) && !boots.equals("None")) {
                plr.unequip(plr.getBootsSlot(), "bootsSlot");
                unequipped = true;
            }
            if (!unequipped) {
                System.out.println("Invalid Item. (Either you don't have it equipped or it doesn't exist)");
                unequippingsection(input, plr);
            }
            if (unequipped) {
                plr.scale();
                menu(input, plr);
            }
        } else {
            if (choice == 1) {
                menu(input, plr);
            } else if (choice == 2) {
                new Menu().menu(input, plr);
            } else unequippingsection(input, plr);
        }
    }
}