package user.types;

//ToDo: implement functions
import java.util.ArrayList;
import logic.Response;
import logic.User;

public class Visitor extends UserTypeAdaptor {

    @Override
    public ArrayList<String> askReactivation(String username, String password) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username) && core.getUsers().get(i).getPassword().equals(password) && !core.getUsers().get(i).isActive()) {
                core.getNewsletter().accountReactivation(username);
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
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                responseToClient.add(Response.USER_ALREDY_EXISTS.toString());
                return responseToClient;
            }
        }
            core.getUsers().add(new User(username, password));
            core.getNewsletter().newAccount(username);
            responseToClient.add(Response.ASK_ACCOUNT_SENT.toString());
            return responseToClient;
    }
}
