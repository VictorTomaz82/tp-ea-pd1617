package logic;

import java.util.Date;

public class Bid {

    User user;
    int value;
    Date time;

    // --- Methods ---
    public Bid(User user, int value, Date time) {
        this.user = user;
        this.value = value;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getValue() {
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

}
