import java.util.Random;
import java.util.Scanner;

public class Battle{

        private Random random = new Random();
        private Scanner myScan = new Scanner(System.in);
        private final String GAME_BORDER = "========================";
        public void battle(Player player, Monster monster){
            if(player instanceof Wizard){
                Wizard wiz = (Wizard) player;
                wizardBattle y1 = new wizardBattle();
                y1.actWizardBattleChoices(wiz, monster);
            }else{
               
                actBattleChoices(player,monster);
            }
        }
        public void printEscape(){
            int result = random.nextInt(9);
            switch(result){
                case 0:
                    System.out.println("You barely escape with your health.");
                    break;
                case 1:
                    System.out.println("You escape.");
                    break;
                case 2:
                    System.out.println("You slip away from the creature.");
                    break;
                case 3:
                    System.out.println("You run away, coward.");
                    break;
                case 4:
                    System.out.println("You run for your life, and succeed.");
                    break;
                case 5:
                    System.out.println("You escape the enemies clutches.");
                    break;
                case 6:
                    System.out.println("You run away.");
                    break;
                case 7:
                    System.out.println("You've managed to escape, how lucky.");
                    break;
                case 8:
                    System.out.println("You dodge the enemy and escape the encounter");
                    break;
                case 9:
                    System.out.println("You must be slippery! You escape.");
                    break;
            }

        }
        public void printFailEscape(){
            int result = random.nextInt(9);
            switch(result){
                case 0:
                    System.out.println("You fail to escape.");
                    break;
                case 1:
                    System.out.println("You do not manage to run away.");
                    break;
                case 2:
                    System.out.println("You are not as agile as you think, you do not escape.");
                    break;
                case 3:
                    System.out.println("You tried to run, but you failed.");
                    break;
                case 4:
                    System.out.println("Running this turn was useless.");
                    break;
                case 5:
                    System.out.println("The creature is too quick for you, you fail to run.");
                    break;
                case 6:
                    System.out.println("There is no escape now.");
                    break;
                case 7:
                    System.out.println("You slip in your attempt to escape, how sad.");
                    break;
                case 8:
                    System.out.println("Now you are a coward and a failure, you do not escape.");
                    break;
                case 9:
                    System.out.println("You do not escape.");
                    break;

            }
        }
        public int printBattleChoices(Player player, Monster monster){
        	System.out.println("A " + monster.getName() + " is in the room!");
            System.out.println("What will you do?");
            System.out.println("Hp: " + player.getHealth());
            System.out.println("Gp: " + player.getGold());
            System.out.println("[1] Fight");
            System.out.println("[2] Run");
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
        public void actBattleChoices(Player player, Monster monster) {
        
            while (player.getHealth() > 0 && monster.getHealth() > 0) {
                System.out.println(GAME_BORDER);
                int choice = printBattleChoices(player,monster);
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
                        continue;
                }
                break;
              
            }
        }

    }


