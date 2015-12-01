import java.util.Random;
import java.util.Scanner;

public class wizardBattle extends Battle{
    private Random random = new Random();
    private Scanner myScan = new Scanner(System.in);
    private final String GAME_BORDER = "========================";
    public int printWizardBattleChoices(Player player, Monster monster){
        	System.out.println("A " + monster.getName() + " is in the room!");
            System.out.println("What will you do?");
            System.out.println("Hp: " + player.getHealth());
            System.out.println("Gp: " + player.getGold());
            System.out.println("[1] Fight");
            System.out.println("[2] Magic " + player.getMagicCharges() + " charges left");
            System.out.println("[3] Run");
            int choice = myScan.nextInt();
            return choice;
    }
    public boolean attackAttempt(Player player,Monster monster){
    	if (player.hits()) {
            player.attack1(monster, player);
             return true;
        } else {
            System.out.println("You fail to hit the " + monster.getName()); 
            return false;
        }
    	
    }
    public void printMonsterDeath(Monster monster){
    	System.out.println("The " + monster.getName() + " Collapses! You survive.");
    }
    public void actWizardBattleChoices(Wizard player, Monster monster) {
    	 while (player.getHealth() > 0 && monster.getHealth() > 0) {
             System.out.println(GAME_BORDER);
             int choice = printWizardBattleChoices(player,monster);
             switch(choice){
             	case 1:
             		if(attackAttempt(player,monster)){
             			if(monster.getHealth() <= 0){
                         	printMonsterDeath(monster);
             				break;
                         }
             			monster.attack1(player, monster);
             			continue;
             		}else{
             			monster.attack1(player, monster);
             			continue;
             		}
             	case 2:
             		if(player.getMagicCharges() > 0){
                        player.attack2(monster, player);
                    }else{
                        System.out.println("You are out of Magical Charges.");
                        continue;
                    } 
             		if (monster.getHealth() <= 0) {
             			printMonsterDeath(monster);
             			continue;
                    } else {
                        monster.attack1(player, monster);
                        continue;
                    }
             		
             	case 3:
             		if (player.run()) {
                        printEscape();
                        break;
                    } else {
                        printFailEscape();
                        monster.attack1(player, monster);
                        continue;
                    }
             	default:
             		System.out.println("Invalid input.");
             }
             break;
         }
    }

}
