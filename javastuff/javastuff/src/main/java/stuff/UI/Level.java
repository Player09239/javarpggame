package stuff.UI;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.Utilities.Color;
import stuff.Utilities.Util;

public class Level {
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");
        System.out.println(Color.whitebg(">> ( LEVEL ) <<"));

        System.out.println(" ");
        
        System.out.println("> Level " + plr.getLevel());
        System.out.println("    :: XP   " + plr.getXp() + "/" + (long)(Math.pow(plr.getLevel(), 1.26) + 50) + " ::");

        System.out.println(" ");

        System.out.println("> (1) Exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        long choice = input.nextInt();

        if (choice == 1) {
            new Menu().menu(input, plr);
        } else menu(input, plr);
    }
}
