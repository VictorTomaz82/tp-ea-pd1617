package user.types;

//ToDo: implement functions
import java.util.ArrayList;
import java.util.Date;
import logic.Bid;
import logic.Item;
import logic.Message;
import logic.ReportItem;
import logic.ReportUser;
import logic.Response;
import logic.User;

public class NormalUser extends UserTypeAdaptor {

    @Override
    public ArrayList<String> askSuspension(String username, String motive) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                core.getNewsletter().userSuspendAccount(username, motive);
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
    public ArrayList<String> payItem(String username, String itemId) {
        responseToClient.clear();
        //validate: only pay for items won buy user
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
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                if (core.getUsers().get(i).getBalance() - item.getBids().get(item.getBids().size() - 1).getValue() < 0) {
                    responseToClient.add(Response.INSUFICIENT_BALANCE.toString());
                    return responseToClient;
                } else {
                    core.getUsers().get(i).setBalance(core.getUsers().get(i).getBalance() - item.getBids().get(item.getBids().size() - 1).getValue());

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
        if (item.getBids().get(0).getValue() >= bid) {
            responseToClient.add(Response.ITEM_LOW_BID1.toString() + item.getBids().get(0).getValue() + Response.ITEM_LOW_BID2.toString());
            return responseToClient;
        }
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                for (int j = 0; j < core.getItems().size(); j++) {
                    if (core.getItems().get(j).getItemId() == Integer.parseInt(itemId)) {
                        core.getUsers().get(i).getLastBids().add(0, new Bid(Integer.parseInt(itemId), core.getUsers().get(i), bid, new Date()));
                        core.getItems().get(j).getBids().add(0, new Bid(Integer.parseInt(itemId), core.getUsers().get(i), bid, new Date()));
                        responseToClient.add(Response.ITEM_BID_SUCCESS.toString());
                        if(core.getItems().get(j).getBuyout() <= bid){
                            core.getItems().get(j).setClosed(true);
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
    public ArrayList<String> doSale(String sellerUsername, String itemName, String description, int startPrice, int buyout) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(sellerUsername)) {
                core.getItems().add(new Item(itemName, description, sellerUsername, startPrice, buyout));
                core.getUsers().get(i).getSales().add(core.getItems().get(core.getItems().size() - 1).getItemId());
                responseToClient.add(Response.ITEM.toString() + core.getItems().get(core.getItems().size() - 1).getItemId() + Response.ITEM_SUCCESS.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + sellerUsername + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time) {
        responseToClient.clear();
        User sender = null;

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(senderId)) {
                sender = core.getUsers().get(i);
            }
        }
        if (sender == null) {
            responseToClient.add(Response.USER.toString() + senderId + Response.NEXIST.toString());
            return responseToClient;
        }

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(recipientId)) {
                if (!core.getUsers().get(i).isActive()) {
                    responseToClient.add(Response.USER_NACTIVE.toString());
                    return responseToClient;
                } else {
                    core.getMessages().add(new Message(sender, core.getUsers().get(i), title, body, new Date()));
                    core.getUsers().get(i).getMailbox().add(core.getMessages().get(core.getMessages().size() - 1).getMessageId());
                    responseToClient.add(Response.MESSAGE_SENT.toString());
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.USER.toString() + recipientId + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> changePassword(String username, String password, String newPassword, String confirmPassword) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username) && core.getUsers().get(i).getPassword().equals(password) && newPassword.equals(confirmPassword)) {
                core.getUsers().get(i).setPassword(password);
                responseToClient.add(Response.PASSWORD_CHANGED.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.LOGIN_FAIL.toString());
        return responseToClient;
    }
}
