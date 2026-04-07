package stuff.UI;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.Inventory.Gear.*;
import stuff.Inventory.Items.*;
import stuff.Utilities.*;

public class Forge {
    @SuppressWarnings("static-access")
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");
        System.out.println(Color.whitebg(">> ( FORGE ) <<"));

        System.out.println(" ");
        
        System.out.println("> Wooden Set");
        System.out.println("> (10) Helmet: 5 Wood   > (11) Chestplate: 8 Wood   > (12) Leggings: 7 Wood   > (13) Boots: 4 Wood");

        System.out.println(" ");

        System.out.println("> Bone Set");
        System.out.println("> (20) Helmet: 5 Bones   > (21) Chestplate: 8 Bones   > (22) Leggings: 7 Bones   > (23) Boots: 4 Bones");

        System.out.println(" ");

        System.out.println("> Spiritual Set");
        System.out.println("> (30) Helmet: 5 Essence   > (31) Chestplate: 8 Essence   > (32) Leggings: 7 Essence   > (33) Boots: 4 Essence");

        System.out.println(" ");

        System.out.println("> Warrior Set");
        System.out.println("> (40) Helmet: 15 Warrior Armor Fragments   > (41) Chestplate: 25 Warrior Armor Fragments");
        System.out.println("> (42) Leggings: 20 Warrior Armor Fragments   > (43) Boots: 12 Warrior Armor Fragments");

        System.out.println(" ");

        System.out.println("> (0) Exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        int choice = input.nextInt();

        switch (choice) {
            case 0 -> {
                new Menu().menu(input, plr);
            }
            case 10 -> {
                if (plr.checkForItemFromInventory("Wood", 5)) {
                    plr.removeFromInventory(new Wood(1), 5);
                    plr.addtoInventory(new WoodenHelmet(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 11 -> {
                if (plr.checkForItemFromInventory("Wood", 8)) {
                    plr.removeFromInventory(new Wood(1), 8);
                    plr.addtoInventory(new WoodenChestplate(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 12 -> {
                if (plr.checkForItemFromInventory("Wood", 7)) {
                    plr.removeFromInventory(new Wood(1), 7);
                    plr.addtoInventory(new WoodenLeggings(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 13 -> {
                if (plr.checkForItemFromInventory("Wood", 4)) {
                    plr.removeFromInventory(new Wood(1), 4);
                    plr.addtoInventory(new WoodenBoots(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 20 -> {
                if (plr.checkForItemFromInventory("Bone", 5)) {
                    plr.removeFromInventory(new Bone(1), 5);
                    plr.addtoInventory(new BoneHelmet(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 21 -> {
                if (plr.checkForItemFromInventory("Bone", 8)) {
                    plr.removeFromInventory(new Bone(1), 8);
                    plr.addtoInventory(new BoneChestplate(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 22 -> {
                if (plr.checkForItemFromInventory("Bone", 7)) {
                    plr.removeFromInventory(new Bone(1), 7);
                    plr.addtoInventory(new BoneLeggings(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 23 -> {
                if (plr.checkForItemFromInventory("Bone", 4)) {
                    plr.removeFromInventory(new Bone(1), 4);
                    plr.addtoInventory(new BoneBoots(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 30 -> {
                if (plr.checkForItemFromInventory("Essence", 5)) {
                    plr.removeFromInventory(new Essence(1), 5);
                    plr.addtoInventory(new SpiritualHelmet(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 31 -> {
                if (plr.checkForItemFromInventory("Essence", 8)) {
                    plr.removeFromInventory(new Essence(1), 8);
                    plr.addtoInventory(new SpiritualChestplate(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 32 -> {
                if (plr.checkForItemFromInventory("Essence", 7)) {
                    plr.removeFromInventory(new Essence(1), 7);
                    plr.addtoInventory(new SpiritualLeggings(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            case 33 -> {
                if (plr.checkForItemFromInventory("Essence", 4)) {
                    plr.removeFromInventory(new Essence(1), 4);
                    plr.addtoInventory(new SpiritualBoots(1));
                    System.out.println("SUCCESS > Item crafted");
                    menu(input, plr);
                } else {
                    System.out.println("FAIL    > Not enough resources");
                    menu(input, plr);
                }
                break;
            }
            default -> {
                menu(input, plr);
            }
        }
    }
}
