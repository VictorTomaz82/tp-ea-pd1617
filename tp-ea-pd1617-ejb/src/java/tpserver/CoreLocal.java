package tpserver;

import java.util.ArrayList;
import javax.ejb.Local;
import logic.Category;
import logic.Item;
import logic.Message;
import logic.Newsletter;
import logic.Report;
import logic.User;

@Local
public interface CoreLocal {
  
    public void load();
    public void save();
    public void checkAuctions();
    
    public Newsletter getNewsletter();
    public void setNewsletter(Newsletter newsletter);
    public ArrayList<User> getUsers();
    public void setUsers(ArrayList<User> users);
    public ArrayList<Report> getReports();
    public void setReports(ArrayList<Report> reports);
    public ArrayList<Item> getItems(); 
    public void setItems(ArrayList<Item> items);
    public ArrayList<Category> getCategories();
    public void setCategories(ArrayList<Category> categories);  
    public ArrayList<Message> getMessages();
    public void setMessages(ArrayList<Message> messages);   
//////////////////
    
    //----------------------DEBUG purposes only (begin)-------------------------
//    public String teste();
    //-----------------------DEBUG purposes only (end)--------------------------

}
