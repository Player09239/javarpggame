package stuff.UI;

import java.util.Scanner;

import stuff.Entities.*;
import stuff.Entities.Bosses.FallenWarrior;
import stuff.Entities.Mobs.*;
import stuff.Utilities.*;

public class Battle {
    public void menu(Scanner input, Player plr) {
        System.out.println("*********************************");
        System.out.println(" ");
        System.out.println(":: BATTLE ::");

        System.out.println(" ");
        
        System.out.println("> (1) Zombie");
        System.out.println("> (2) Skeleton");
        System.out.println("> (3) Spider");
        System.out.println("> (4) Spirit");

        System.out.println(" ");

        System.out.println("> (10) [BOSS] Fallen Warrior");

        System.out.println(" ");

        System.out.println("> (5) Exit");

        System.out.println(" ");
        System.out.println("*********************************");

        int choice = input.nextInt();

        if (choice == 1) {
            battle(input, plr, new Zombie(90, 6, 10, 30));
        } else if (choice == 2) {
            battle(input, plr, new Skeleton(125, 9, 20, 55));
        } else if (choice == 3) {
            battle(input, plr, new Spider(110, 15, 35, 80));
        } else if (choice == 4) {
            battle(input, plr, new Spirit(170, 14, 57, 118));
        } else if (choice == 5) {
            new Menu().menu(input, plr);
        } else if (choice == 10) {
            battle(input, plr, new FallenWarrior(1750, 82, 450, 1250));
        }
    }

    private void battle(Scanner input, Player plr, Enemy enemy) {
        new Util().clearTerminal();
        // enemy.setLevel(921373);
        enemy.scale();

        plr.resetHealth();

        String skill = "No skills";

        System.out.println("*********************************");
        System.out.println(" ");
        System.out.println(":: BATTLE ::");
        System.out.println("A wild enemy appeared..");

        System.out.println(" ");

        System.out.println("> Player");
        System.out.println("    " + plr.displayHealth());
        System.out.println("    " + new Util().bar(plr.getHp(), plr.getMaxHp()));

        System.out.println(" ");

        System.out.println("> [Lv." + enemy.getLevel() + "] " + enemy.getName());
        System.out.println("    " + enemy.displayHealth());
        System.out.println("    " + new Util().bar(enemy.getHp(), enemy.getMaxHp()));
        if (enemy instanceof FallenWarrior) skill = ((FallenWarrior) enemy).getTornadoSkill();
        System.out.println("       " + skill);

        System.out.println(" ");

        System.out.println("> (1) Attack");
        System.out.println("> (2) Flee");

        System.out.println(" ");
        System.out.println("*********************************");

        int choice = input.nextInt();
        
        if (choice == 1) {
            attack(input, plr, enemy);
        } else if (choice == 2) {
            System.out.println("*********************************");
            System.out.println(" ");

            System.out.println("You fled the battle.");

            System.out.println(" ");

            new Menu().menu(input, plr);
        }
    }

