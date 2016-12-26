package user.types;

//ToDo: implement functions

import java.util.Date;

public class Admin extends UserTypeAdaptor{

    @Override
    public void changeCategory(String name, String newName, String description) {

    }

    @Override
    public void addCategory(String name, String description) {

    }

    @Override
    public void seeItem(String itemId) {

    }

    @Override
    public void seeUser(String userId) {

    }

    @Override
    public void reactivateUser(String userId) {
 
    }

    @Override
    public void suspendUser(String userId, String motive) {

    }

    @Override
    public void unactivate(String userId) {

    }

    @Override
    public void messageUser(String senderId, String recipientId, String title, String body, Date time) {

    }

    @Override
    public void changePassword(String username, String password, String confirmpassword) {

    }

}
