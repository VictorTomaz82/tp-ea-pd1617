package logic;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class News implements Serializable{

    String news;
    Date date;
    DateFormat dateFormat;

    //--- Methods ---
    //Constructor
    public News() {
        dateFormat = new SimpleDateFormat(Response.DATE_FORMAT.toString());
        date = new Date();
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }

    public void newAccount(String username) {
        date = new Date();
        news = dateFormat.format(date) + Response.NEWS_NEW_USER.toString() + username + ".\n";
    }

    public void newAccountActivated(String username) {
        date = new Date();
        news = dateFormat.format(date) + Response.NEWS_NEW_USER_ACTIVATED.toString() + username + ".\n";
    }

    //Redundant!?
    public void userSuspendAccount(String username, String motive) {
        date = new Date();
        news = dateFormat.format(date) + " - " + username + Response.NEWS_SUSPENDED_USER.toString() + motive + "\".\n";
    }

    public void adminSuspendAccount(String username, String motive) {
        date = new Date();
        news = dateFormat.format(date) + " - " + username + Response.NEWS_SUSPENDED_USER.toString() + motive + "\".\n";
    }

    public void accountReactivation(String username) {
        date = new Date();
        news = dateFormat.format(date) + " - " + username + Response.NEWS_ASK_REACTIVATION.toString() + "\n";
    }

    public void accountReactivated(String username) {
        date = new Date();
        news = dateFormat.format(date) + " - " + username + Response.NEWS_ASK_REACTIVATED.toString() + "\n";
    }

    // Sold to whom?
    public void itemSold(String username, String name, int value) {
        date = new Date();
        news = dateFormat.format(date) + Response.NEWS_ITEM_SOLD1.toString() + username + Response.NEWS_ITEM_SOLD2.toString() + name + Response.NEWS_ITEM_SOLD3.toString() + value + Response.CURRENCY.toString() + ".\n";
    }
}
