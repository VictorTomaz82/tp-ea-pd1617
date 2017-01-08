package usertypes;

import java.util.ArrayList;
import java.util.Date;

public interface UserType {

    //--- all ---
    public ArrayList<String> seeNews();

    public ArrayList<String> seeLastThree();

    //--- visitor ---
    public ArrayList<String> askAccess(String username, String password, String name, String address);

    public ArrayList<String> askReactivation(String username, String password);

    //--- admin & user ---
    public ArrayList<String> changePassword(String username, String password, String newPassword, String confirmPassword);

    public ArrayList<String> changeUserInformation(String username, String name,String address);
    
    public ArrayList<String> viewMessageList(String username);
    
    public ArrayList<String> viewMessage(String username, String messageId);

    public ArrayList<String> messageUser(String senderUsername, String recipientUsername, String title, String body, Date time);

    public ArrayList<String> doSale(String sellerUsername, String itemName, String categoryName, String description, int startPrice, int buyout, Date endTime);
    
    public ArrayList<String> viewUserItemsList(String username);
    
    public ArrayList<String> viewSellingItemList();
    
    public ArrayList<String> viewBiddedItemList(String username);
    
    public ArrayList<String> viewWonItemList(String username);
    
    public ArrayList<String> viewFollowedItemList(String username);
    
    public ArrayList<String> follow(String username, String itemId);

    public ArrayList<String> doBid(String username, String itemId, int bid);

    public ArrayList<String> denunceItem(String itemId, String motive);

    public ArrayList<String> denunceUser(String username, String motive);
    
    public ArrayList<String> viewUserBalance(String username);

    public ArrayList<String> addBalance(String username, int money);

    public ArrayList<String> payItem(String username, String itemId);

    public ArrayList<String> askSuspension(String username, String motive);

    //--- admin ---
    public ArrayList<String> viewDenunceList();
    
    public ArrayList<String> suspendUser(String username, String motive);
    
    public ArrayList<String> itemRemove(String itemId);

    public ArrayList<String> reactivateUser(String username);
    
    public ArrayList<String> viewUserList(); 

    public ArrayList<String> seeUser(String username);
    
    public ArrayList<String> viewItemList();

    public ArrayList<String> seeItem(String itemId);
    
    public ArrayList<String> viewCategoryList();

    public ArrayList<String> addCategory(String name, String description);

    public ArrayList<String> changeCategory(String name, String newName, String description);

}
