package stuff.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import dev.mccue.json.Json;
import stuff.Entities.Player;
import stuff.Utilities.Color;
import stuff.Utilities.Data;
import stuff.Utilities.Util;

public class Menu {
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");
        System.out.println(Color.whitebg(">> ( MENU ) <<"));

        System.out.println(" ");
        
        System.out.println("> (1) Check Balance");
        System.out.println("> (2) Battle");
        System.out.println("> (3) Upgrades");
        System.out.println("> (4) Level");
        System.out.println("> (5) Inventory");
        System.out.println("> (6) Armory");
        System.out.println("> (7) Forge");

        System.out.println(" ");

        System.out.println("> (0) Save and exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                new Balance().menu(input, plr);
                break;
            case 2:
                new Battle().menu(input, plr);
                break;
            case 3:
                new Upgrades().menu(input, plr);
                break;
            case 4:
                new Level().menu(input, plr);
                break;
            case 5:
                new Inventory().menu(input, plr);
                break;
            case 6:
                new Armory().menu(input, plr);
                break;
            case 0:
                new Data().save(plr);
                break;
            case 7:
                new Forge().menu(input, plr);
                break;
            case 8:
                new Data().load(input, plr);
                break;
            default:
                menu(input, plr);
                break;
        }
        
        input.close();
    }
}
