
public class Warrior extends Player {
    public void start(Player player){}

    public Warrior(){
        super("Warrior", 100, 10);
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
}
