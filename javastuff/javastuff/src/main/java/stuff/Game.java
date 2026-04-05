package stuff;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.UI.Balance;
import stuff.UI.Battle;
import stuff.UI.Upgrades;

public class Game {
    public void start() {
        Scanner input = new Scanner(System.in);

        Player plr = new Player(100, 7);
        plr.changeMaxHealth(78 + (plr.getHealthLv() * 22));
        plr.changeAtk((plr.getAtkLv() * 5) + 2);

        System.out.println("*********************************");
        System.out.println(" ");

        System.out.println(":: MENU ::");

        System.out.println(" ");

        System.out.println("> (1) Check Balance");
        System.out.println("> (2) Battle");
        System.out.println("> (3) Upgrades");

        System.out.println(" ");
        System.out.println("*********************************");

        int choice = input.nextInt();

        if (choice == 1) {
            new Balance().menu(input, plr);
        } else if (choice == 2) {
            new Battle().menu(input, plr);
        } else if (choice == 3) {
            new Upgrades().menu(input, plr);
        }
        input.close();
    }
 
}
