package usertypes;

import java.util.ArrayList;
import logic.News;
import logic.Response;
import logic.User;
import tpserver.Core;

public class Visitor extends UserTypeAdaptor {

    public Visitor(Core core) {
        super(core);
    }

    // --- Methods ---
    @Override
    public ArrayList<String> askReactivation(String username, String password) {
        responseToClient.clear();
        News news = new News();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username) && core.getUsers().get(i).getPassword().equals(password) && !core.getUsers().get(i).isActive()) {
                news.accountReactivation(username);
                core.getNewsletter().add(0, news);
                responseToClient.add(Response.ASK_REACTIVATION_SENT.toString());
                return responseToClient;
            }
        }
        responseToClient.add(Response.LOGIN_FAIL.toString());
        return responseToClient;
    }

    @Override
    public ArrayList<String> askAccess(String username, String password, String name, String address) {
        responseToClient.clear();
        News news = new News();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)) {
                responseToClient.add(Response.USER_ALREDY_EXISTS.toString());
                return responseToClient;
            }
        }
        core.getUsers().add(new User(username, password, name, address));
        news.newAccount(username);
        core.getNewsletter().add(0, news);
        responseToClient.add(Response.ASK_ACCOUNT_SENT.toString());
        return responseToClient;
    }
}
