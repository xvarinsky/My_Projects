package Model;


import Model.Entity.*;
import UI.Auction;
import controler.ArrayPlus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * listo of items on auction
 */
public class ItemList {
    private static Item[] items= new Item[200];


    static public Item[] getItems() {
        return items;
    }

    public static void setItem(Item[] items) {
        ItemList.items = items;
    }


    static public Item getItems(int i) {
        return items[i];
    }

    /**
     * gets exact item used in ReadFile file and WriteFile for serialisation
     * @param item
     */
    public static void getItems(Item item){
        int i=0;
        while (items[i]!=null){
            i++;
        }

        items[i]= item;
        Auction.langs.add(items[i].getType());


        System.out.println("hell");
    }

    /**
     * Choose which item user wants to add
     * @param brand on this parameter the type of brand is chosen
     * @param type type of schoes
     * @param size size of shoes
     * @param price price of shoes
     * @param time time till the end of auction
     * @return shoe made out of inputs
     */
    public static Item chooseItem (String brand, String type, String size,int price, long time){
        int i=0;

    //        while(itemStrings[i]!=null){
    //            i++;
    //        }

        Item item = null;

        switch (brand) {
            case "Adidas":
                item = new Adidas(brand, type, size, price, time, User.getCurrentlyLogedUser());
                break;
            case "Nike":
                item = new Nike(brand, type, size, price, time, User.getCurrentlyLogedUser());
                break;
            case "New Balance":
                item = new NewBalance(brand, type, size, price, time, User.getCurrentlyLogedUser());
                break;
            case "Fila":
                item = new Fila(brand, type, size, price, time,User.getCurrentlyLogedUser());
                break;
            case "Balenciaga":
                item = new Balenciaga(brand, type, size, price, time,User.getCurrentlyLogedUser());
                break;
        }

        return item;
    }

//filters brands in auction
    public static Item[] filterBrands(String s){
        Item[] items = getItems();
        ObservableList<String> filteredLangs =  FXCollections.observableArrayList();
        Item[] filter = null;
        ArrayPlus arrayPlus = new ArrayPlus();
        for (int i = 0 ;items[i]!= null; i++){
            System.out.println(items[i].getBrand());
            if (items[i].getBrand().equals(s)){
                filteredLangs.add(items[i].getType());
                if (filter == null) {
                    filter = new Item[1];
                    filter[0] = items[i];
                    System.out.println();
                } else {
                    filter = (Item[]) arrayPlus.addOne(filter,items[i]);
                }
            }
            Auction.langs=filteredLangs;

        }
        System.out.println("lil");
        return filter;
    }

    /**
     * deletes item when admin want it to delete
     * @param index position in listOfItems
     */
    public static void deleteItem(int index){

        for(int j = index ; items[j]!=null; j++){
            items[j]=items[j+1];
        }
    }


    /**
     * check if the price of item is highter or lower than the last price and if user have enought money
     * @param i  the amount which bidder wants to bid
     * @param item Exact item which bidder wants to bid
     * @param user bidder
     * @return if amount of money is bigger than last bid
     */
    public static Boolean price(int i, Item item,User user){
        if(item.getPrice() < i&&i<user.getWalet().getMoney()){
            item.setPrice(i);
            return true;
        }else
            return false;
    }



}
