package logic;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;

//@Entity
//@Table(name="t_bids")
//
//@NamedQueries({
//    @NamedQuery(name="TBids.findAll",
//            query="SELECT t FROM TBids t"),
//    @NamedQuery(name = "TBids.findById",
//            query="SELECT t FROM TBids t WHERE t.bidId = :bidId")
//        })

public class Bid implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "bidId")
    int bidId;

//    @Basic(optional = false)
//    @Column(name = "itemId")
    int itemId;
    String username;
    int value;
    Date date;
    DateFormat dateFormat;

    // --- Methods ---
    
//    public Bid(){
//        
//    }
    
    public Bid(int itemId, String username, int value, Date date) {
        this.itemId = itemId;
        this.username = username;
        this.value = value;
        this.date = date;
        dateFormat = new SimpleDateFormat(Response.DATE_FORMAT.toString());
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return dateFormat.format(date) + " " + itemId + ": " + username + " " + value + " " + Response.CURRENCY.toString();
    }
}
