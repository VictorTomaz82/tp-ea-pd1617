package user.types;

import java.util.ArrayList;
import java.util.Date;

public interface UserType {

    //--- all ---
    public ArrayList<String> seeNews();

    public ArrayList<String> seeLastThree();

    //--- visitor ---
    public ArrayList<String> askAccess(String username, String password);

    public ArrayList<String> askReactivation(String username, String password);

    //--- admin & user ---
    //change to confirm password only in client?
    public ArrayList<String> changePassword(String username, String password, String newPassword, String confirmPassword);

    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time);

    //--- user ---
    public ArrayList<String> doSale(String sellerUsername, String itemName, String description, int startPrice, int buyout);

    public ArrayList<String> doBid(String username, String itemId, int bid);

    public ArrayList<String> denunceItem(String itemId, String motive);
    
    public ArrayList<String> denunceUser(String username, String motive);

    public ArrayList<String> follow(String username, String itemId);
    
    public ArrayList<String> addBalance(String username, int money);

    public ArrayList<String> payItem(String username, String itemId);

    public ArrayList<String> askSuspension(String username, String motive);

//    public ArrayList<String> unactivate(String userId);

    //--- admin ---
    public ArrayList<String> suspendUser(String username, String motive);

    public ArrayList<String> reactivateUser(String username);

    public ArrayList<String> seeUser(String username);

    public ArrayList<String> seeItem(String itemId);

    public ArrayList<String> addCategory(String name, String description);

    public ArrayList<String> changeCategory(String name, String newName, String description);

}
