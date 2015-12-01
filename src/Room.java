import java.util.Random;

public class Room {
    private Encounter encounter;
    public Room(){
        randomizeEncounter();
    }
    private void randomizeEncounter(){
        Random r = new Random();
        int randomEncounter = r.nextInt(5)+1;

        switch(randomEncounter){
            case 1:
                encounter = new Gold();
                break;
            case 2:
                encounter = new HealingElixir();
                break;
            case 3:
                encounter = new Goblin();
                break;
            case 4:
                encounter = new Zombie();
                break;
            case 5:
                encounter = new Kobold_Sorcerer();
                break;
        }
    }

    public void enter(Player player){
        encounter.start(player);
        encounter = null;
    }
    public boolean hasVisited(){
        return encounter == null;
    }
}
