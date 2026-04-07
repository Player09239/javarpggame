package stuff.UI;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.Inventory.Gear.WoodenBoots;
import stuff.Inventory.Gear.WoodenChestplate;
import stuff.Inventory.Gear.WoodenHelmet;
import stuff.Inventory.Gear.WoodenLeggings;
import stuff.Inventory.Items.Wood;
import stuff.Utilities.*;

public class Forge {
    @SuppressWarnings("static-access")
    public void menu(Scanner input, Player plr) {
        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");
        System.out.println(Color.whitebg(">> ( FORGE ) <<"));

        System.out.println(" ");
        
        System.out.println("> Wooden Set");
        System.out.println("(1) | Helmet: 5 Wood");
        System.out.println("(2) | Chestplate: 8 Wood");
        System.out.println("(3) | Leggings: 7 Wood");
        System.out.println("(4) | Boots: 4 Wood");

        System.out.println(" ");

        System.out.println("> (0) Exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        int choice = input.nextInt();

        switch (choice) {
            case 0 -> {
                new Menu().menu(input, plr);
            }
            case 1 -> {
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
            case 2 -> {
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
            case 3 -> {
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
            case 4 -> {
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
            default -> {
                menu(input, plr);
            }
        }
    }
}
