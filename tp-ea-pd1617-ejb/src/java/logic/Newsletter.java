package logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Newsletter {

    ArrayList<String> news;
    Date date;
    DateFormat dateFormat;

    //--- Methods ---
    //Constructor
    public Newsletter() {
        news = new ArrayList<>();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
    }

    public void setNews(ArrayList<String> news) {
        this.news = news;
    }
    
    public ArrayList<String> getNews() {
        return news;
    }

    public void newAccount(String username) {
        news.add(0, dateFormat.format(date) + " - New user registered : " + username + ".");
    }

    public void userSuspendAccount(String username, String motive) {
        news.add(0, dateFormat.format(date) + " - " + username + " has suspended his account for \"" + motive + "\".");
    }

    public void adminSuspendAccount(String username, String motive) {
        news.add(0, dateFormat.format(date) + " - " + username + " has been suspended for \"" + motive + "\".");
    }

    public void accountReactivation(String username) {
        news.add(0, dateFormat.format(date) + " - " + username + " asked for account reactivation.");
    }

    public void itemSold(String name, int value) {
        news.add(0, dateFormat.format(date) + " - The item " + name + " was sold for " + value + "€.");
    }
}
