package user.types;

//ToDo: implement functions
import java.util.ArrayList;
import logic.Newsletter;
import logic.User;

public class Visitor extends UserTypeAdaptor {

    @Override
    public ArrayList<String> askReactivation(String username, String password) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(username) && users.get(i).getPassword().equals(password) && !users.get(i).isActive()) {
                newsletter = core.getNewsletter();
                newsletter.accountReactivation(username);
                core.setNewsletter(newsletter);
                responseToClient.add("The reactivation request was successfully sent.");
                return responseToClient;
            }
        }
        responseToClient.add("Username or password is incorrect.");
        return responseToClient;
    }

    @Override
    public ArrayList<String> askAccess(String username, String password, String confirmPassword) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(username)) {
                responseToClient.add("This username already exists.");
                return responseToClient;
            }
        }
        if (password.equals(confirmPassword)) {
            users.add(new User(username, password));
            newsletter = core.getNewsletter();
            newsletter.newAccount(username);
            core.setNewsletter(newsletter);
            responseToClient.add("Account successfully created.\nThe account still needs to be activated by the admin please wait for the activation.");
            return responseToClient;
        }

        responseToClient.add("Password does not match the confirm password.");
        return responseToClient;
    }
}
