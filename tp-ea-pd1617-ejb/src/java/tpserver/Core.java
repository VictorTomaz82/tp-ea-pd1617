package tpserver;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import logic.Category;
import logic.Item;
import logic.Report;
import logic.User;

@Singleton
@LocalBean
public class Core implements CoreLocal {

    ArrayList<User> users;
    ArrayList<Report> reports;
    ArrayList<Item> items;
    ArrayList<Category> categories;

    //Waiting on newletter
    //Newsletter newsletter;
    
    //--- Methods ---
    
    @PostConstruct
    public void load() {

        //fetch from database
    }

    @PreDestroy
    public void save() {

        //save on database
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    
    //----------------------DEBUG purposes only (begin)-------------------------
    @Override
    public String teste() {
        return "comunica";
    }
    //-----------------------DEBUG purposes only (end)--------------------------

}
