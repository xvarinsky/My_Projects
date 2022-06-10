package Model;

import Model.Entity.Item;

import UI.Auction;

import java.util.Date;
import java.util.Observable;


public class AuctionTime extends Observable {
    /**
     * Chcecks time if it is not zero if it is it ends auction and add item to the highest bidder of the auction
     */
    public void timerChcek(){
        Date date = new Date();
        int j;

        Item[] item = ItemList.getItems();
        for (int i = 0; item[i]!=null ;i++){
            if (item[i].getTime().before(date)){
                Auction.langs.remove(i);
                item[i].deletingItem();
                if (item[i].getHighestBetter()==null){
                    item[i].getOwner().setInventory(item[i]);
                }else {
                    item[i].getHighestBetter().setInventory(item[i]);
                }
                j=i;
                while (item[j]!=null){
                    item[j]=item[j+1];
                    j++;
                }
            }
        }
        ItemList.setItem(item);
    }
}
