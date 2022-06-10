package UI;

import Model.*;
import Model.Entity.Item;
import Model.Entity.User;
import Model.AuctionTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 * open curently running auctions
 */
public class Auction {
    public static ObservableList<String>langs = FXCollections.observableArrayList();
    private User user;
    public static ObservableList<String> getLangs() {
        return langs;
    }

    public void auction(User user) {
        AuctionTime auctionController = new AuctionTime();
        auctionController.timerChcek();

        this.user = user;
        Stage window = new Stage();

        langs.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("list Invaded");
            }
        });
        ChoiceBox Brand = new ChoiceBox(FXCollections.observableArrayList("Adidas", "Nike", "Balenciaga", "New Balance", "Fila"));
        Brand.setValue("Filter brand");
        Text balance = new Text("balance" + user.getWalet().getMoney());
        ListView<String> listView = new ListView<String>(langs);
        listView.setPadding(new Insets(10));
        listView.setPrefSize(800, 400);
        Button addBtn = new Button("Add");
//        Button deleteBtn = new Button("Delete");
        Button addMoney = new Button("Add money");
        Image searchImage = new Image("C:/Users/dadvo/Vysoka/2.Semester/OOP/Projekt/images/search.png");
        ImageView imageView = new ImageView(searchImage);
        imageView.setFitHeight(20);
        imageView.setPreserveRatio(true);

        TextField textField = new TextField();
        Button myInventory = new Button("My inventory");
        FlowPane buttonPane = new FlowPane(10, 10, Brand, addBtn, myInventory, addMoney);

        Brand.setOnAction(e -> {
            Item[] chosedItems = ItemList.filterBrands(Brand.getValue().toString());
            listView.setItems(langs);
        });

        addMoney.setOnAction(e -> {
            AddMoney.open(user);
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            auctionController.timerChcek();
            balance.setText("balance" + user.getWalet().getMoney());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        listView.setOnMouseClicked(new ButtonHandler(user));
//
//        {
//            @Override
//            public void handle(MouseEvent click) {
//
//                if (click.getClickCount() == 2) {
//                    //Use ListView's getSelected Item
//                    int currentIndex = listView.getSelectionModel().getSelectedIndex();
//                    System.out.println(currentIndex);
//
//                    Item item = ItemList.getItems(currentIndex);
//                    ShowItem showItem = new ShowItem();
//                    showItem.show(item,user);
////
//                }
//            }
//        }


        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                user.setOnline(false);
                WriteFile.endWriteFile();
            }
        });



        myInventory.setOnAction(e -> {
            showMyInventory show = new showMyInventory();
            show.show(this.user);
        });


        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,balance, buttonPane, listView);

        Scene scene = new Scene(root, 900, 500);

        addBtn.setOnAction(e->{
            AddItem.add();
            System.out.println("h");

        });

        window.setTitle(User.getCurrentlyLogedUser().getName());
        window.setScene(scene);
        window.show();

    }
}


