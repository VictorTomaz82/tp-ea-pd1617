package user.types;

//ToDo: implement functions

import java.util.Date;

public class NormalUser extends UserTypeAdaptor{

    @Override
    public void askSuspension(String userId, String motive) {
        
    }

    @Override
    public void addBalance(int money) {
        
    }

    @Override
    public void payItem(String itemId) {
        
    }

    @Override
    public void follow(String itemId) {
        
    }

    @Override
    public void denunce(String userId, String itemId, String motive) {
        
    }

    @Override
    public void doBid(String itemId) {
        
    }

    @Override
    public void doSale(String name, String description, String sellerId, int startPrice) {
        
    }

    @Override
    public void messageUser(String senderId, String recipientId, String title, String body, Date time) {
        
    }

    @Override
    public void changePassword(String username, String password, String confirmpassword) {
        
    }
}
