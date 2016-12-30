package tpserver;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import logic.Category;
import logic.Item;
import logic.Message;
import logic.Newsletter;
import logic.Report;
import logic.User;

@Singleton
@LocalBean
public class Core implements CoreLocal {

    Newsletter newsletter;
    ArrayList<User> users;
    ArrayList<Report> reports;
    ArrayList<Item> items;
    ArrayList<Category> categories;
    ArrayList<Message> messages;


    //--- Methods ---
    @PostConstruct
    public void load() {

        //Initializate the sctructures
        newsletter=new Newsletter();
        users= new ArrayList();
        reports=new ArrayList();
        items=new ArrayList();
        categories= new ArrayList();
        
        //To be deleted after all data being permanently saved?
        if(users.isEmpty()){
            users.add(new User("admin","admin","admin","Rua do Ze"));
            users.get(0).setActive(true);
            users.get(0).setAdministrator(true);
        }
    }

    @PreDestroy
    public void save() {

        //save on database
    }

    @Override
    public Newsletter getNewsletter() {
        return newsletter;
    }

    @Override
    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }
    
    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public ArrayList<Report> getReports() {
        return reports;
    }

    @Override
    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    @Override
    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public ArrayList<Category> getCategories() {
        return categories;
    }

    @Override
    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    
    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    //----------------------DEBUG purposes only (begin)-------------------------
//    @Override
//    public String teste() {
//        return "comunica";
//    }
    //-----------------------DEBUG purposes only (end)--------------------------

}