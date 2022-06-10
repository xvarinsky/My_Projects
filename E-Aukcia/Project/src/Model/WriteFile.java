package Model;


import Model.Entity.Item;
import Model.Entity.User;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Model.ItemList.getItems;

/**
 * try of serialisation
 */


public class WriteFile {
    //writing users to the document
    public static void writeUser(String name, String password, String age, String ID) {
        File file = new File("userList.txt");
        try {
            User user = new User();
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write(name + "\n");
            user.setName(name);
            myWriter.write(password + "\n");
            user.setPassword(password);
            myWriter.write(age + "\n");
            user.setAge(age);
            myWriter.write(ID + "\n");
            user.setID(ID);
            myWriter.write("$$$" + "\n");
            myWriter.close();
            Login.login(user);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
//        writing Items to the document
        public static void writeItem(String brand, String type, String size, int price, long time) throws InvalidExeption {
            Item[] items = ItemList.getItems();
            for (int i = 0 ; items[i]!=null; i++){
                if (items[i].getType().equals(type)){
                    throw new InvalidExeption("The the item is not correct");
                }
            }
            File file = new File("itemList.txt");
            Item item = null;
            try {
                item = ItemList.chooseItem(brand, type, size, price, time);
//                item.attach(item);
                FileWriter myWriter = new FileWriter(file, true);
                myWriter.write(brand + "\n");
                myWriter.write(type + "\n");
                myWriter.write(size + "\n");
                myWriter.write(price + "\n");
                myWriter.write(time + "\n");
                myWriter.write(User.getCurrentlyLogedUser().getName() + "\n");
                myWriter.write("$$$" + "\n");
                myWriter.close();
                getItems(item);
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }

    /**
     * writes ewery item when window is closed
     */
        public static void endWriteFile(){
            File file = new File("itemList.txt");
            Item[] items = getItems();
            int i=0;
            try {
                FileWriter myWriter = new FileWriter(file);

                while (items[i]!=null){
                    myWriter.write(items[i].getBrand() + "\n");
                    myWriter.write(items[i].getType() + "\n");
                    myWriter.write(items[i].getSize() + "\n");
                    myWriter.write(items[i].getPrice() + "\n");
                    myWriter.write(items[i].getTime().getTime()+"\n");
                    myWriter.write(items[i].getOwner().getName()+ "\n");
                    myWriter.write("$$$" + "\n");
                    i++;
                }
                myWriter.close();

            }catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }

}
