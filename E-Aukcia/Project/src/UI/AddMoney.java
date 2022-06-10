package UI;

import Model.CorrectInfo;
import Model.Entity.User;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Gui for adding money
 */
public class AddMoney {
    public static void open(User user){
        Stage window = new Stage();
        Text addBalance = new Text("Amount to add: ");
        TextField amount = new TextField();
        Text cardNo = new Text("Card no.: ");
        Text euro = new Text("€");
        Label warning = new Label("Paymant has not been succesfull");
        warning.setTextFill(Color.RED);
        TextField cardNoField = new TextField();
        TextField cardExpiration = new TextField();
        TextField cardSecurityNo = new TextField();

        cardNoField.setPromptText("XXXX XXXX XXXX XXXX");
        cardExpiration.setPromptText("XX/XX");
        cardExpiration.setMaxHeight(20);
        cardExpiration.setMaxWidth(100);
        cardSecurityNo.setPromptText("XXX");
        cardSecurityNo.setMaxWidth(50);
        Button add = new Button("Pay");
        HBox nullrow= new HBox();
        HBox firstRow = new HBox();
        HBox seconwRow = new HBox();
        nullrow.getChildren().addAll(addBalance,amount,euro);
        firstRow.getChildren().addAll(cardNo,cardNoField);
        seconwRow.getChildren().addAll(cardExpiration,cardSecurityNo);
        seconwRow.setSpacing(45);
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(nullrow,firstRow,seconwRow,add);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300,200);
        window.setTitle("Payment");
        window.setScene(scene);
        window.show();
//lambda
        add.setOnAction(e->{
            CorrectInfo info = ((a, b, c, d) -> {
                if (a>1&&b.length()==16&&c.substring(2,3).equals("/")&&d.length()==3){
                    return true;
                }else return false;
            });

            if (info.correctInfo(Integer.parseInt(amount.getText()),cardNoField.getText(),cardExpiration.getText(),cardSecurityNo.getText())){
                user.getWalet().setMoney(Float.parseFloat(amount.getText()));
                window.close();
            }else {
                try {
                    System.out.println(Integer.parseInt(amount.getText())+","+cardNoField.getText().length()+","+cardExpiration.getText(3,4)+","+cardSecurityNo.getText().length());
                    root.getChildren().add(warning);
                }catch (Exception exception){}
            }
        });
    }
}
