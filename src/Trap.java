
public class Trap{
    public Trap(Player player){
        if(player.dodges()){
            System.out.println("You successfully dodge the trap.");
        }else
            System.out.println("You fail to dodge the trap");
            player.setHealth(player.getHealth() - 7);
    }
}
