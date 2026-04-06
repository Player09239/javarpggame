package stuff.UI;

import java.util.Scanner;

import stuff.Entities.*;
import stuff.Utilities.Util;

public class Level {
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println("*********************************");
        System.out.println(" ");
        System.out.println(":: LEVEL ::");

        System.out.println(" ");
        
        System.out.println("> Level " + plr.getLevel());
        System.out.println("    :: XP   " + plr.getXp() + "/" + (long)(Math.pow(plr.getLevel(), 1.26) + 50) + " ::");

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
