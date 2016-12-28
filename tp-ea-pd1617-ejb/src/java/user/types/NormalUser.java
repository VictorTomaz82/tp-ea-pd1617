package user.types;

//ToDo: implement functions

import java.util.ArrayList;
import java.util.Date;
import logic.Newsletter;
import logic.Response;
import logic.User;

public class NormalUser extends UserTypeAdaptor{

    @Override
    public ArrayList<String> askSuspension(String username, String motive) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                newsletter = core.getNewsletter();
                newsletter.userSuspendAccount(username, motive);
                core.setNewsletter(newsletter);
                responseToClient.add(Response.ASK_SUSPENSION_SENT.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> addBalance(String username, int money) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                users.get(i).setBalance(users.get(i).getBalance() + money);
                core.setUsers(users);
                responseToClient.add(Response.BALANCE_ADDED1.toString() + money + Response.BALANCE_ADDED2.toString()+Response.BALANCE1.toString()+ users.get(i).getBalance() + Response.BALANCE2.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> payItem(String username, String itemId) {
        
        //validate: only pay for items won buy user
        
//        responseToClient.clear();
//        ArrayList<User> users = core.getUsers();
//        ArrayList<Item> items = core.getItems();
//        Item item;
//        
//        for(int i = 0; i < users.size(); i++){
//            for(int j = 0; j < users.get(i).)
//        
//        }
//        
//        
//        
//        
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
//                users.get(i).setBalance(users.get(i).getBalance() + money);
//                core.setUsers(users);
//                responseToClient.add("Successfully added " + money + "€ to your account.\nYou now have "+ users.get(i).getBalance() + "€ in your account.");
//                return responseToClient;
//            }
//        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> follow(String itemId) {
        responseToClient.clear();
        return responseToClient;
    }

    @Override
    public ArrayList<String> denunceItem(String itemId, String motive) {
        responseToClient.clear();
        return responseToClient;
    }
    
        @Override
    public ArrayList<String> denunceUser(String username, String motive) {
        responseToClient.clear();
        return responseToClient;
    }

    @Override
    public ArrayList<String> doBid(String itemId, int bid) {
        responseToClient.clear();
        return responseToClient;
    }

    @Override
    public ArrayList<String> doSale(String sellerUsername, String itemName, String description,  int startPrice, int buyout) {
        responseToClient.clear();
        return responseToClient;
    }

    @Override
    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time) {
        responseToClient.clear();
        return responseToClient;
    }

    @Override
    public ArrayList<String> changePassword(String username, String password, String newPassword, String confirmPassword) {
        responseToClient.clear();
        return responseToClient;
    }
}
