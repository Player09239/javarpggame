package stuff;

import java.util.Scanner;

import stuff.Entities.Player;
import stuff.UI.Menu;
import stuff.Utilities.Color;

public class Game {
    @SuppressWarnings("ConvertToTryWithResources")
    public void start() {
        Scanner input = new Scanner(System.in);

        Player plr = new Player(100, 7);
        plr.changeMaxHealth(78 + (plr.getHealthLv() * 22));
        plr.changeAtk((plr.getAtkLv() * 5) + 2);
        plr.scale();

        System.out.println(Color.whitebg("**************************************************************************************************"));
        System.out.println(" ");

        System.out.println("Welcome to Java RPG, a text-based rpg game made entirely out of Java (ofc). Click 1 to get started.");

        System.out.println(" ");
        System.out.println(Color.whitebg("**************************************************************************************************"));

        long choice = input.nextInt();

        if (choice == 1) {
            new Menu().menu(input, plr);
        }
        input.close();
    }
 
}