    private void attack(Scanner input, Player plr, Enemy enemy) {
        int enemyDamage = enemy.getAtk();
        String enemyAction = "| " + enemy.getName() + " deals " + enemyDamage + " damage to Player";
        
        if (enemy instanceof FallenWarrior) {
            enemyDamage = ((FallenWarrior) enemy).tornadoSkill();
            if (enemyDamage > enemy.getAtk()) {
                enemyAction = "| " + enemy.getName() + " uses TORNADO and deals " + enemyDamage + " damage to Player";
            }
        }
        
        plr.takeDamage(enemyDamage);
        enemy.takeDamage(plr.getAtk());

        String skill = "No skills";

        new Util().clearTerminal();

        if (plr.checkIfAlive() && enemy.checkIfAlive()) {
            System.out.println("*********************************");
            System.out.println(" ");
            System.out.println(":: BATTLE ::");

            System.out.println(" ");

            System.out.println("| Player deals " + plr.getAtk() + " damage to " + enemy.getName());
            System.out.println(enemyAction);

            System.out.println(" ");

            System.out.println("> Player");
            System.out.println("    " + plr.displayHealth());
            System.out.println("    " + new Util().bar(plr.getHp(), plr.getMaxHp()));

            System.out.println(" ");
            
            System.out.println("> [Lv." + enemy.getLevel() + "] " + enemy.getName());
            System.out.println("    " + enemy.displayHealth());
            System.out.println("    " + new Util().bar(enemy.getHp(), enemy.getMaxHp()));
            if (enemy instanceof FallenWarrior) skill = ((FallenWarrior) enemy).getTornadoSkill();
            System.out.println("       " + skill);

            System.out.println(" ");

            System.out.println("> (1) Attack");
            System.out.println("> (2) Flee");

            System.out.println(" ");
            System.out.println("*********************************");

            int choice = input.nextInt();

            if (choice == 1) {
                attack(input, plr, enemy);
            } else if (choice == 2) {
                System.out.println("*********************************");
                System.out.println(" ");

                System.out.println("You fled the battle.");

                System.out.println(" ");

                new Menu().menu(input, plr);
            }
        } else if (!plr.checkIfAlive()) {
            System.out.println("*********************************");
            System.out.println(" ");
            System.out.println(":: BATTLE ::");

            System.out.println(" ");

            System.out.println("DEFEAT. Click 1 to exit");

            System.out.println(" ");

            System.out.println("| Player deals " + plr.getAtk() + " damage to " + enemy.getName());
            System.out.println("| " + enemy.getName() + " deals " + enemy.getAtk() + " damage to Player");
            System.out.println("| Player dies");

            System.out.println(" ");

            System.out.println("> [DEAD] Player");
            System.out.println("    " + plr.displayHealth());
            System.out.println("    " + new Util().bar(plr.getHp(), plr.getMaxHp()));

            System.out.println(" ");

            System.out.println("> [Lv." + enemy.getLevel() + "] " + enemy.getName());
            System.out.println("    " + enemy.displayHealth());
            System.out.println("    " + new Util().bar(enemy.getHp(), enemy.getMaxHp()));
            if (enemy instanceof FallenWarrior) skill = ((FallenWarrior) enemy).getTornadoSkill();
            System.out.println("       " + skill);

            System.out.println(" ");

            System.out.println("> (1) Exit");

            System.out.println(" ");
            System.out.println("*********************************");

            int choice = input.nextInt();

            if (choice == 1) {
                new Menu().menu(input, plr);
            }
        } else if (!enemy.checkIfAlive()) {
            int cashreward = enemy.rewardCash();
            plr.addCash(cashreward);
            int xpreward = (int)((enemy.getLevel() * 1.5) + (enemy.getAtk() * 1.3));
            plr.addXp(xpreward);

            System.out.println("*********************************");
            System.out.println(" ");
            System.out.println(":: BATTLE ::");

            System.out.println(" ");

            System.out.println("VICTORY. Click 1 to exit");
            System.out.println("Reward: $" + cashreward + ", " + xpreward + " XP");

            System.out.println(" ");

            System.out.println("| Player deals " + plr.getAtk() + " damage to " + enemy.getName());
            System.out.println("| " + enemy.getName() + " dies");

            System.out.println(" ");

            System.out.println("> Player");
            System.out.println("    " + plr.displayHealth());
            System.out.println("    " + new Util().bar(plr.getHp(), plr.getMaxHp()));

            System.out.println(" ");

            System.out.println("> [DEAD] [Lv." + enemy.getLevel() + "] " + enemy.getName());
            System.out.println("    " + enemy.displayHealth());
            System.out.println("    " + new Util().bar(enemy.getHp(), enemy.getMaxHp()));
            if (enemy instanceof FallenWarrior) skill = ((FallenWarrior) enemy).getTornadoSkill();
            System.out.println("       " + skill);

            System.out.println(" ");

            System.out.println("> (1) Exit");

            System.out.println(" ");
            System.out.println("*********************************");

            int choice = input.nextInt();

            if (choice == 1) {
                new Menu().menu(input, plr);
            }
        }

    }
}
