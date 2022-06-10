package Model;


import Model.Entity.Admin;
import Model.Entity.Item;
import Model.Entity.User;

import java.io.File;
import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * My try of deserialisation
 */
public class ReadFile {
//reading users from the document
    public static void readFileUsers(){

        try {
            File myObj = new File("userList.txt");
            Scanner myReader = new Scanner(myObj);
            Admin admin = new Admin("Admin","admin","100","200");
            Login.login(admin);

            while (myReader.hasNextLine()) {

                String name = myReader.nextLine();
                String password = myReader.nextLine();
                String age = myReader.nextLine();
                String ID = myReader.nextLine();
                myReader.nextLine();

//builder pattern
                User user = User.newUser()
                        .age(age)
                        .name(name)
                        .password(password)
                        .ID(ID)
                        .build();
/*
                user.setName(name);
                user.setPassword(password);
                user.setAge(age);
                user.setID(ID);
*/
                Login.login(user);
                System.out.println(name);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

//reading items from the document
    public static void readFileItems(){

        try {
            File myObj = new File("itemList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String brand = myReader.nextLine();
                String type = myReader.nextLine();
                String size = myReader.nextLine();
                String price = myReader.nextLine();
                SimpleDateFormat format = new SimpleDateFormat("dd:HH:mm:ss");
                String time = myReader.nextLine();
                String user = myReader.nextLine();

                myReader.nextLine();
                Item item = ItemList.chooseItem(brand,type,size,Integer.parseInt(price),Long.parseLong(time));
                item.setOwner(Login.findUser(user));
                ItemList.getItems(item);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
//    public static Item chooseItem (String brand, String type, String size, int price, String time){
//
//        Item item = null;
//        switch (brand) {
//            case "Adidas":
//                item = new Adidas(brand, type, size, price, time,);
//                break;
//            case "Nike":
//                item = new Nike(brand, type, size, price, time);
//                break;
//            case "New Balance":
//                item = new NewBalance(brand, type, size, price, time);
//                break;
//            case "Fila":
//                item = new Fila(brand, type, size, price, time);
//                break;
//            case "Balenciaga":
//                item = new Balenciaga(brand, type, size, price, time);
//                break;
//        }
//
//        return item;
//    }
}
//generalizovana trieda