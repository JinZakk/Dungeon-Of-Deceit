

public class Gold extends Loot {

    public void start(Player player) {
        int newAmount = random.nextInt(30-10+1)+10;
        newAmount = (int)(player.getLootModifier() * newAmount);

        player.onLoot(newAmount);
        System.out.println("YOU HAVE LOOTED " + newAmount + " GOLD!");
    }

}

