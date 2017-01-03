package tpserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import logic.Category;
import logic.Item;
import logic.Message;
import logic.Newsletter;
import logic.Report;
import logic.Response;
import logic.User;

@Singleton
@LocalBean
public class Core implements CoreLocal, Serializable {

    Newsletter newsletter;
    ArrayList<User> users;
    ArrayList<Report> reports;
    ArrayList<Item> items;
    ArrayList<Category> categories;
    ArrayList<Message> messages;

    //--- Methods ---
    @PostConstruct
    public void load() {
        //load from file/database

        try (ObjectInputStream ois
                = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("/temp/tp1617")))) {
            ArrayList<Object> data = new ArrayList();
            data = (ArrayList<Object>) ois.readObject();

            newsletter = (Newsletter) data.get(0);
            users = (ArrayList<User>) data.get(1);
            reports = (ArrayList<Report>) data.get(2);
            items = (ArrayList<Item>) data.get(3);
            categories = (ArrayList<Category>) data.get(4);
            messages = (ArrayList<Message>) data.get(5);
        } catch (Exception e) {
            //ToDo
            newsletter = new Newsletter();
            users = new ArrayList();
            reports = new ArrayList();
            items = new ArrayList();
            categories = new ArrayList();
            messages = new ArrayList<>();
        }

//        newsletter = new Newsletter();
//        users = new ArrayList();
//        reports = new ArrayList();
//        items = new ArrayList();
//        categories = new ArrayList();
//        messages = new ArrayList<>();
        //To be deleted after all data being permanently saved?
        if (users.isEmpty()) {
            users.add(new User("admin", "admin", "admin", "Rua do Ze"));
            users.get(0).setActive(true);
            users.get(0).setAdministrator(true);
        }
    }

    @PreDestroy
    public void save() {
        //save to file/database

        try (ObjectOutputStream oos
                = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("/temp/tp1617")))) {
            ArrayList<Object> data = new ArrayList();
            data.add(newsletter);
            data.add(users);
            data.add(reports);
            data.add(items);
            data.add(categories);
            data.add(messages);

            oos.writeObject(data);
//            oos.writeObject(users);
//            oos.writeObject(reports);
//            oos.writeObject(items);
//            oos.writeObject(categories);
//            oos.writeObject(messages);
        } catch (Exception e) {
            //ToDO
        }
    }

    //Auctioneer Function
    @Schedule(second = "5", minute = "*", hour = "*")
    public void checkAuctions() {

        Date date;
        DateFormat dateFormat;

        dateFormat = new SimpleDateFormat(Response.DATE_FORMAT.toString());
        date = new Date();

        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getEndTime().after(date)) {
                getItems().get(i).setClosed(true);
                break;
            }
        }

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
