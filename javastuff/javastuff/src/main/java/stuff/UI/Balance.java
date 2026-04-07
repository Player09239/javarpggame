package stuff.UI;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.Utilities.Color;
import stuff.Utilities.Util;

public class Balance {
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");

        System.out.println(Color.whitebg(">> ( BALANCE ) <<"));

        System.out.println(" ");

        System.out.println("> Cash");
        System.out.println("    | " + Color.green("$") + plr.getCash());

        System.out.println(" ");

        System.out.println("> (1) Exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        long choice = input.nextInt();

        if (choice == 1) {
            new Menu().menu(input, plr);
        } else menu(input, plr);

        input.close();
    }
}
