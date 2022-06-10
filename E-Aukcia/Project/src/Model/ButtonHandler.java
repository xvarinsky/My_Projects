package Model;

import Model.Entity.Item;
import Model.Entity.User;
import UI.ShowItem;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * custom handler
 */
public class ButtonHandler implements EventHandler<MouseEvent> {
    User u;


    public ButtonHandler(User u ) {
        this.u = u;

    }

    /**
     * handle opening of the curent auction
     * @param mouseEvent
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2){
            String event = mouseEvent.getTarget().toString();
            String[] eventy = event.split("'",0);
            Item[] items = ItemList.getItems();
            for (int i =0 ; items[i]!=null;i++){
                if (items[i].getType().equals(eventy[1])){
                    ShowItem showItem = new ShowItem();
                    showItem.show(items[i],this.u);
                    break;
                }
            }
        }
    }
}
