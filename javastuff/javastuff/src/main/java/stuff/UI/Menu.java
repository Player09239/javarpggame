package stuff.UI;

import java.util.Scanner;

import stuff.Entities.*;
import stuff.Utilities.Util;

public class Menu {
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println("*********************************");
        System.out.println(" ");
        System.out.println(":: MENU ::");

        System.out.println(" ");
        
        System.out.println("> (1) Check Balance");
        System.out.println("> (2) Battle");
        System.out.println("> (3) Upgrades");
        System.out.println("> (4) Level");

        System.out.println(" ");
        System.out.println("*********************************");

        int choice = input.nextInt();

        if (choice == 1) {
            new Balance().menu(input, plr);
        } else if (choice == 2) {
            new Battle().menu(input, plr);
        } else if (choice == 3) {
            new Upgrades().menu(input, plr);
        } else if (choice == 4) {
            new Level().menu(input, plr);
        }
        
        input.close();
    }
}
