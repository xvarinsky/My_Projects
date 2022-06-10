package UI;

import Model.WriteFile;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * UI for registration
 */
public class Registration {
    public static void registerWindow(){
//        ID id;
        Stage window = new Stage();
        window.setTitle("Registration");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 50, 10 ,50));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label nameLable = new Label("Username");
        GridPane.setConstraints(nameLable, 0,0);
        TextField nameInput = new TextField();
        nameInput.setPromptText("Janko Mrkvicka");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passwordLable = new Label("Password");
        GridPane.setConstraints(passwordLable, 0,1);
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 1);

        Label repeatPasswordLable = new Label("Repeat password");
        GridPane.setConstraints(repeatPasswordLable, 0,2);
        TextField repeatPasswordInput = new TextField();
        repeatPasswordInput.setPromptText("Repeat password");
        GridPane.setConstraints(repeatPasswordInput, 1, 2);

        Label identificationNumberLable = new Label("Identification Number");
        GridPane.setConstraints(identificationNumberLable, 0,3);
        TextField identificationNumberInput = new TextField();
        identificationNumberInput.setPromptText("YYMMDDXXXX");
        GridPane.setConstraints(identificationNumberInput, 1, 3);


        Label ageLabel = new Label("Age");
        GridPane.setConstraints(ageLabel, 0,4);
        TextField ageInput = new TextField();
        ageInput.setPromptText("46");
        GridPane.setConstraints(ageInput, 1, 4);

        Button register = new Button("Register");
        GridPane.setConstraints(register,0,5);

        Label incorrectAgeLable = new Label("Incorrect input the age is too low");
        Scene scene1 = new Scene(incorrectAgeLable);

        register.setOnAction(e->{
            WriteFile.writeUser(nameInput.getText(),passwordInput.getText(),ageInput.getText(),identificationNumberInput.getText());
            window.close();
            SuccesfullRegister.succesfullRegister();
        });

        gridPane.getChildren().addAll(nameInput,nameLable,passwordInput,passwordLable,repeatPasswordInput,repeatPasswordLable,
                identificationNumberInput,identificationNumberLable,ageLabel, ageInput,register);
        Scene scene = new Scene(gridPane,400,250);
        window.setScene(scene);
        window.show();

    }

    private static int age(String age){
        int ageI = Integer.parseInt(age);
        return ageI;
    }
    private static long ID(String IN){
        long id = Long.parseLong(IN);
        return id;

    }



}