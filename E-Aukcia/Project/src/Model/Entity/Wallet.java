package Model.Entity;



import Model.Login;

/**
 * Wallet of the user
 */
public class Wallet {
    private float money;


    public Wallet() {

    }

    public float getMoney() {
        return money;
    }


    protected class Factory {
        /**
         * Returns wallet with starting bonus 10€
         */
        public static Wallet createWalet(){
            Wallet wallet = new Wallet();
            wallet.setMoneyAdmin(10);
            return wallet;
        }
    }

    /**
     * When userr wants to add money the 3% of them goes to the admin
     * @param money amount which user wants to add
     */
    public void setMoney(float money) {
        Login.ids[0].getWalet().setMoneyAdmin((float) (money*0.03));
        this.money = (float) (money*0.97);
    }

    /**
     * adds full amount to he waller
     * @param money amount of money
     */
    private void setMoneyAdmin(float money){
        this.money = money;
    }

    //returns money to the last user which beted

    /**
     * Returns money to the last bidder
     * @param item
     * @param user
     */
    public void returnMoney(Item item,User user){

        item.setPrevouse(item.getHighestBetter());
        item.setHighestBetter(user);
        user.getWalet().setMoneyAdmin(user.getWalet().getMoney()- item.getPrice());
        try {
            item.getPrevouse().getWalet().setMoneyAdmin(item.getStartPrice()+item.getPrevouse().getWalet().getMoney());
        }catch (Exception e){}
    }


//    public void returnMoney(Item item,User user){
//        try {
//            item.getPrevouse().getWalet().setMoneyAdmin(item.getPrice() + item.getPrevouse().getWalet().getMoney());
//        }catch (Exception e){}
//        item.setPrevouse(item.getHighestBetter());
//        item.setHighestBetter(user);
//        user.getWalet().setMoneyAdmin(user.getWalet().getMoney()-item.getPrice());
//    }
}
