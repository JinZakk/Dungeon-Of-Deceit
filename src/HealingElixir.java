

public class HealingElixir extends Loot {

    public void start(Player player){
        this.amount = random.nextInt(20-10+1)+10;
        System.out.println("YOU HAVE BEEN HEALED FOR " + this.amount + "Hp!");
        player.onHeal(this.amount);
    }

}
