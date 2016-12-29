package logic;

import java.util.ArrayList;

public class Item {

    //aboutItem
    int itemId; //unique
    String itemName;
    String description;
    Category category;

    //aboutSale
    String sellerUsername;
    int startPrice;
    int buyout;

    //aboutTransactions
    ArrayList<Bid> bids;
    boolean payed;

    //--- Methods ---
    //Constructor without Category and Buyout 
    public Item(String itemName, String description, String sellerUsername, int startPrice, int buyout) {

        //ToDo: verify uniqueness of id on core to validate construction
        this.itemName = itemName;
        this.description = description;
        this.sellerUsername= sellerUsername;
        this.startPrice = startPrice;
        this.buyout = buyout;
        payed = false;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
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

    @Override
    public String toString() {
        String msg;
        msg = "ItemId: " + itemId
                + "\nItemName: " + itemName
                + "\nDescription: " + description
                + "\nCategory: " + category.getName()
                + "\nSellerUsername: " + sellerUsername
                + "\nStartPrice: " + startPrice
                + "\nBuyout: " + buyout
                + "\nBids: ";
        if(bids.isEmpty())
            msg = msg + "none";
        else
            for(int i = 0; i < bids.size(); i++)
                msg = msg + "\n\t" + bids.get(i).toString();
        if(payed)
            msg = msg + "\nPayed: True";
        else
            msg = msg + "\nPayed: False";
        return msg;
    }
}
