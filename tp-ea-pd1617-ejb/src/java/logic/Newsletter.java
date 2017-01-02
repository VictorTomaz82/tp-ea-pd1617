package logic;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Newsletter implements Serializable{

    ArrayList<String> news;
    Date date;
    DateFormat dateFormat;

    //--- Methods ---
    //Constructor
    public Newsletter() {
        news = new ArrayList<>();
        dateFormat = new SimpleDateFormat(Response.DATE_FORMAT.toString());
        date = new Date();
    }

    public void setNews(ArrayList<String> news) {
        this.news = news;
    }

    public ArrayList<String> getNews() {
        return news;
    }

    public void newAccount(String username) {
        news.add(0, dateFormat.format(date) + Response.NEWS_NEW_USER.toString() + username + ".\n");
    }

    public void newAccountActivated(String username) {
        news.add(0, dateFormat.format(date) + Response.NEWS_NEW_USER_ACTIVATED.toString() + username + ".\n");
    }

    //Redundant!?
    public void userSuspendAccount(String username, String motive) {
        news.add(0, dateFormat.format(date) + " - " + username + Response.NEWS_SUSPENDED_USER.toString() + motive + "\".\n");
    }

    public void adminSuspendAccount(String username, String motive) {
        news.add(0, dateFormat.format(date) + " - " + username + Response.NEWS_SUSPENDED_USER.toString() + motive + "\".\n");
    }

    public void accountReactivation(String username) {
        news.add(0, dateFormat.format(date) + " - " + username + Response.NEWS_ASK_REACTIVATION.toString() + "\n");
    }

    public void accountReactivated(String username) {
        news.add(0, dateFormat.format(date) + " - " + username + Response.NEWS_ASK_REACTIVATED.toString() + "\n");
    }

    // Sold to whom?
    public void itemSold(String name, int value) {
        news.add(0, dateFormat.format(date) + Response.NEWS_ITEM_SOLD1.toString() + name + Response.NEWS_ITEM_SOLD2.toString() + value + Response.CURRENCY.toString() + ".\n");
    }
}
