package stuff.UI;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.Utilities.Util;

public class Upgrades {
    public void menu(Scanner input, Player plr) {
        new Util().clearTerminal();

        System.out.println("*********************************");
        System.out.println(" ");
        System.out.println(":: UPGRADES ::");

        System.out.println(" ");

        System.out.println("> Health");
        System.out.println("    | Lv. " + plr.getHealthLv());
        System.out.println("    | $" + ((int) Math.pow(plr.getHealthLv(), 1.1) + 50));

        System.out.println(" ");

        System.out.println("> Attack");
        System.out.println("    | Lv. " + plr.getAtkLv());
        System.out.println("    | $" + ((int) Math.pow(plr.getAtkLv(), 1.1) + 50));

        System.out.println(" ");
        
        System.out.println("> (1) Upgrade Health");
        System.out.println("> (2) Upgrade Attack");
        System.out.println("> (3) Exit");

        System.out.println(" ");
        System.out.println("*********************************");

        int choice = input.nextInt();

        if (choice == 1) {
            upgradeAtk(input, plr);
        } else if (choice == 2) {
            upgradeHealth(input, plr);
        } else if (choice == 3) {
            new Menu().menu(input, plr);
        }
    }

    private void upgradeHealth(Scanner input, Player plr) {
        if (plr.getCash() >= ((int) Math.pow(plr.getHealthLv(), 1.1) + 50)) {
            plr.removeCash(((int) Math.pow(plr.getHealthLv(), 1.1) + 50));
            plr.addHealthLv(1);
            plr.changeMaxHealth(100 + (plr.getHealthLv() * 22));

            menu(input, plr);
        } else {
            System.out.println("*********************************");
            System.out.println(" ");

            System.out.println("Not enough cash");

            System.out.println(" ");

            menu(input, plr);
        }
    }

    private void upgradeAtk(Scanner input, Player plr) {
        if (plr.getCash() >= ((int) Math.pow(plr.getAtkLv(), 1.1) + 50)) {
            plr.removeCash(((int) Math.pow(plr.getAtkLv(), 1.1) + 50));
            plr.addAtkLv(1);
            plr.changeAtk((plr.getAtkLv() * 5) + 7);

            menu(input, plr);
        } else {
            System.out.println("*********************************");
            System.out.println(" ");

            System.out.println("Not enough cash");

            System.out.println(" ");

            menu(input, plr);
        }
    }
}
