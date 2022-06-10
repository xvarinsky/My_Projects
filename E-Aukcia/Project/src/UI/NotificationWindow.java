package UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * opens small window with passed String on it
 * @param title the String to be shown on window
 */
public class NotificationWindow{
    /**
     * opens small window with passed String on it
     * @param title the String to be shown on window
     */
    public static void display(String title){
        Stage window = new Stage();


        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label( title );
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }
}
