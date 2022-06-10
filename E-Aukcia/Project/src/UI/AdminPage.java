package UI;

import Model.Entity.Item;
import Model.Entity.User;
import Model.ItemList;
import Model.Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Adminpage
 */
public class AdminPage {
    public static ObservableList<String> users = FXCollections.observableArrayList();
    public static ObservableList<String> items = Auction.getLangs();


    public void controlPanel(User user){
        Stage window = new Stage();
        GridPane root = new GridPane();
//        users.addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable observable) {
//                System.out.println("list Invaded");
//            }
//        });

        ChoiceBox<String> oItems = new ChoiceBox<>(items);
        ChoiceBox<String> oUsers = new ChoiceBox<>(users);
        Button delete = new Button("Delete auction");
        VBox vb = new VBox();
//        Item item1 = null;
        vb.getChildren().add(oItems);
        oItems.setOnAction(e-> {
            try {
                vb.getChildren().remove(1);
            }catch (Exception exception){}
            try {
                vb.getChildren().remove(1);
            }catch (Exception exception){}
            GridPane gridPane = new GridPane();
            int indexOfItem = oItems.getSelectionModel().getSelectedIndex();
            Item[] item = ItemList.getItems();

            Text brandL = new Text("Brand: ");
            Text brand = new Text(item[indexOfItem].getBrand());
            Text typeL = new Text("Type: ");
            Text type = new Text(item[indexOfItem].getType());
            Text priceL = new Text("Price: ");

            Text price = new Text(String.valueOf(item[indexOfItem].getPrice()));
            GridPane.setConstraints(brandL,0,0);
            GridPane.setConstraints(brand,1,0);
            GridPane.setConstraints(typeL,0,1);
            GridPane.setConstraints(type,1,1);
            GridPane.setConstraints(priceL,0,2);
            GridPane.setConstraints(price,1,2);
            gridPane.getChildren().addAll(brand,brandL,type,typeL,price,priceL);
            vb.getChildren().addAll(gridPane);
            GridPane.setConstraints(vb,1,0);
            try {
                vb.getChildren().add(delete);
            }catch (Exception exception){

            }
//            root.getChildren().add(vb);

        });


        root.setHgap(100);
        root.setVgap(8);
        root.setPadding(new Insets(50));
        Text balance = new Text(String.valueOf(user.getWalet().getMoney()));
        root.add(balance,0,2);
        VBox vBox = new VBox();

        oUsers.setOnAction(e->{
            try {
                vBox.getChildren().remove(1);
            }catch (Exception exception){}
            try {
                root.getChildren().add(vBox);

            }catch (Exception exception){}
            int choice = oUsers.getSelectionModel().getSelectedIndex();
            GridPane gp = new GridPane();
            Text nameT = new Text("Name: ");
            GridPane.setConstraints(nameT,0,1);
            Text nameI = new Text(users.get(choice));
            GridPane.setConstraints(nameI,1,1);
            Text age = new Text("Age: ");
            GridPane.setConstraints(age,0,2);
            Text ageI = new Text(Login.ids[choice].getAge());
            GridPane.setConstraints(ageI, 1,2);
            Text status = new Text("Status");
            GridPane.setConstraints(status,0,3);
            Text statusI = User.onlineStatus(Login.ids[choice]);
            GridPane.setConstraints(statusI,1,3);
            gp.getChildren().addAll(nameI,nameT,age,ageI,status,statusI);
            vBox.getChildren().add(gp);
            GridPane.setConstraints(vBox,0,0);
         });


        vBox.getChildren().addAll(oUsers);
//        root.getChildren().addAll(vBox,vb);
        root.add(vBox,0,0);
        root.add(vb,1,0);
        Scene scene = new Scene(root,500,300);
        window.setTitle("Admin panel");
        window.setScene(scene);
        window.show();




        delete.setOnAction(e->{
            ItemList.deleteItem(oItems.getSelectionModel().getSelectedIndex());
            items.remove(oItems.getSelectionModel().getSelectedIndex());
            oItems.requestFocus();
            vb.getChildren().remove(1);
            vb.getChildren().remove(1);
        });

    }
}
