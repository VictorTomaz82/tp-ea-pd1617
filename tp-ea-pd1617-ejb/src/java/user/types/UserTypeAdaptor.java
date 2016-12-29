package user.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.ejb.EJB;
import logic.Item;
import tpserver.Core;

// adaptor needed to remove the need to override all methods in usertypes
public class UserTypeAdaptor implements UserType {

    @EJB
    Core core;

    ArrayList<String> responseToClient;

    public UserTypeAdaptor() {
        responseToClient = new ArrayList<>();
    }

    //--- all ---
    @Override
    public ArrayList<String> seeNews() {
        return core.getNewsletter().getNews();
    }

    @Override
    public ArrayList<String> seeLastThree() {
        ArrayList<Item> itemsSold = new ArrayList<>();
        responseToClient.clear();
        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).isPayed()) {
                itemsSold.add(core.getItems().get(i));
            }
        }

        Collections.sort(itemsSold, (Item o1, Item o2) -> {
            if (o1.getBids().get(o1.getBids().size() - 1) == null || o2.getBids().get(o1.getBids().size() - 1) == null) {
                return 0;
            }
            return o1.getBids().get(o1.getBids().size() - 1).getTime().compareTo(o2.getBids().get(o1.getBids().size() - 1).getTime());
        });

        for (int i = 0; i < itemsSold.size(); i++) {
            responseToClient.add(itemsSold.get(i).toString());
            if (responseToClient.size() == 3) {
                break;
            }
        }

        return responseToClient;
    }

    //--- visitor ---
    @Override
    public ArrayList<String> askAccess(String username, String password) {

        return null;
    }

    @Override
    public ArrayList<String> askReactivation(String username, String password) {

        return null;
    }

    //--- admin & user ---
    @Override
    public ArrayList<String> changePassword(String username, String password, String newPassword, String confirmPassword) {

        return null;
    }

    @Override
    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time) {

        return null;
    }

    //--- user ---
    @Override
    public ArrayList<String> doSale(String sellerUsername, String itemName, String description, int startPrice, int buyout) {

        return null;
    }

    @Override
    public ArrayList<String> doBid(String username, String itemId, int bid) {

        return null;
    }

    @Override
    public ArrayList<String> denunceItem(String itemId, String motive) {

        return null;
    }
    
        @Override
    public ArrayList<String> denunceUser(String username,  String motive) {

        return null;
    }

    @Override
    public ArrayList<String> follow(String username, String itemId) {

        return null;
    }
    
        @Override
    public ArrayList<String> addBalance(String username, int money) {

        return null;
    }

    @Override
    public ArrayList<String> payItem(String username, String itemId) {

        return null;
    }



    @Override
    public ArrayList<String> askSuspension(String username, String motive) {

        return null;
    }

//    @Override
//    public ArrayList<String> unactivate(String userId) {
//
//        return null;
//    }

    @Override
    public ArrayList<String> suspendUser(String username, String motive) {

        return null;
    }

    @Override
    public ArrayList<String> reactivateUser(String username) {

        return null;
    }

    @Override
    public ArrayList<String> seeUser(String username) {

        return null;
    }

    @Override
    public ArrayList<String> seeItem(String itemId) {

        return null;
    }

    @Override
    public ArrayList<String> addCategory(String name, String description) {

        return null;
    }

    @Override
    public ArrayList<String> changeCategory(String name, String newName, String description) {

        return null;
    }

}
