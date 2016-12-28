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
    public ArrayList<String> changePassword(String username, String password, String confirmPassword);

    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time);

    //--- user ---
    public ArrayList<String> doSale(String name, String description, String sellerId, int startPrice);

    public ArrayList<String> doBid(String itemId);

    public ArrayList<String> denunce(String userId, String itemId, String motive);

    public ArrayList<String> follow(String itemId);

    public ArrayList<String> payItem(String userId, String itemId);

    public ArrayList<String> addBalance(String userId, int money);

    public ArrayList<String> askSuspension(String userId, String motive);

    public ArrayList<String> unactivate(String userId);

    //--- admin ---
    public ArrayList<String> suspendUser(String userId, String motive);

    public ArrayList<String> reactivateUser(String userId);

    public ArrayList<String> seeUser(String userId);

    public ArrayList<String> seeItem(String itemId);

    public ArrayList<String> addCategory(String name, String description);

    public ArrayList<String> changeCategory(String name, String newName, String description);

}
