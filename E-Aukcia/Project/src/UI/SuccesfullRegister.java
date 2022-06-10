package UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * open popUp uindow when  registration was succesfull
 */
public class SuccesfullRegister {

    public static void succesfullRegister(){

            Stage window = new Stage();


            window.setTitle("Registration");
            window.setMinWidth(250);

            Label label = new Label("Registration was successful");
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
