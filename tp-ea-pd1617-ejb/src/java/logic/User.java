package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    int userId;

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
    ArrayList<Integer> sales;
    ArrayList<Integer> won;
    ArrayList<Integer> followed;

    //arrays of messageId
    ArrayList<Integer> mailbox;

    //when adding to the bids of a item add to this array as well
    ArrayList<Bid> lastBids;

    public User(String username, String password, String name, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        balance = 0;
        active = false;
        logged = false;
        suspensions = new ArrayList<>();
        sales = new ArrayList<>();
        won = new ArrayList<>();
        lastBids = new ArrayList<>();
        followed = new ArrayList<>();
        mailbox = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public ArrayList<Integer> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Integer> sales) {
        this.sales = sales;
    }

    public ArrayList<Integer> getWon() {
        return won;
    }

    public void setWon(ArrayList<Integer> won) {
        this.won = won;
    }

    public ArrayList<Integer> getFollowed() {
        return followed;
    }

    public void setFollowed(ArrayList<Integer> followed) {
        this.followed = followed;
    }

    public ArrayList<Integer> getMailbox() {
        return mailbox;
    }

    public void setMailbox(ArrayList<Integer> mailbox) {
        this.mailbox = mailbox;
    }

    public ArrayList<Bid> getLastBids() {
        return lastBids;
    }

    public void setLastBids(ArrayList<Bid> lastBids) {
        this.lastBids = lastBids;
    }

    public String getGenericInformation() {

        if (!active && suspensions.isEmpty()) {
            return "UserId: " + userId
                    + "\nUsername: " + username
                    + "\nEstado: A aguardar ativacao.\n";
        }
        if (!active && !suspensions.isEmpty()) {
            return "UserId: " + userId
                    + "\nUsername: " + username
                    + "\nEstado: Suspenso.\n";
        }

        return "UserId: " + userId
                + "\nUsername: " + username
                + "\nEstado: Ativo.\n";
    }

    @Override
    public String toString() {
        String msg;
        msg = "UserId: " + userId
                + "\nUsername: " + username
                + "\nNome: " + name
                + "\nMorada: " + address
                + "\nSaldo: " + balance;
        if (active) {
            msg = msg + "\nStatus: Activo";
        } else {
            msg = msg + "\nStatus: Nao Activo";
        }
        if (logged) {
            msg = msg + " | online.\n";
        } else {
            msg = msg + " | offline.\n";
        }
        return msg;
    }
}
