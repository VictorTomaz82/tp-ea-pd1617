package usertypes;

import java.util.ArrayList;
import java.util.Date;
import logic.Bid;
import logic.Category;
import logic.Item;
import logic.Message;
import logic.News;
import logic.ReportItem;
import logic.ReportUser;
import logic.Response;
import logic.User;
import tpserver.Core;

public class NormalUser extends UserTypeAdaptor {

    public NormalUser(Core core) {
        super(core);
    }

    // --- Methods ---
    @Override
    public ArrayList<String> askSuspension(String username, String motive) {
        responseToClient.clear();
        News news = new News();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                news.userSuspendAccount(username, motive);
                core.getNewsletter().add(0, news);
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
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                core.getUsers().get(i).setBalance(core.getUsers().get(i).getBalance() + money);
                responseToClient.add(Response.BALANCE_ADDED1.toString() + money + Response.BALANCE_ADDED2.toString() + Response.BALANCE1.toString() + core.getUsers().get(i).getBalance() + Response.BALANCE2.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> viewUserBalance(String username) {
        responseToClient.clear();

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                responseToClient.add(Response.BALANCE1.toString() + core.getUsers().get(i).getBalance() + Response.BALANCE2.toString());
                return responseToClient;
            }
        }

        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> payItem(String username, String itemId) {
        responseToClient.clear();
        Item item = null;
        
        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).getItemId() == Integer.parseInt(itemId)) {
                item = core.getItems().get(i);
                break;
            }
        }
        if (item == null) {
            responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
            return responseToClient;
        }
        if (item.isPayed()) {
            responseToClient.add(Response.INSUFICIENT_BALANCE.toString() + itemId + Response.ITEM_ALREADY_PAYED.toString());
            return responseToClient;
        }
        if(!item.getBids().get(0).getUsername().equalsIgnoreCase(username)){
            responseToClient.add(Response.ITEM.toString() + itemId + Response.ITEM_NWON.toString());
            return responseToClient;
        }
        
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                if (core.getUsers().get(i).getBalance() - item.getBids().get(0).getValue() < 0) {
                    responseToClient.add(Response.INSUFICIENT_BALANCE.toString());
                    return responseToClient;
                }
                core.getUsers().get(i).setBalance(core.getUsers().get(i).getBalance() - item.getBids().get(0).getValue());
                for (int j = 0; j < core.getUsers().get(i).getWon().size(); j++) {
                    if (core.getUsers().get(i).getWon().get(j) == Integer.parseInt(itemId)) {
                        core.getUsers().get(i).getWon().remove(j);
                        break;
                    }
                }
                for (int j = 0; j < core.getItems().size(); i++) {
                    if (core.getItems().get(j).getItemId() == Integer.parseInt(itemId)) {
                        core.getItems().get(j).setPayed(true);
                        break;
                    }
                }
                responseToClient.add(Response.ITEM.toString() + itemId + Response.ITEM_PAY.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> denunceItem(String itemId, String motive) {
        responseToClient.clear();
        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).getItemId() == Integer.parseInt(itemId)) {
                core.getReports().add(new ReportItem(Integer.parseInt(itemId), motive));
                responseToClient.add(Response.DENUNCE_SUCCESS.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> denunceUser(String username, String motive) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                core.getReports().add(new ReportUser(core.getUsers().get(i).getUserId(), motive));
                responseToClient.add(Response.DENUNCE_SUCCESS.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> doBid(String username, String itemId, int bid) {
        responseToClient.clear();
        Item item = null;
        News news = new News();
        
        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).getItemId() == Integer.parseInt(itemId)) {
                item = core.getItems().get(i);
                break;
            }
        }
        if (item == null) {
            responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
            return responseToClient;
        }
        if (item.isClosed()) {
            responseToClient.add(Response.ITEM_CLOSED.toString());
            return responseToClient;
        }
        if (item.getBids().isEmpty() && item.getStartPrice() >= bid) {
            responseToClient.add(Response.ITEM_LOW_BID1.toString() + item.getBids().get(0).getValue() + Response.ITEM_LOW_BID2.toString());
            return responseToClient;
        }
        if (!item.getBids().isEmpty() && item.getBids().get(0).getValue() >= bid) {
            responseToClient.add(Response.ITEM_LOW_BID1.toString() + item.getBids().get(0).getValue() + Response.ITEM_LOW_BID2.toString());
            return responseToClient;
        }
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                for (int j = 0; j < core.getItems().size(); j++) {
                    if (core.getItems().get(j).getItemId() == Integer.parseInt(itemId)) {
                        core.getUsers().get(i).getLastBids().add(0, new Bid(Integer.parseInt(itemId), core.getUsers().get(i).getUsername(), bid, new Date()));
                        core.getItems().get(j).getBids().add(0, new Bid(Integer.parseInt(itemId), core.getUsers().get(i).getUsername(), bid, new Date()));
                        responseToClient.add(Response.ITEM_BID_SUCCESS.toString());
                        if (core.getItems().get(j).getBuyout() <= bid) {
                            core.getItems().get(j).setClosed(true);
                            core.getUsers().get(i).getWon().add(core.getItems().get(j).getItemId());
                            news.itemSold(username, item.getItemName(), bid);
                            core.getNewsletter().add(0, news);
                            responseToClient.add(Response.ITEM_WON.toString());
                        }
                        return responseToClient;
                    }
                }
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> follow(String username, String itemId) {
        responseToClient.clear();
        Item item = null;
        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).getItemId() == Integer.parseInt(itemId)) {
                item = core.getItems().get(i);
                break;
            }
        }
        if (item == null) {
            responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
            return responseToClient;
        }
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                for (int j = 0; j < core.getUsers().get(i).getFollowed().size(); j++) {
                    if (core.getUsers().get(i).getFollowed().get(j) == Integer.parseInt(itemId)) {
                        responseToClient.add(Response.ITEM.toString() + itemId + Response.ITEM_ALREADY_FOLLOWING.toString());
                        return responseToClient;
                    }
                }
                core.getUsers().get(i).getFollowed().add(Integer.parseInt(itemId));
                responseToClient.add(Response.ITEM.toString() + itemId + Response.ITEM_FOLLOW_ADD.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> viewFollowedItemList(String username) {
        responseToClient.clear();
        ArrayList<Integer> idItems = new ArrayList<>();

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                idItems = core.getUsers().get(i).getFollowed();
                break;
            }
        }

        for (int i = 0; i < core.getItems().size(); i++) {
            for (int j = 0; j < idItems.size(); j++) {
                if (core.getItems().get(i).getItemId() == idItems.get(j)) {
                    responseToClient.add(core.getItems().get(i).getGenericInformation());
                    break;
                }
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> viewWonItemList(String username) {
        responseToClient.clear();
        ArrayList<Integer> idItems = new ArrayList<>();

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                idItems = core.getUsers().get(i).getWon();
                break;
            }
        }

        for (int i = 0; i < core.getItems().size(); i++) {
            for (int j = 0; j < idItems.size(); j++) {
                if (core.getItems().get(i).getItemId() == idItems.get(j)) {
                    responseToClient.add(core.getItems().get(i).getGenericInformation());
                    break;
                }
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> viewBiddedItemList(String username) {
        responseToClient.clear();
        ArrayList<Integer> idItems = new ArrayList<>();

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                for (int j = 0; j < core.getUsers().get(i).getLastBids().size(); j++) {
                    if (idItems.isEmpty()) {
                        idItems.add(core.getUsers().get(i).getLastBids().get(j).getItemId());
                    } else {
                        for (int k = 0; k < idItems.size(); k++) {
                            if (idItems.get(i) == core.getUsers().get(i).getLastBids().get(j).getItemId()) {
                                break;
                            }
                            if (k == idItems.size() - 1) {
                                idItems.add(core.getUsers().get(i).getLastBids().get(j).getItemId());
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }

        for (int i = 0; i < core.getItems().size(); i++) {
            for (int j = 0; j < idItems.size(); j++) {
                if (core.getItems().get(i).getItemId() == idItems.get(j)) {
                    responseToClient.add(core.getItems().get(i).getGenericInformation());
                    break;
                }
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> viewSellingItemList() {
        responseToClient.clear();

        for (int i = 0; i < core.getItems().size(); i++) {
            responseToClient.add(core.getItems().get(i).getGenericInformation());
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> viewUserItemsList(String username) {
        responseToClient.clear();

        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).getSellerUsername().equalsIgnoreCase(username)) {
                responseToClient.add(core.getItems().get(i).getGenericInformation());
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> doSale(String sellerUsername, String itemName, String categoryName, String description, int startPrice, int buyout) {
        responseToClient.clear();
        Category tmpCategory = null;

        for (int i = 0; i < core.getCategories().size(); i++) {
            if (core.getCategories().get(i).getName().equalsIgnoreCase(categoryName)) {
                tmpCategory = core.getCategories().get(i);
            }
        }

        if (tmpCategory == null) {
            responseToClient.add(Response.CATEGORY.toString() + categoryName + Response.NEXIST.toString());
            return responseToClient;
        }

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(sellerUsername)) {
                core.getItems().add(0, new Item(itemName, description, tmpCategory.getName(), sellerUsername, startPrice, buyout));
                core.getUsers().get(i).getSales().add(core.getItems().get(0).getItemId());
                responseToClient.add(Response.ITEM.toString() + core.getItems().get(0).getItemId() + Response.ITEM_SUCCESS.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + sellerUsername + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> messageUser(String senderUsername, String recipientUsername, String title, String body, Date time) {
        responseToClient.clear();

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(recipientUsername)) {
                if (!core.getUsers().get(i).isActive()) {
                    responseToClient.add(Response.USER_NACTIVE.toString());
                    return responseToClient;
                } else {
                    core.getMessages().add(0, new Message(senderUsername, core.getUsers().get(i).getUsername(), title, body, new Date()));
                    core.getUsers().get(i).getMailbox().add(0, core.getMessages().get(0).getMessageId());
                    responseToClient.add(Response.MESSAGE_SENT.toString());
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.USER.toString() + recipientUsername + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> viewMessage(String username, String messageId) {
        responseToClient.clear();

        for (int i = 0; i < core.getMessages().size(); i++) {
            if (core.getMessages().get(i).getMessageId() == Integer.parseInt(messageId) && core.getMessages().get(i).getRecipient().equalsIgnoreCase(username)) {
                responseToClient.add(core.getMessages().get(i).toString());
                return responseToClient;
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.MESSAGE_NOWNER.toString());
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> viewMessageList(String username) {
        responseToClient.clear();

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                if (core.getUsers().get(i).getMailbox().isEmpty()) {
                    responseToClient.add(Response.NOTHING.toString());
                    return responseToClient;
                } else {
                    for (int j = 0; j < core.getMessages().size(); j++) {
                        if (core.getMessages().get(j).getRecipient().equalsIgnoreCase(username)) {
                            responseToClient.add(core.getMessages().get(j).getGenericInformation());
                        }
                    }
                    return responseToClient;
                }
            }
        }

        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> changeUserInformation(String username, String name, String address) {
        responseToClient.clear();

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                core.getUsers().get(i).setName(name);
                core.getUsers().get(i).setAddress(address);

                responseToClient.add(Response.USER_INFORMATION_CHANGED.toString());
                return responseToClient;
            }
        }

        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> changePassword(String username, String password, String newPassword, String confirmPassword) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username) && core.getUsers().get(i).getPassword().equals(password) && newPassword.equals(confirmPassword)) {
                core.getUsers().get(i).setPassword(newPassword);
                responseToClient.add(Response.PASSWORD_CHANGED.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.LOGIN_FAIL.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> viewCategoryList() {
        responseToClient.clear();

        for (int i = 0; i < core.getCategories().size(); i++) {
            responseToClient.add(core.getCategories().get(i).toString());
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }

        return responseToClient;
    }

}
