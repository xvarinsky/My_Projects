package Model.Entity;

import javafx.scene.image.Image;

/**
 * Item which is in auction
 */
public class Adidas extends Item{




    @Override
    public String getName(){
        return "Adidas";
    }



    public Adidas(String brand , String type, String size, int price, long time, User user) {
        super.setBrand(brand);
        super.setType(type);
        super.setSize(size);
        super.setStartPrice(price);
        super.setTime(time);
        super.image = new Image("C:/Users/dadvo/Vysoka/2.Semester/OOP/Projekt/images/Adidas_Logo.svg.png");
        super.setOwner(user);
        System.out.println("time set to: "+  super.getTime());
    }
}
