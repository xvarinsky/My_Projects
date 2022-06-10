package Model.Entity;


import UI.ShowItem;
import javafx.scene.image.Image;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * items shown in auction
 */
public abstract class Item extends Observable {
    private String brand;
    private String type;
    private String size;
    public int price;
    private int startPrice;
    private String sPrice;
    private Date time;
    public Image image;
    private User prevouse;
    private User highestBetter;
    User owner;


    public int getStartPrice() {
        return startPrice;
    }

    public User getHighestBetter() {
        return highestBetter;
    }

    public void setHighestBetter(User highestBetter) {
        this.highestBetter = highestBetter;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public User getPrevouse() {
        return prevouse;
    }

    public void setPrevouse(User prevouse) {
        this.prevouse = prevouse;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public Date getTime() {
        return time;
    }

    public void setBrand(String brand) {
        this.brand = brand;

    }

    public void setType(String type) {
        this.type = type;

    }

    public void setSize(String size) {
        this.size = size;

    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
        this.price = startPrice;
    }

    public void setPrice(int price) {
        this.startPrice = this.price;
        this.price = price;
        this.sPrice=String.valueOf(price);

    }

    public void setTime(long time) {
        this.time=new Date(time);
    }




    public String getBrand() {
        return brand;
    }


    //update of the time


    public String timeUpdate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd:HH:mm:ss");
        long diff =  time.getTime() - date.getTime();
        Date date1 = new Date(diff);
        System.out.println(date1);
//        System.out.println(format.format(diff));
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        String s = new String(diffDays+":"+diffHours+":"+diffMinutes+":"+diffSeconds);
        return s;
    }


    public abstract String getName();



    public void deletingItem(){
        setChanged();
        notifyObservers(this.getType());
    }

}
