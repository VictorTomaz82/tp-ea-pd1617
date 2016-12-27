package user.types;

//ToDo: implement functions
import java.util.ArrayList;
import java.util.Date;
import logic.Category;
import logic.Item;
import logic.Message;
import logic.Newsletter;
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
                responseToClient.add("The category was successfully changed.");
                break;
            }
        }

        if (responseToClient.isEmpty()) {
            responseToClient.add("The category \"" + name + "\" doesn't exist.");
        }

        return responseToClient;
    }

    @Override
    public ArrayList<String> addCategory(String name, String description) {
        responseToClient.clear();
        ArrayList<Category> categories = core.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equalsIgnoreCase(name)) {
                responseToClient.add("The category \"" + name + "\" already exists.");
                return responseToClient;
            }
        }
        categories.add(new Category(name, description));
        core.setCategories(categories);
        responseToClient.add("The category was successfully added.");
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
        responseToClient.add("The item \"" + itemId + "\" doesn't exist.");
        return responseToClient;
    }

    @Override
    public ArrayList<String> seeUser(String userId) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(userId)) {
                responseToClient.add(users.get(i).toString());
                return responseToClient;
            }
        }
        responseToClient.add("The user \"" + userId + "\" doesn't exist.");
        return responseToClient;
    }

    @Override
    public ArrayList<String> reactivateUser(String userId) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(userId)) {
                if (!users.get(i).isActive()) {
                    users.get(i).setActive(true);
                    newsletter = core.getNewsletter();
                    newsletter.accountReactivation(userId);
                    core.setNewsletter(newsletter);
                    responseToClient.add("The user was successfully reactivated.");
                    return responseToClient;
                } else {
                    responseToClient.add("The user is already active.");
                    return responseToClient;
                }
            }
        }
        responseToClient.add("The user \"" + userId + "\" doesn't exist.");
        return responseToClient;
    }

    @Override
    public ArrayList<String> suspendUser(String userId, String motive) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        ArrayList<Suspension> suspensions;
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(userId)) {
                if (!users.get(i).isActive()) {
                    if (users.get(i).getSuspensions().isEmpty()) {
                        responseToClient.add("The user was never activated.");
                        return responseToClient;
                    } else {
                        responseToClient.add("The user is already suspended.");
                        return responseToClient;
                    }
                } else {
                    users.get(i).setActive(false);
                    suspensions = users.get(i).getSuspensions();
                    suspensions.add(new Suspension(motive, new Date()));
                    users.get(i).setSuspensions(suspensions);
                    core.setUsers(users);
                    newsletter = core.getNewsletter();
                    newsletter.adminSuspendAccount(userId, motive);
                    core.setNewsletter(newsletter);
                    responseToClient.add("The user was successfully suspended.");
                    return responseToClient;
                }
            }
        }
        responseToClient.add("The user \"" + userId + "\" doesn't exist.");
        return responseToClient;
    }

    @Override
    public ArrayList<String> unactivate(String userId) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(userId)) {
                if (users.get(i).isActive()) {
                    users.get(i).setActive(false);
                    responseToClient.add("The user was successfully suspended.");
                    return responseToClient;
                } else {
                    responseToClient.add("The user isn't active.");
                    return responseToClient;
                }
            }
        }
        responseToClient.add("The user \"" + userId + "\" doesn't exist.");
        return responseToClient;
    }

    @Override
    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        ArrayList<Message> messages;
        User sender = null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(senderId)) {
                sender = users.get(i);
            }
        }
        if (sender == null) {
            responseToClient.add("The sender user \"" + senderId + "\" doesn't exist.");
            return responseToClient;
        }

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(recipientId)) {
                if (!users.get(i).isActive()) {
                    responseToClient.add("The user isn't active.");
                    return responseToClient;
                } else {
                    messages = users.get(i).getInbox();
                    messages.add(new Message(sender, users.get(i), title, body, new Date()));
                    users.get(i).setInbox(messages);
                    core.setUsers(users);
                    responseToClient.add("The message was successfully sent");
                    return responseToClient;
                }
            }
        }
        responseToClient.add("The user \"" + recipientId + "\" doesn't exist.");
        return responseToClient;
    }

    @Override
    public ArrayList<String> changePassword(String username, String password, String confirmPassword) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(username) && users.get(i).isAdministrator()) {
                users.get(i).setPassword(password);
                core.setUsers(users);
                responseToClient.add("The password was successfully changed.");
                return responseToClient;
            }
        }
        responseToClient.add("Username or password is incorrect.");
        return responseToClient;
    }

}
