package user.types;

import java.util.Date;
import javax.ejb.EJB;
import tpserver.Core;

// adaptor needed to remove the need to override all methods in usertypes
public class UserTypeAdaptor implements UserType {
    
    @EJB
    Core core;

    //--- all ---
    @Override
    public String seeNews() {

        //ToDo: implement function here
        return null;
    }

    @Override
    public String seeLastThree() {

        //ToDo: implement function here
        return null;
    }

    //--- visitor ---
    @Override
    public void askAccess(String username, String password, String confirmpassword) {

    }

    @Override
    public void askReactivation(String username, String password) {

    }

    //--- admin & user ---
    @Override
    public void changePassword(String username, String password, String confirmpassword) {

    }

    @Override
    public void messageUser(String senderId, String recipientId, String title, String body, Date time) {

    }

    //--- user ---
    @Override
    public void doSale(String name, String description, String sellerId, int startPrice) {

    }

    @Override
    public void doBid(String itemId) {

    }

    @Override
    public void denunce(String userId, String itemId, String motive) {

    }

    @Override
    public void follow(String itemId) {

    }

    @Override
    public void payItem(String itemId) {

    }

    @Override
    public void addBalance(int money) {

    }

    @Override
    public void askSuspension(String userId, String motive) {

    }

    @Override
    public void unactivate(String userId) {

    }

    @Override
    public void suspendUser(String userId, String motive) {

    }

    @Override
    public void reactivateUser(String userId) {

    }

    @Override
    public void seeUser(String userId) {

    }

    @Override
    public void seeItem(String itemId) {

    }

    @Override
    public void addCategory(String name, String description) {

    }

    @Override
    public void changeCategory(String name, String newName, String description) {

    }

}
