package stuff.UI;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.Inventory.BaseItemClasses.Item;
import stuff.Utilities.Util;

public class Inventory {
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        String[] formattedInventory = new String[100];

        for (Item v : plr.getInventory()) {
            for (int i = 0; i < 100; i++) {
                if (v == null) break;
                if (formattedInventory[i] == null) {
                    formattedInventory[i] = v.itemName() + " - x" + v.amount();
                    break;
                }
            }
        }

        

        System.out.println("*********************************");
        System.out.println(" ");
        System.out.println(":: INVENTORY ::");

        System.out.println(" ");
        
        for (String line : formattedInventory) {
            if (line != null) {
                System.out.println(line);
            }
        }


        System.out.println(" ");

        System.out.println("> (1) Exit");

        System.out.println(" ");
        System.out.println("*********************************");

        long choice = input.nextInt();

        if (choice == 1) {
            new Menu().menu(input, plr);
        } else menu(input, plr);
    }
}
