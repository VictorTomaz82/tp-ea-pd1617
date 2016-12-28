package logic;

import java.util.ArrayList;

public class User {

//    String userId;

    String username;
    String password;

    String name;
    String address;
    int balance;
    boolean active;
    boolean logged;
    boolean administrator;

    ArrayList<Suspension> suspensions;
    //arrays of itemId
    ArrayList<String> sales;
    ArrayList<String> buys;
    ArrayList<String> followed;
    
    //arrays of messageId
    ArrayList<String> mailbox;

    //when adding to the bids of a item add to this array as well
    ArrayList<Bid> lastBids;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        name = new String();
        address = new String();
        balance = 0;
        active = false;
        logged = false;
        suspensions = new ArrayList<>();
        sales = new ArrayList<>();
        buys = new ArrayList<>();
        lastBids = new ArrayList<>();
        followed = new ArrayList<>();
        mailbox = new ArrayList<>();
    }

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public ArrayList<Suspension> getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(ArrayList<Suspension> suspensions) {
        this.suspensions = suspensions;
    }

    public ArrayList<String> getSales() {
        return sales;
    }

    public void setSales(ArrayList<String> sales) {
        this.sales = sales;
    }

    public ArrayList<String> getBuys() {
        return buys;
    }

    public void setBuys(ArrayList<String> buys) {
        this.buys = buys;
    }

    public ArrayList<String> getFollowed() {
        return followed;
    }

    public void setFollowed(ArrayList<String> followed) {
        this.followed = followed;
    }

    public ArrayList<String> getMailbox() {
        return mailbox;
    }

    public void setMailbox(ArrayList<String> mailbox) {
        this.mailbox = mailbox;
    }

    public ArrayList<Bid> getLastBids() {
        return lastBids;
    }

    public void setLastBids(ArrayList<Bid> lastBids) {
        this.lastBids = lastBids;
    }

}
