import java.util.Scanner;

public class bossBattle extends Battle{
    public final String GAME_BORDER = "========================";
    public Scanner myScan = new Scanner(System.in);
    public void BossBattle(Player player,Boss boss) {
        System.out.println(GAME_BORDER);
        System.out.println("The DungeonMaster, Professor Wes, is in the Room!");
        System.out.println("'Well " + player.getName() + " you have gotten this far, let's see if you have got what it takes to defeat me!'");
        System.out.println("The Professor looms over the room almost as if looking into a toy house, and you are the toy!");
        System.out.println("There is no running from this battle!");
        actBattleChoices(player, boss);
    }


    public int printBattleChoices(Player player) {
        while (player.getHealth() >= 20) {
            System.out.println(GAME_BORDER);
            System.out.println("What will you do?");
            System.out.println("Hp: " + player.getHealth());
            System.out.println("Gp: " + player.getGold());
            System.out.println("[1] Fight");
            int choice = myScan.nextInt();
            if (choice != 1) {
                System.out.println("This is an invalid choice");
                continue;
            } else {
                return choice;
            }

        }
        while (player.getHealth() <= 20) {
            System.out.println(GAME_BORDER);
            System.out.println("What will you do?");
            System.out.println("Hp: " + player.getHealth());
            System.out.println("Gp: " + player.getGold());
            System.out.println("[1] Fight");
            System.out.println("[2] Special");
            int choice = myScan.nextInt();
            if (choice != 2) {
                System.out.println("This is an invalid choice");
                continue;
            } else {
                return choice;
            }

        }
        return 0;
    }
    public void actBattleChoices(Player player, Monster monster) {
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            int choice = printBattleChoices(player);
            if (choice == 1) {
                if (player.hits()) {
                    player.attack1(monster, player);
                } else {
                    System.out.println("You fail to hit " + monster.getName());
                    monster.attack1(player, monster);
                    continue;
                }
                if (monster.getHealth() <= 0) {
                    System.out.println(monster.getName() + " Collapses! You Survive... Wait what!?");
                    System.out.println("Congratulations, I suppose? Very resilient indeed. Off you go now, you win, that's it.");
                } else {
                    monster.attack1(player, monster);
                }
            } else if (choice == 2) {
                    printEnd(player);
                } else {
                System.out.println("Invalid Input, Suffer Fool!");
                continue;
            }
        }
    }
    public void printEnd(Player player){
        System.out.println("Your body is weak, and you can feel your strength fading,");
        System.out.println("'This looks to be the end " + player.getName() + ", if only you had stayed away, but now you will suffer...'");
        System.out.println("Professor Wes reaches down to end your life, when you begin to feel newfound strength within yourself.");
        System.out.println("The Professor realizes this and tries to crush you but before he can you push back with a massive amount of strength.");
        System.out.println("'NO, IT CANNOT BE!'");
        System.out.println("A flash of light erupts from your hands and suddenly a form appears in your hands.");
        System.out.println("It is the legendary A+, there is nothing the Professor can do to combat your strength and he retreats.");
        System.out.println("'Damn you " + player.getName() + ", I will get you for this!'------------ Silence, all that is left now is the open road, waiting for your next adventure.");
        System.out.println("Thanks for playing.");
        System.exit(0);

    }
}
