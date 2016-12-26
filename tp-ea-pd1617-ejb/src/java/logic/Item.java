package logic;

import java.util.ArrayList;

public class Item {

    //aboutItem
    int itemId; //unique
    String name;
    String description;
    Category category;

    //aboutSale
    String sellerId;
    int startPrice;
    int buyout;

    //aboutTransactions
    ArrayList<Bid> bids;
    boolean payed;

    //--- Methods ---
    //Constructor without Category and Buyout 
    public Item(int itemId, String name, String description, String sellerId, int startPrice) {

        //ToDo: verify uniqueness of id on core to validate construction
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.sellerId= sellerId;
        this.startPrice = startPrice;
        payed = false;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
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


    public boolean isPayed() {
        return payed;
    }
    
    public void setPayed(boolean payed) {
        this.payed = payed;
    }

}
