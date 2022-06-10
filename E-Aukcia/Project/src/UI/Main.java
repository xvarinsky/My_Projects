package UI;


import Model.InvalidExeption;
import Model.Login;
import Model.ReadFile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Main function start for application
 */
public class Main extends Application  {

    Stage window;

    public static void main(String[] args) {
// inicializacia admina a multithreading
//        Admin admin = new Admin("Admin","admin","100","200");
//        Login.login(admin);
        //multithreading
        Thread t = new Thread(()->{
            ReadFile.readFileUsers();
            ReadFile.readFileItems();
//            System.out.println(Thread.currentThread());
        });
        t.start();
        launch(args);
    }
//gui of Login page

    /**
     * gui login page
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println(Thread.currentThread());
        window = primaryStage;
        window.setTitle("javaFX");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50,40,50,40));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //Name lable and input
        Label nameLable = new Label("Username");
        GridPane.setConstraints(nameLable, 0,0);
        TextField nameInput = new TextField();
        nameInput.setPromptText("Janko Mrkvicka");
        GridPane.setConstraints(nameInput, 1, 0);


        Label passwordLable = new Label("Password");
        GridPane.setConstraints(passwordLable, 0,1);
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Heslo");
        GridPane.setConstraints(passwordInput,1,1);




        Button loginButton = new Button("Log In");
        Button registerButton = new Button("Register");
        GridPane.setConstraints(loginButton,0,2);
        GridPane.setConstraints(registerButton,1,2);

//        Scene scene1 = new Scene();
        Label wrong = new Label();
        GridPane.setConstraints(wrong,1,3);

        loginButton.setOnAction(e ->
        {

            try {
                if (Login.login(nameInput.getText(), passwordInput.getText())) {
                    nameInput.clear();
                    passwordInput.clear();

                } else {
                    throw new   InvalidExeption();
                }
            }catch (InvalidExeption d){
                System.out.println(d.getMessage());
                wrong.setText("Wrong name or password");
            }

        });

        registerButton.setOnAction(e -> {
            Registration.registerWindow();
        });


        gridPane.getChildren().addAll(nameInput,nameLable,passwordInput,passwordLable,loginButton,registerButton,wrong);
        Scene scene = new Scene(gridPane,300 , 200);

        window.setScene(scene);
        window.show();
    }
}