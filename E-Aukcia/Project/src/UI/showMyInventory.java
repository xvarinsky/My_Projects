package UI;

import Model.Entity.Item;
import Model.Entity.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

/**
 * shows users inventory
 */
public class showMyInventory {
    public void show(User user){
        Stage window = new Stage();
        VBox root = new VBox();
        GridPane gridPane = new GridPane();
        Text name = new Text(user.getName());
        Item[] items = user.getInventory();
        SimpleDateFormat format = new SimpleDateFormat("dd:MM/YYYY  HH:mm");

        for (int i = 0 ; i < user.getInventory().length; i++){
            VBox hBox = new VBox();
            Text brand = new Text(items[i].getBrand());
            Text type = new Text(items[i].getType());
            Text price = new Text(items[i].getPrice()+"€");
            Text size = new Text(items[i].getSize());
            Text time = new Text("bought: "+format.format(items[i].getTime()));
            hBox.getChildren().addAll(brand,type,size,price,time);
            GridPane.setConstraints(hBox,i%3,i/3);
            gridPane.getChildren().add(hBox);
        }
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        root.getChildren().addAll(name,gridPane);
        Scene scene = new Scene(root,600,500);
        window.setScene(scene);
        window.setTitle(user.getName());
        window.show();
    }
}
