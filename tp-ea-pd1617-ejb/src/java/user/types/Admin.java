package user.types;

import java.util.ArrayList;
import java.util.Date;
import logic.Category;
import logic.Response;
import logic.Suspension;
import logic.User;
import logic.Message;
import logic.ReportItem;
import logic.ReportUser;
import tpserver.Core;

public class Admin extends UserTypeAdaptor {

    public Admin(Core core) {
        super(core);
    }

    // --- Methods ---
    @Override
    public ArrayList<String> changeCategory(String name, String newName, String description) {
        responseToClient.clear();

        for (int i = 0; i < core.getCategories().size(); i++) {
            if (core.getCategories().get(i).getName().equalsIgnoreCase(name)) {
                core.getCategories().get(i).setName(newName);
                core.getCategories().get(i).setDescription(description);
                responseToClient.add(Response.CATEGORY_CHANGED.toString());
                break;
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.CATEGORY.toString() + name + Response.NEXIST.toString());
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> addCategory(String name, String description) {
        responseToClient.clear();
        for (int i = 0; i < core.getCategories().size(); i++) {
            if (core.getCategories().get(i).getName().equalsIgnoreCase(name)) {
                responseToClient.add(Response.CATEGORY.toString() + name + Response.EXISTS.toString());
                return responseToClient;
            }
        }
        core.getCategories().add(new Category(name, description));
        responseToClient.add(Response.CATEGORY_CHANGED.toString());
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

    @Override
    public ArrayList<String> seeItem(String itemId) {
        responseToClient.clear();

        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).getItemId() == Integer.parseInt(itemId)) {
                responseToClient.add(core.getItems().get(i).toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> viewItemList() {
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
    public ArrayList<String> seeUser(String username) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                responseToClient.add(core.getUsers().get(i).toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> viewUserList() {
        responseToClient.clear();

        for (int i = 0; i < core.getUsers().size(); i++) {
            responseToClient.add(core.getUsers().get(i).getGenericInformation());
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }
        return responseToClient;
    }

    @Override
    public ArrayList<String> reactivateUser(String username) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                if (!core.getUsers().get(i).isActive()) {
                    core.getUsers().get(i).setActive(true);
                    if (core.getUsers().get(i).getSuspensions().isEmpty()) {
                        core.getNewsletter().newAccountActivated(username);
                        responseToClient.add(Response.USER_ACTIVATE.toString());
                        return responseToClient;
                    } else {
                        core.getNewsletter().accountReactivated(username);
                        responseToClient.add(Response.USER_REACTIVATED.toString());
                        return responseToClient;
                    }
                } else {
                    responseToClient.add(Response.USER_ALREADY_ACTIVE.toString());
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> itemRemove(String itemId) {
        responseToClient.clear();

        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).getItemId() == Integer.parseInt(itemId)) {
                core.getItems().remove(i);
                responseToClient.add(Response.ITEM.toString() + itemId + Response.ITEM_REMOVED.toString());
                return responseToClient;
            }
        }

        responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> suspendUser(String username, String motive) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                if (!core.getUsers().get(i).isActive()) {
                    if (core.getUsers().get(i).getSuspensions().isEmpty()) {
                        responseToClient.add(Response.USER_NEVER_ACTIVATED.toString());
                        return responseToClient;
                    } else {
                        responseToClient.add(Response.USER_ALREADY_SUSPENDED.toString());
                        return responseToClient;
                    }
                } else {
                    core.getUsers().get(i).setActive(false);
                    core.getUsers().get(i).getSuspensions().add(new Suspension(motive, new Date()));
                    core.getNewsletter().adminSuspendAccount(username, motive);
                    responseToClient.add(Response.USER_SUSPENDED.toString());
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> viewDenunceList() {
        responseToClient.clear();

        responseToClient.add(Response.DENUNCE_USER.toString());
        for (int i = 0; i < core.getReports().size(); i++) {
            if (core.getReports().get(i) instanceof ReportUser) {
                responseToClient.add(core.getReports().get(i).toString());
            }
        }
        responseToClient.add(Response.DENUNCE_ITEM.toString());
        for (int i = 0; i < core.getReports().size(); i++) {
            if (core.getReports().get(i) instanceof ReportItem) {
                responseToClient.add(core.getReports().get(i).toString());
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add(Response.NOTHING.toString());
        }
        return responseToClient;
    }

    @Override
    public ArrayList<String> messageUser(String senderUsername, String recipientUsername, String title, String body, Date time) {
        responseToClient.clear();
        User sender = null;

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(senderUsername)) {
                sender = core.getUsers().get(i);
            }
        }
        if (sender == null) {
            responseToClient.add(Response.USER.toString() + senderUsername + Response.NEXIST.toString());
            return responseToClient;
        }

        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(recipientUsername)) {
                if (!core.getUsers().get(i).isActive()) {
                    responseToClient.add(Response.USER_NACTIVE.toString());
                    return responseToClient;
                } else {
                    core.getMessages().add(0, new Message(sender, core.getUsers().get(i), title, body, new Date()));
                    core.getUsers().get(i).getMailbox().add(0, core.getMessages().get(core.getMessages().size() - 1).getMessageId());
                    responseToClient.add(Response.MESSAGE_SENT.toString());
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.USER.toString() + recipientUsername + Response.NEXIST.toString());
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
