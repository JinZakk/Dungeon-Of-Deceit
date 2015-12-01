import java.util.Scanner;
public class Wizard extends Player implements Encounter{

	    private double lootModifier;
        private int magicCharges = 5;
        private final String GAME_BORDER = "========================";

        public Wizard(){
            super("Wizard", 50, 5);
            lootModifier = .8;
        }
        public void onLoot(int gold){
            this.setGold(this.getGold() + gold);
        }
        public boolean hits(){
            //Hit chance is determined by class!
            int hits = chance.nextInt(9);
            if(hits <= 7){
                return true;
            }else{
                return false;
            }
        }
        protected void attack2(Monster target, Player attacker) {
        System.out.println(GAME_BORDER);
        target.setHealth(target.getHealth() - (attacker.getDamage() + 5));
        System.out.println(attacker.getName() + " shoots a bolt of magic for " + (attacker.getDamage() + 5) + " damage!");
        this.magicalCharges();
    }
        public void magicalCharges(){
        if(this.magicCharges > 0){
            --this.magicCharges;
        } else{
            System.out.println(GAME_BORDER);
            System.out.println("You are out of Magic Charges.");
        }
    }
        public double getLootModifier() {return this.lootModifier;}
        public int getMagicCharges(){return this.magicCharges;}
}
