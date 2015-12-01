import java.util.Random;
public abstract class Player extends Character implements Encounter{
    public void start(Player player){}
    public void battle(Player player, Monster monster){}
    protected Random chance = new Random();
    private int gold;
    private int magicCharges ;
    private double lootModifier = 1.0;
    protected Player(String name, int health, int damage) {
        super(name,health,damage);
    }
    public void attack1(Monster target){
        target.setHealth(target.getHealth() - target.getDamage());
    }
    protected void attack2(Monster target, Player attacker) {
        target.setHealth(target.getHealth() - attacker.getDamage());
        target.onHit(attacker);
    }
    public void onHeal(int health){
        this.setHealth(health + this.getHealth());
    }
    public void onLoot(int gold){
        this.gold+=gold;
    }
    public boolean run(){
        //Run chance is determined by class!
        int runs = chance.nextInt(10);
        if(runs > 6){
            return true;
        }else{
            return false;
        }
    }
    public boolean hits(){
        //Hit chance is determined by class!
        int hits = chance.nextInt(9);
        if(hits <= 6){
            return true;
        }else{
            return false;
        }
    }
    public boolean dodges(){
        //dodge chance is determined by class!
        int hits = chance.nextInt(9);
        if(hits <= 8){
            return true;
        }else{
            return false;
        }
    }
    public int getGold(){
        return this.gold;
    }
    public void setGold(int gold){
        this.gold = gold;
    }
    public double getLootModifier() {return this.lootModifier;}
    public int getMagicCharges(){return this.magicCharges;}
}
