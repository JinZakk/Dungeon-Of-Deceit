
public class Thief extends Player{
    private double lootModifier;
    public void start(Player player){}

    public Thief(){
        super("Thief", 50, 5);
        lootModifier = 1.2;
    }
    public void onLoot(int gold){
        this.setGold(this.getGold() + gold);
    }
    public boolean run(){
        int runs = chance.nextInt(10);
        if(runs > 3){
            return true;
        }else{
            return false;
        }
    }
    public boolean hits(){
        //Hit chance is determined by class!
        int hits = chance.nextInt(9);
        if(hits <= 8){
            return true;
        }else{
            return false;
        }
    }
    public boolean dodges(){
        //Dodge chance is determined by class!
        int hits = chance.nextInt(9);
        if(hits <= 8){
            return true;
        }else{
            return false;
        }
    }
    public double getLootModifier() {return this.lootModifier;}
}
