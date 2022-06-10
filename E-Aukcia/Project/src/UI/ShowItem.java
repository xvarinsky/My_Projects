package UI;

import Model.Entity.Item;

import Model.Entity.User;
import Model.ItemList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;


import java.text.SimpleDateFormat;

import static java.lang.Integer.parseInt;

/**
 * Shows auction which was clicked to see full description of the item
 */

public class ShowItem{

//    public ShowItem(Item item){
//        this.item = item;
//        this.item.attach(this);
//
//    }

    /**
     * Shows auction which was clicked to see full description of the item
     * @param item item which user wants to see
     * @param user User which wants to see the auction
     */

    public void show(Item item, User user){
        Stage window = new Stage();

        ImageView imageView = new ImageView();
        imageView.setImage(item.image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
//        Group root = new Group(imageView);

        Text brand = new Text("Brand: ");
        Text type = new Text("Type: ");
        Text size = new Text("Size: ");
        Text price = new Text("Price: ");
        Text highestBiderName = new Text("Biggest bid: ");

        brand.setFont(Font.font(30));
        type.setFont(Font.font(30));
        size.setFont(Font.font(30));
        price.setFont(Font.font(30));
        highestBiderName.setFont(Font.font(30));


        Text brandInfo = new Text(item.getBrand());
        Text typeInfo = new Text(item.getType());
        Text sizeInfo = new Text(item.getSize());
        Text priceInfo = new Text();
        Text highestBid = new Text(item.getOwner().getName());
//        priceInfo.textProperty().bind(item.sPrice);
        brandInfo.setFont(Font.font(30));
        typeInfo.setFont(Font.font(30));
        sizeInfo.setFont(Font.font(30));
        priceInfo.setFont(Font.font(30));
        highestBid.setFont(Font.font(30));

        HBox hBrand = new HBox(brand,brandInfo);
        hBrand.setAlignment(Pos.CENTER);
        HBox hBidder = new HBox(highestBiderName,highestBid);
        hBidder.setAlignment(Pos.CENTER);
        HBox hType= new HBox(type,typeInfo);
        hType.setAlignment(Pos.CENTER);
        HBox hSize = new HBox(size, sizeInfo);
        hSize.setAlignment(Pos.CENTER);
        HBox hPrice = new HBox(price,priceInfo);
        hPrice.setAlignment(Pos.CENTER);
        Text yourBet = new Text("Your bet: ");
        yourBet.setFont(Font.font(30));
        TextField yourBetField = new TextField();
        yourBetField.setPromptText(">"+ item.getPrice());
        HBox bets = new HBox(yourBet,yourBetField);
        bets.setAlignment(Pos.CENTER);

        SimpleDateFormat format = new SimpleDateFormat("dd:HH:mm:ss");
        Text timeRemaining = new Text("Time remaining:");
        Text time = new Text(format.format(item.getTime()));

        Text ballanceText = new Text("Your balance: ");
        Text ballance = new Text(String.valueOf(user.getWalet().getMoney()));
        VBox vTimer = new VBox(timeRemaining,time,ballanceText,ballance);
        Button bet = new Button("Place bet");
//        priceInfo.setText(String.valueOf(item.getPrice()));
        VBox vBox = new VBox(imageView,hBrand,hType,hSize,hPrice,bets,hBidder,bet);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(10,0,0,0));
        vBox.setSpacing(10);
        Text warning = new Text("Your bet is lover than last bet");
        warning.setStroke(Color.RED);

        HBox root = new HBox();
        root.setSpacing(50);
        root.getChildren().addAll(vBox,vTimer);
        root.setAlignment(Pos.CENTER);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            String s = item.timeUpdate();
            priceInfo.setText(String.valueOf(item.getPrice()));
            time.setText(s);
            ballance.setText(String.valueOf(user.getWalet().getMoney()));
            try{
                highestBid.setText(item.getHighestBetter().getName());
            }catch (Exception e){
                highestBid.setText(item.getOwner().getName());
            }
            if (s.equals("0:0:0:0")) {
                NotificationWindow.display("The " + item.getType()+ "auction has ended");
                window.close();

            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                timeline.stop();
            }
        });


//placing bids in auction
        bet.setOnAction(e-> {
            System.out.println();
            if(yourBetField.getText()!=""){
                if (ItemList.price(parseInt(yourBetField.getText()),item,user)) {
                    user.getWalet().returnMoney(item,user);
                    item.setPrice(Integer.parseInt(yourBetField.getText()));
                    item.setPrevouse(item.getHighestBetter());
                    item.addObserver(user);
//observer

//                    user.getWalet().setMoney(user.getWalet().getMoney()-item.getPrice());
//                    item.setOwner(user);

                } else {
                    try {
                        vBox.getChildren().add(warning);
                    }catch (Exception exception){

                    }
                }
            }
        });





        Scene scene = new Scene(root, 750,450);


        window.setTitle(user.getName());
        window.setScene(scene);
        window.show();

    }
}
