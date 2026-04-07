package stuff.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import dev.mccue.json.Json;
import stuff.Entities.Player;
import stuff.Utilities.Color;
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

        System.out.println(" ");

        System.out.println("> (0) Save and exit");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        long choice = input.nextInt();

        if (choice == 1) {
            new Balance().menu(input, plr);
        } else if (choice == 2) {
            new Battle().menu(input, plr);
        } else if (choice == 3) {
            new Upgrades().menu(input, plr);
        } else if (choice == 4) {
            new Level().menu(input, plr);
        } else if (choice == 5) {
            new Inventory().menu(input, plr);
        } else if (choice == 6) {
            new Armory().menu(input, plr);
        } else if (choice == 0) {
            Json stuff = Json.objectBuilder()
            .put("maxhp", plr.getMaxHp())
            .put("hp", plr.getHp())
            .put("atk", plr.getAtk())
            .put("cash", plr.getCash())
            .put("level", plr.getLevel())
            .put("xp", plr.getXp())
            .put("defense", plr.getDefense())
            .put("realhp", plr.getRealHp())
            .put("healthlv", plr.getHealthLv())
            .put("attacklv", plr.getAtk())
            .put("hpBuff", plr.getHpBuff())
            .put("atkBuff", plr.getAtkBuff())
            .build();

            try {
                Files.writeString(Path.of("data.json"), Json.write(stuff));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else menu(input, plr);
        
        input.close();
    }
}
