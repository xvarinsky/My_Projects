package Model;

import Model.Entity.User;
import UI.AdminPage;

/**
 * Array of users
 */
public class Login {

    public static User[] ids = new User[100];
//    public User currentlyLogedUser;

    /**
     * adds user to the array of users
     * @param id the user whic
     */
    public static void login(User id) {
        int i = 0;
        while (ids[i] != null) {
            i++;
        }
        ids[i]=id;
        AdminPage.users.add(id.getName());

    }


    /**
     * checks if username and password is correct if yes than open auction
     * @param name login User ntered
     * @param password password User entered
     * @return if login was correct or not
     */
    public static boolean login(String name, String password){
        int i = 0;
        while (ids[i]!= null){
            if (ids[i].getName().equals(name) && ids[i].getPassword().equals(password)){
                ids[i].setOnline(true);
                User.setCurrentlyLogedUser(ids[i]);

                User.getCurrentlyLogedUser().getMainPage();
                return true;
            }
            i++;
        }
        return false;
    }


    public static User findUser(String s){
        int i=0;
        while (!(s.equals(ids[i].getName()))) {
            i++;
        }
        return ids[i];
    }
}
