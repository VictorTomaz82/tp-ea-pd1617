package usertypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import logic.Item;
import tpserver.Core;

// adaptor needed to remove the need to override all methods in usertypes
public abstract class UserTypeAdaptor implements UserType {

    Core core;

    ArrayList<String> responseToClient;

    public UserTypeAdaptor(Core core) {
        this.core = core;
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
    public ArrayList<String> askAccess(String username, String password, String name, String address) {

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
    public ArrayList<String> changeUserInformation(String username, String name, String address) {
        return null;
    }

    @Override
    public ArrayList<String> viewMessageList(String username) {
        return null;
    }

    @Override
    public ArrayList<String> viewMessage(String username, String messageId) {
        return null;
    }

    @Override
    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time) {
        return null;

    }

    @Override
    public ArrayList<String> doSale(String sellerUsername, String itemName, String categoryName, String description, int startPrice, int buyout) {
        return null;

    }

    @Override
    public ArrayList<String> viewUserItemsList(String username) {
        return null;
    }

    @Override
    public ArrayList<String> viewSellingItemList() {
        return null;
    }

    @Override
    public ArrayList<String> viewBiddedItemList(String username) {
        return null;
    }

    @Override
    public ArrayList<String> viewWonItemList(String username) {
        return null;
    }

    @Override
    public ArrayList<String> viewFollowedItemList(String username) {
        return null;
    }

    @Override
    public ArrayList<String> follow(String username, String itemId) {
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
    public ArrayList<String> denunceUser(String username, String motive) {
        return null;
    }

    @Override
    public ArrayList<String> viewUserBalance(String username) {
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

    @Override
    public ArrayList<String> viewDenunceList() {
        return null;
    }

    @Override
    public ArrayList<String> suspendUser(String username, String motive) {
        return null;
    }

    @Override
    public ArrayList<String> itemRemove(String itemId) {
        return null;
    }

    @Override
    public ArrayList<String> reactivateUser(String username) {
        return null;
    }

    @Override
    public ArrayList<String> viewUserList() {
        return null;
    }

    @Override
    public ArrayList<String> seeUser(String username) {
        return null;
    }

    @Override
    public ArrayList<String> viewItemList() {
        return null;
    }

    @Override
    public ArrayList<String> seeItem(String itemId) {
        return null;
    }

    @Override
    public ArrayList<String> viewCategoryList() {
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
