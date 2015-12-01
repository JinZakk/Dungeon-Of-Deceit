import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class DungeonGame extends Application implements Game  {
    private Scene scene1;
    private VBox vBoxButtons;
    private Stage window;
    private  MediaPlayer mediaPlayer;
    private Collection<Room> rooms;
    public final String GAME_BORDER = "========================";
    private Scanner myScan;
    public DungeonGame(){
        rooms = new ArrayList<>();
        myScan = new Scanner(System.in);
    }
    private Room initializeRooms(){
            return new Room();

    }
    private void printGameBorder(){
        System.out.println(GAME_BORDER);
    }
    private Player getChosenClass(){
        int classChoose = 0;
        //Have Buttons appear for each class choice---------------------------------------------------------------------------------------
        while(classChoose == 0){

            int classChoice =  myScan.nextInt();
            if (classChoice == 1) {
                return new Warrior();
            } else if (classChoice == 2) {
                return new Thief();
            }else if(classChoice == 3){
               return new Wizard();
            } else {
                System.out.println("not a valid input");
            }

        }
        return null;
    }
    private void printIntroText(){
        System.out.println("You approach an old stone structure, moss covers the large rocks cobbled together with a single wooden door serving as an entrance.");
        System.out.println("You pull the large door open and enter into a dimly lit room. The door slams shut behind you and a voice echoes through the halls.");
        System.out.println("'Welcome to my dungeon, fool! You will never escape! Not without 100 Gold Pieces! '");
        System.out.println("You are trapped inside this stone prison, can you survive the dungeon, or will you perish like those who came before you?");
    }
    public String getHeroName(){
          printGameBorder();
        //Have a query appear to receive name input----------------------------------------------------------------------------------------
    	  System.out.println("What is your name? ");
          String name = myScan.nextLine();
          name = myScan.nextLine();
          return name;
    }
    @Override
    public void start(Stage PrimaryStage)throws Exception{
        window = PrimaryStage;
        playMusic();
        makeButtons();
        makePane();
        window.setTitle("Dungeon of Deceit");
        window.setResizable(false);
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        window.setScene(scene1);
        window.show();

        //Show intro screen-----------------------------------------------------------------------------------------------------------------
        //printIntroScreen()

        //Show Name Selection Screen--------------------------------------------------------------------------------------------------------
        //printHeroNameSelect
        //String name = getHeroName();
        //printGameBorder();



        //Show Character Select Screen------------------------------------------------------------------------------------------------------
        //printClassSelectScreen()



        Player hero = getChosenClass();
        //printGameBorder();
        //hero.setName(name);
        //printIntroText();

        while( hero.getHealth() > 0){
            printGameBorder();
            System.out.println("Hp: " + hero.getHealth());
            System.out.println("Gp: " + hero.getGold());
            //Have the selection as follows:
            //Button[Roam]
            int choice = myScan.nextInt();
            switch(choice){
                case 1:
                    Random r = new Random();
                    int randomEncounter = r.nextInt(5)+1;

                    switch(randomEncounter){
                        case 1:
                            initializeRooms().enter(hero);
                            break;
                        case 2:
                            new Trap(hero);
                            break;
                        case 3:
                            new DeadEnd();
                            break;
                        case 4:
                            initializeRooms().enter(hero);
                            break;
                        case 5:
                            initializeRooms().enter(hero);
                            break;
                    }
                    break;
                case 2:
                    if(hero.getGold() >= 100){
                        System.out.println("You Escape the Dungeon!");
                        System.exit(0);
                    }else{
                        System.out.println("You do not have enough gold to escape!");
                        continue;
                    }
                default:
                    System.out.println("Incorrect input");
                    continue;


            }

            //Button[Pay]
            //Do not choose room, only those two options for now
            //This should create a new room whenever roam is selected




        }
        if(hero.getGold() >= 100 && hero.getHealth() >= 50){
            printGameBorder();
            System.out.println("'You have done well " + hero.getName() + " perhaps too well.");
            System.out.println("Face me now, and face your utter demise!'");
            bossBattle boss = new bossBattle();
            Boss Wes = new Boss();
            boss.BossBattle(hero,Wes);
        }else if(hero.getGold() >= 100){
            printGameBorder();
            System.out.println("Congratulations! You have survived the Algorithm and Implementation II Dungeon!");
            System.out.println("You hear a voice from behind you...");
            System.out.println("'This isn't the last you will see of me... MUAHAHAHAHAHAHA......!'");
            System.out.println("The End?");
            System.exit(0);

        }else if(hero.getHealth() <= 0){
            printGameBorder();
            System.out.println("You have failed your quest...");
            System.out.println("You are trapped in the debugging prison by Prof Wes until your final days.");
            System.out.println("The End, for you.");
            System.exit(0);
        }
    }
    public void makePane(){
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 50, 10));
        pane.setTop(new ImageView("Title.png"));
        pane.setBottom(vBoxButtons);
        pane.setId("mainBackDrop");
        scene1 = new Scene(pane, 500, 450);
        scene1.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

    }
    public void makeButtons(){
        vBoxButtons = new VBox(50);
        vBoxButtons.setAlignment(Pos.BASELINE_CENTER);
        vBoxButtons.setPadding(new Insets(10, 10, 10, 10));
        Button[] buttons = new Button[]{
                new Button("Start Adventure"),
                new Button("Instructions"),
                new Button("Exit")
        };
        for(Button button: buttons){
            button.setMinWidth(250);
            vBoxButtons.getChildren().addAll(button);
        }

        buttons[0].setOnAction(event -> System.out.print("Start"));
        buttons[1].setOnAction(event -> new InstructionsPopUp());
        buttons[2].setOnAction(event -> closeProgram());
    }

    public void playMusic(){
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("Intro.wav").toExternalForm()));
        mediaPlayer.setCycleCount(100);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
    }
    public void play()throws Exception {

    }
    public Room getRoom(int roomNumber){
        int roomCount = 0;

        for(Room current : rooms){
            if(++roomCount == roomNumber){
                return current;
            }
        }

        return null;
    }
    public void closeProgram(){
        boolean result = QuitAlert.display();
        if (result == true)
            System.exit(0);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
