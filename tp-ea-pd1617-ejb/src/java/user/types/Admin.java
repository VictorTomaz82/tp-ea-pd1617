package user.types;

//ToDo: implement functions
import java.util.ArrayList;
import java.util.Date;
import logic.Category;
import logic.Item;
import logic.Message;
import logic.Newsletter;
import logic.Response;
import logic.Suspension;
import logic.User;

public class Admin extends UserTypeAdaptor {

    @Override
    public ArrayList<String> changeCategory(String name, String newName, String description) {
        responseToClient.clear();

        ArrayList<Category> categories = core.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equalsIgnoreCase(name)) {
                categories.get(i).setName(newName);
                categories.get(i).setDescription(description);
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
        ArrayList<Category> categories = core.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equalsIgnoreCase(name)) {
                responseToClient.add(Response.CATEGORY.toString() + name + Response.EXISTS.toString());
                return responseToClient;
            }
        }
        categories.add(new Category(name, description));
        core.setCategories(categories);
        responseToClient.add(Response.CATEGORY_CHANGED.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> seeItem(String itemId) {
        responseToClient.clear();

        ArrayList<Item> items = core.getItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemId() == Integer.parseInt(itemId)) {
                responseToClient.add(items.get(i).toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.ITEM.toString() + itemId + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> seeUser(String username) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                responseToClient.add(users.get(i).toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.USER.toString()+ username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> reactivateUser(String username) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                if (!users.get(i).isActive()) {
                    users.get(i).setActive(true);
                    newsletter = core.getNewsletter();
                    newsletter.accountReactivation(username);
                    core.setNewsletter(newsletter);
                    responseToClient.add(Response.USER_REACTIVATED.toString());
                    return responseToClient;
                } else {
                    responseToClient.add(Response.USER_ALREADY_ACTIVE.toString());
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.USER.toString()+ username + Response.NEXIST.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> suspendUser(String username, String motive) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        ArrayList<Suspension> suspensions;
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                if (!users.get(i).isActive()) {
                    if (users.get(i).getSuspensions().isEmpty()) {
                        responseToClient.add(Response.USER_NEVER_ACTIVATED.toString());
                        return responseToClient;
                    } else {
                        responseToClient.add(Response.USER_ALREADY_SUSPENDED.toString());
                        return responseToClient;
                    }
                } else {
                    users.get(i).setActive(false);
                    suspensions = users.get(i).getSuspensions();
                    suspensions.add(new Suspension(motive, new Date()));
                    users.get(i).setSuspensions(suspensions);
                    core.setUsers(users);
                    newsletter = core.getNewsletter();
                    newsletter.adminSuspendAccount(username, motive);
                    core.setNewsletter(newsletter);
                    responseToClient.add(Response.USER_SUSPENDED.toString());
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
        return responseToClient;
    }

//    @Override
//    public ArrayList<String> unactivate(String username) {
//        responseToClient.clear();
//        ArrayList<User> users = core.getUsers();
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
//                if (users.get(i).isActive()) {
//                    users.get(i).setActive(false);
//                    responseToClient.add(Response.USER_SUSPENDED.toString());
//                    return responseToClient;
//                } else {
//                    responseToClient.add(Response.USER_NACTIVE.toString());
//                    return responseToClient;
//                }
//            }
//        }
//        responseToClient.add(Response.USER.toString() + username + Response.NEXIST.toString());
//        return responseToClient;
//    }

    @Override
    public ArrayList<String> messageUser(String senderUsername, String recipientUsername, String title, String body, Date time) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        ArrayList<Message> messages;
        User sender = null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(senderUsername)) {
                sender = users.get(i);
            }
        }
        if (sender == null) {
            responseToClient.add(Response.USER.toString() + senderUsername + Response.NEXIST.toString());
            return responseToClient;
        }

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(recipientUsername)) {
                if (!users.get(i).isActive()) {
                    responseToClient.add(Response.USER_NACTIVE.toString());
                    return responseToClient;
                } else {
                    messages = users.get(i).getInbox();
                    messages.add(new Message(sender, users.get(i), title, body, new Date()));
                    users.get(i).setInbox(messages);
                    core.setUsers(users);
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
        ArrayList<User> users = core.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username) && users.get(i).isAdministrator()) {
                users.get(i).setPassword(password);
                core.setUsers(users);
                responseToClient.add(Response.PASSWORD_CHANGED.toString());
                return responseToClient;
            }
        }
        // check this!
        responseToClient.add(Response.LOGIN_FAIL.toString());
        return responseToClient;
    }

}
