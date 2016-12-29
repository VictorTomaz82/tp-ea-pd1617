package logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bid {
    
    int itemId;
    User username;
    int value;
    Date time;
    DateFormat dateFormat;

    // --- Methods ---
    public Bid(int itemId, User username, int value, Date time) {
        this.itemId = itemId;
        this.username = username;
        this.value = value;
        this.time = time;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return dateFormat.format(time) + " " + itemId +": "+ username + " " + value + "€";
    }
}
