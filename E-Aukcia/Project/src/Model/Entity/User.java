package Model.Entity;

import Model.CorrectInfo;
import UI.Auction;
import UI.NotificationWindow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;


/**
 * User which can add auctions, bid on auctions, buy credits
 */
public class User implements Observer {
    private String name;
    private String password;
    private String age;
    private String ID;
    private boolean online;
    private Wallet walet;
    private Item[] inventory = new Item[0];
    private static User currentlyLogedUser;





    public static User getCurrentlyLogedUser() {
        return currentlyLogedUser;
    }

    public static void setCurrentlyLogedUser(User currentlyLogedUser) {
        User.currentlyLogedUser = currentlyLogedUser;
    }

    public User(String name, String password, String age, String rodneCislo) {
        this.name = name;
        this.password = password;
        this.age = age;

        this.ID = rodneCislo;
    }

    /**
     * creates or gives back wallet for user and admin
     * @return wallet for user
     */
    public Wallet getWalet() {
        if (walet==null && currentlyLogedUser.getClass()!=Admin.class){
            walet = Wallet.Factory.createWalet();
        }else if(walet==null){
            walet = new Wallet();
        }else return walet;
        return walet;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item inventory) {
        Item [] items = Arrays.copyOf(this.inventory, this.inventory.length+1);
        this.inventory = items;
        this.inventory[this.inventory.length-1]=inventory;

    }

    public User() {
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }



    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Forwards user to the auction page
     */
    public void getMainPage(){
        Auction auction = new Auction();
        auction.auction(currentlyLogedUser);
    };

    /**
     * observer
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (this.online){
            NotificationWindow.display("The " + (String) arg+ " auction has ended");
        }
    }

    /**
     * Builder pattern to build user
     * @return
     */
    public static Builder newUser(){
        return new Builder();
    }

    public User(Builder builder){
        setName(builder.name);
        setAge(builder.age);
        setPassword(builder.password);
    }
    //builder pattern
    public static class Builder{
          private String name;
          private String password;
          private String age;
          private String ID;

          private Builder(){
          }

          public Builder name(String name){
                this.name = name;
                return this;
          }

          public Builder password(String password){
              this.password = password;
              return this;
          }

          public Builder age(String age){
              this.age = age;
              return this;
          }

            public User build(){
              return new User(this);
            }

            public Builder ID(String ID){
              this.ID = ID;
              return this;
            }

      }

    /**
     * Creates Texts for GUI for online status
     * @param user User which we want to get online status
     * @return Text if he is online or not
     */
    public static Text onlineStatus(User user){
        Text text = null;
        if (user.isOnline()){
            text = new Text("<>Online");
            text.setFill(Color.GREEN);
        }else {
            text = new Text("<>Offile");
            text.setFill(Color.RED);
        }
        return text;
    }




    //chcecks the card informations
//    public static boolean corectInfo(Integer amount , String cardNumber, String cardExpiration, String cardSecurity ){
//        CorrectInfo info = ((amount, cardNumber1, cardExpiration1, cardSecurity1) -> {
//            if (amount>1&&cardNumber.length()==16&&cardExpiration.substring(2,3).equals("/")&&cardSecurity.length()==3){
//                return true;
//            }else return false;
//        });
//    }

}
