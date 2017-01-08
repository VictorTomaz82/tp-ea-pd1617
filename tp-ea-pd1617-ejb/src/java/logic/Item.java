package logic;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Item implements Serializable{
    
    private static final long serialVersionUID = 1L;

    //aboutItem
    int itemId; //unique
    
    String itemName;
    String description;
    String category;

    //aboutSale
    String sellerUsername;
    int startPrice;
    int buyout;
    Date endTime;
    DateFormat dateFormat;

    //aboutTransactions
    ArrayList<Bid> bids;
    boolean payed;
    boolean closed;

    //--- Methods ---   
    //ToDo: missing endTime!!
    public Item(String itemName, String description, String category, String sellerUsername, int startPrice, int buyout, Date endTime) {

        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.sellerUsername = sellerUsername;
        this.startPrice = startPrice;
        this.buyout = buyout;
        this.endTime = endTime;
        bids = new ArrayList<>();
        payed = false;
        closed = false;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getBuyout() {
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

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    

    public String getGenericInformation() {

        if (closed && !payed && bids.isEmpty()) {
            return "ItemId: " + itemId
                    + "\nItemName: " + itemName
                    + "\nCategoria: " + category
                    + "\nEstado: Nao houve licitacoes.\n";
        }
        if (closed && !payed && !bids.isEmpty()) {
            return "ItemId: " + itemId
                    + "\nItemName: " + itemName
                    + "\nCategoria: " + category
                    + "\nEstado: A espera de pagamento.\n";
        }
        if (bids.isEmpty()) {
            return "ItemId: " + itemId
                    + "\nItemName: " + itemName
                    + "\nCategoria: " + category
                    + "\nValor inicial: " + startPrice + "\n";
        }

        return "ItemId: " + itemId
                + "\nItemName: " + itemName
                + "\nCategoria: " + category
                + "\nUltima licitacao: " + bids.get(0).getValue() + "\n";
    }

    @Override
    public String toString() {
        String msg;
        msg = "ItemId: " + itemId
                + "\nItemName: " + itemName
                + "\nDescription: " + description
                + "\nCategoria: " + category
                + "\nSellerUsername: " + sellerUsername
                + "\nStartPrice: " + startPrice
                + "\nBuyout: " + buyout
                + "\nBids: ";
        if (bids.isEmpty()) {
            msg = msg + "none";
        } else {
            for (int i = 0; i < bids.size(); i++) {
                msg = msg + "\n\t" + bids.get(i).toString();
            }
        }
        if (payed) {
            msg = msg + "\nPayed: True\n";
        } else {
            msg = msg + "\nPayed: False\n";
        }
        return msg;
    }
}
