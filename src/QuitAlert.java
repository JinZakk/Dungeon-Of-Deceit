import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuitAlert {
    private static Stage window;
    private static Scene scene;
    private static BorderPane borderPane;
    private static HBox hBox;
    private static VBox vBox;
    private static Label label;
    private static Button[] buttons;
    static boolean answer;

    public static boolean display(){
        window = new Stage();

        hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        buttons = new Button[]{
                new Button("Yes"),
                new Button("No")
        };
        for(Button button: buttons){
            button.setMinWidth(90);
            hBox.getChildren().addAll(button);
        }

        buttons[0].setOnAction(event -> {
            answer = true;
            window.close();
        });
        buttons[1].setOnAction(event -> {
            answer = false;
            window.close();
        });

        vBox = new VBox(20);
        label = new Label("Are you sure you want to quit?");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, hBox);

        borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        borderPane.setStyle("-fx-background-color: lightgrey");

        scene = new Scene(borderPane, 300,100);

        window.setTitle("ALERT!");
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
