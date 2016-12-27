package tpserver;

import java.util.ArrayList;
import javax.ejb.Local;
import logic.Category;
import logic.Item;
import logic.Newsletter;
import logic.Report;
import logic.User;

@Local
public interface CoreLocal {

    Newsletter getNewsletter();

    void setNewsletter(Newsletter newsletter);
    
    ArrayList<User> getUsers();

    void setUsers(ArrayList<User> users);

    ArrayList<Report> getReports();

    void setReports(ArrayList<Report> reports);

    ArrayList<Item> getItems();

    void setItems(ArrayList<Item> items);

    ArrayList<Category> getCategories();

    void setCategories(ArrayList<Category> categories);

    //----------------------DEBUG purposes only (begin)-------------------------
    String teste();
    //-----------------------DEBUG purposes only (end)--------------------------

}
