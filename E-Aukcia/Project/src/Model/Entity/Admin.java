package Model.Entity;

import UI.AdminPage;


/**
 * User which can delete auctions and see who is online
 */
public class Admin extends User{
    public Admin(String name, String password, String age, String rodneCislo) {
        super(name, password, age, rodneCislo);
    }

    /**
     * Opens adminpage
     */
    @Override
    public void getMainPage(){

        AdminPage adminPage = new AdminPage();
        adminPage.controlPanel(this.getCurrentlyLogedUser());
    }

}
