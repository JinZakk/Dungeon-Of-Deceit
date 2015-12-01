
public class Goblin extends Monster{

    public Goblin(){
        super("Goblin", 5, 10);
    }

    public void attack1(Player target,Monster attacker){
        target.setHealth(target.getHealth() - attacker.getDamage());
        target.onHit(attacker);

    }

}
