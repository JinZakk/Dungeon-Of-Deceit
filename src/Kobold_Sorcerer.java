
public class Kobold_Sorcerer extends Monster{
    private int magicCharges = 3;
    public final String GAME_BORDER = "========================";
    public Kobold_Sorcerer(){
        super("Kobold Sorcerer", 5, 3);
    }
   public void attack1(Character target,Character attacker){
       Kobold_Sorcerer monster = (Kobold_Sorcerer) attacker;
       if(monster.getMagicCharges() > 0){
               target.setHealth(target.getHealth() - (this.getDamage() + 15));
               System.out.println(this.getName() + " shoots a bolt of magic for " + (this.getDamage() + 15) + " damage!");
               this.magicalCharges();
       }else{
           System.out.println("The Kobold is out of Magic Charges!");
       }
   }

    public void magicalCharges(){
        if(this.magicCharges > 0){
            --this.magicCharges;
        } else{
            System.out.println("The Kobold is out of magic charges!");
        }
    }

    public int getMagicCharges(){
        return this.magicCharges;
    }
}
