import java.util.Random;

public class Boss extends Monster{
    public Boss(){
        super("Wes", 50, 20);
    }
    public void onHit(Character attacker) {
    	Random r = new Random();
        int randomAttack = r.nextInt(5)+1;

        switch(randomAttack){
            case 1:
                System.out.println("With a wave of the Professor's hands, giant rectangles appear from above. TEXTBOOKS!");
                break;
            case 2:
            	System.out.println("The Professor uncaps a marker and draws spikes that fall from above!");
                break;
            case 3:
            	System.out.println("The ground bursts from beneath you, Pop quizzes!");
                break;
            case 4:
            	System.out.println("A huge weight pushes onto you, a programming assignment!");
                break;
            case 5:
            	System.out.println("A devastating attack, Finals! What will you do?!");
                break;
        }
        System.out.println(attacker.getName() + " hits for " + attacker.getDamage() + " damage!");

    }

}
