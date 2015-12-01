
public abstract class Monster extends Character implements Encounter {

    private int magicCharges;
    protected Monster(String name, int health, int damage) {
        super(name,health,damage);
    }

    public void attack1(Character target,Character attacker){
            target.setHealth(target.getHealth() - attacker.getDamage());
            target.onHit(attacker);
        }

    public void start(Player player){
        //Combat begins here
        Battle combat = new Battle();
        combat.battle(player, this);
    }
    public int getMagicCharges(){
        return this.magicCharges;
    }


}
