package logic;

import java.util.ArrayList;

public class User {

    String userId;

    String username;
    String password;
    
    String name;
    String address;
    int balance;
    boolean active;
    boolean administrator;
    ArrayList<Suspension> suspensions;
    ArrayList<Item> sales;
    ArrayList<Item> buys;
    ArrayList<Item> bids; //nao confundir com class bid... ou entao trocar isto
    ArrayList<Item> followed;
    ArrayList<Message> inbox;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        name = new String();
        address = new String();
        balance = 0;
        active = false;
        suspensions = new ArrayList<>();
        sales = new ArrayList<>();
        buys = new ArrayList<>();
        bids = new ArrayList<>(); //nao confundir com class bid... ou entao trocar isto
        followed = new ArrayList<>();
        inbox = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public ArrayList<Item> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Item> sales) {
        this.sales = sales;
    }

    public ArrayList<Item> getBuys() {
        return buys;
    }

    public void setBuys(ArrayList<Item> buys) {
        this.buys = buys;
    }

    public ArrayList<Item> getBids() {
        return bids;
    }

    public void setBids(ArrayList<Item> bids) {
        this.bids = bids;
    }

    public ArrayList<Item> getFollowed() {
        return followed;
    }

    public void setFollowed(ArrayList<Item> followed) {
        this.followed = followed;
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public void setInbox(ArrayList<Message> inbox) {
        this.inbox = inbox;
    }

}
