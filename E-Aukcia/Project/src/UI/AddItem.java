package UI;


import Model.InvalidExeption;
import controler.Corection;
import Model.WriteFile;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.text.ParseException;
/**
 * gui for adding items
 */
public class AddItem {

    public static void add(){
        Stage window = new Stage();

        window.setTitle("Add Item");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 50, 10 ,50));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        ChoiceBox<String> brandChoiceBox = new ChoiceBox<>();
        brandChoiceBox.setValue("Choose brand");
        brandChoiceBox.setItems(FXCollections.observableArrayList("Adidas", "Nike","Balenciaga","New Balance", "Fila"));
        Label brandLabel = new Label("Brand");
        GridPane.setConstraints(brandLabel, 0,0);
        GridPane.setConstraints(brandChoiceBox, 1, 0);

        Label typeLabel = new Label("Type");
        GridPane.setConstraints(typeLabel, 0,1);
        TextField typeIn = new TextField();
        typeIn.setPromptText("Yeezy");
        GridPane.setConstraints(typeIn, 1, 1);

        Label sizeLabel = new Label("Size EU:");
        GridPane.setConstraints(sizeLabel, 0,2);
        TextField sizeIn = new TextField();
        sizeIn.setPromptText("43");
        GridPane.setConstraints(sizeIn, 1, 2);

        Label priceLabel = new Label("Price");
        GridPane.setConstraints(priceLabel, 0,3);
        TextField priceIn = new TextField();
        priceIn.setPromptText("34");
        GridPane.setConstraints(priceIn, 1, 3);




        Label timeLabel = new Label("Time till end");
        GridPane.setConstraints(timeLabel, 0,4);

        ChoiceBox<String> day = new ChoiceBox<>(FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"));
        ChoiceBox<String> hour=new ChoiceBox<>();
        ChoiceBox<String> min = new ChoiceBox<>();
        ChoiceBox<String> sec = new ChoiceBox<>();
        day.setValue("Day");
        hour.setValue("Hour");
        min.setValue("Minute");
        sec.setValue("Sec");
        day.setItems(FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"));
        hour.setItems(FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"));
        min.setItems(FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"));
        sec.setItems(FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"));
        GridPane.setConstraints(day,1,4);
        GridPane.setConstraints(hour,2,4);
        GridPane.setConstraints(min,3,4);
        GridPane.setConstraints(sec,4,4);

        HBox h = new HBox(day,hour,min,sec);
        gridPane.getChildren().addAll(h);

        GridPane.setConstraints(h,1,4);


        Button addItem = new Button("Add item");
        GridPane.setConstraints(addItem,0,5);

        addItem.setOnAction(e-> {
                    try {
                        WriteFile.writeItem(brandChoiceBox.getValue(),typeIn.getText(),sizeIn.getText(),Integer.parseInt(priceIn.getText()), Corection.endingTime(String.format("%2s",day.getValue())+":"+String.format("%2s",hour.getValue())+":"+String.format("%2s",min.getValue())+":"+String.format("%2s",sec.getValue())));
                        window.close();
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }catch (InvalidExeption c){
                        NotificationWindow.display("This type of shoes allready exists");
                    }



        }
        );


        addItem.setMaxSize(100,100);

        gridPane.getChildren().addAll(brandLabel,brandChoiceBox,typeLabel,typeIn,timeLabel/*,timeIn*/,sizeLabel,sizeIn,priceLabel,priceIn,addItem);
//
        addItem.setMaxHeight(30);
        addItem.setMaxWidth(150);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);


        Scene scene = new Scene(borderPane, 450, 240);
        window.setTitle("Add item");
        window.setScene(scene);
        window.show();

    }
}
/*Label repeatPasswordLable = new Label("Repeat password");
        GridPane.setConstraints(repeatPasswordLable, 0,2);
        TextField repeatPasswordInput = new TextField();
        repeatPasswordInput.setPromptText("Repeat password");
        GridPane.setConstraints(repeatPasswordInput, 1, 2);
        */

