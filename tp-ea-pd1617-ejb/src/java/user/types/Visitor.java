package user.types;

//ToDo: implement functions
import java.util.ArrayList;
import logic.Newsletter;
import logic.Response;
import logic.User;

public class Visitor extends UserTypeAdaptor {

    @Override
    public ArrayList<String> askReactivation(String username, String password) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username) && users.get(i).getPassword().equals(password) && !users.get(i).isActive()) {
                newsletter = core.getNewsletter();
                newsletter.accountReactivation(username);
                core.setNewsletter(newsletter);
                responseToClient.add(Response.ASK_REACTIVATION_SENT.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.LOGIN_FAIL.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> askAccess(String username, String password) {
        responseToClient.clear();
        ArrayList<User> users = core.getUsers();
        Newsletter newsletter;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                responseToClient.add(Response.USER_ALREDY_EXISTS.toString());
                return responseToClient;
            }
        }
//        if (password.equals(confirmPassword)) {
            users.add(new User(username, password));
            newsletter = core.getNewsletter();
            newsletter.newAccount(username);
            core.setNewsletter(newsletter);
            responseToClient.add(Response.ASK_ACCOUNT_SENT.toString());
            return responseToClient;
//        }

//        responseToClient.add("Password does not match the confirm password.");
//        return responseToClient;
    }
}
