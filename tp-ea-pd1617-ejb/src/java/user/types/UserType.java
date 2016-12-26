package user.types;

import java.util.Date;

public interface UserType {

    //--- all ---
    public String seeNews();

    //--- visitor ---
    public String seeLastThree();

    //change to confirm password only in client?
    public void askAccess(String username, String password, String confirmpassword);

    public void askReactivation(String username, String password);
    
    //--- admin & user ---

    //change to confirm password only in client?
    public void changePassword(String username, String password, String confirmpassword);

    public void messageUser(String senderId, String recipientId, String title, String body, Date time) ;

    //--- user ---
    public void doSale(String name, String description, String sellerId, int startPrice);

    public void doBid(String itemId);

    public void denunce(String userId, String itemId, String motive);

    public void follow(String itemId);

    public void payItem(String itemId);

    public void addBalance(int money);

    public void askSuspension(String userId, String motive);

    public void unactivate(String userId);

    //--- admin ---
    public void suspendUser(String userId, String motive);

    public void reactivateUser(String userId);

    public void seeUser(String userId);

    public void seeItem(String itemId);

    public void addCategory(String name, String description);

    public void changeCategory(String name, String newName, String description);

}
