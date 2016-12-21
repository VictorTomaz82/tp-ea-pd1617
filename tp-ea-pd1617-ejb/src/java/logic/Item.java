package logic;

import java.util.ArrayList;

public class Item {

    //aboutItem
    int id; //unique
    String name;
    String description;
    Category category;

    //aboutSale
    User seller;
    int startPrice;
    int buyout;

    //aboutTransactions
    ArrayList<Bid> bids;
    boolean isPayed;

    //--- Methods ---
    //Constructor without Category and Buyout 
    public Item(int id, String name, String description, User seller, int startPrice) {

        //ToDo: verify uniqueness of id on core to validate construction
        this.id = id;
        this.name = name;
        this.description = description;
        this.seller = seller;
        this.startPrice = startPrice;
        isPayed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public double getBuyout() {
        return buyout;
    }

    public void setBuyout(int buyout) {
        this.buyout = buyout;
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public void setBids(ArrayList<Bid> bids) {
        this.bids = bids;
    }

//    public boolean isIsPayed() {
//        return isPayed;
//    }
    
    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

}
