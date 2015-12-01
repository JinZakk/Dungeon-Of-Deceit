import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InstructionsPopUp {
    private  Stage window;
    private  Scene scene;
    private  VBox vBox;
    private  Button button;
    private  Text text;

    InstructionsPopUp(){
        display();
    }

    private void display(){
        window = new Stage();
        window.setTitle("Instructions");

        vBox = new VBox(50);
        vBox.setAlignment(Pos.CENTER);
        text = new Text();
        text.setFill(Color.WHITE);
        text.setText("Instructions Go here" +
                "\nTEST\n" +
                "\nTO BE FILLED\n" +
                "\nTEST\n" +
                "\nTEST\n"
                );
        button = new Button("Back");
        button.setMinWidth(90);
        vBox.getChildren().addAll(text, button);
        vBox.setId("instructionBackdrop");

        button.setOnAction(event -> window.close());

        scene = new Scene(vBox, 250, 350);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.showAndWait();
    }
}