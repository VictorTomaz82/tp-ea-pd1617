package tpserver;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import logic.Response;
import user.types.*;

@Stateful
public class Butler implements ButlerRemote {

    @EJB
    Core core;

    UserType usertype;
    ArrayList<String> responseToClient;

    @PostConstruct
    public void load() {

        //by default any user is a visitor
        usertype = new Visitor();
        responseToClient = new ArrayList();
    }

    //only "true" function of butler
    @Override
    public ArrayList<String> login(String username, String password) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUserId().equalsIgnoreCase(username)
                    && core.getUsers().get(i).getPassword().equals(password)
                    && core.getUsers().get(i).isActive()) {
                
                if (core.getUsers().get(i).isAdministrator()) {
                    usertype = new Admin();
                    responseToClient.add(Response.LOGIN_SUCCESS + core.getUsers().get(i).getUserId() + ".");
                    return responseToClient;
                } else {
                    usertype = new NormalUser();
                    responseToClient.add(Response.LOGIN_SUCCESS + core.getUsers().get(i).getUserId() + ".");
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.LOGIN_FAIL.toString());
        return responseToClient;
    }

    // for every request from remote the butler will ask the interface usertype
    // to ensure user previleges are being followed
    @Override
    public ArrayList<String> seeNews() {
        return usertype.seeNews();
    }

    @Override
    public ArrayList<String> seeLastThree() {
        return usertype.seeLastThree();
    }

    @Override
    public ArrayList<String> askAccess(String username, String password) {
        return usertype.askAccess(username, password);
    }

    @Override
    public ArrayList<String> askReactivation(String username, String password) {
        return usertype.askReactivation(username, password);
    }

    @Override
    public ArrayList<String> changePassword(String username, String password, String confirmPassword) {
        return usertype.changePassword(username, password, confirmPassword);
    }

    @Override
    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time) {
        return usertype.messageUser(senderId, recipientId, title, body, time);

    }

    @Override
    public ArrayList<String> doSale(String name, String description, String sellerId, int startPrice) {
        return usertype.doSale(name, description, sellerId, startPrice);

    }

    @Override
    public ArrayList<String> follow(String itemId) {
        return usertype.follow(itemId);

    }

    @Override
    public ArrayList<String> doBid(String itemId) {
        return usertype.doBid(itemId);

    }

    @Override
    public ArrayList<String> denunce(String userId, String itemId, String motive) {

        return usertype.denunce(userId, itemId, motive);

    }

    @Override
    public ArrayList<String> addBalance(int money) {
        return usertype.addBalance(null, money);
    }

    @Override
    public ArrayList<String> payItem(String itemId) {
        return usertype.payItem(null, itemId);
    }

    @Override
    public ArrayList<String> askSuspension(String userId, String motive) {
        return usertype.askSuspension(userId, motive);
    }

    @Override
    public ArrayList<String> unactivate(String userId) {
        return usertype.unactivate(userId);
    }

    @Override
    public ArrayList<String> suspendUser(String userId, String motive) {
        return usertype.suspendUser(userId, motive);
    }

    @Override
    public ArrayList<String> reactivateUser(String userId) {
        return usertype.reactivateUser(userId);
    }

    @Override
    public ArrayList<String> seeUser(String userId) {
        return usertype.seeUser(userId);
    }

    @Override
    public ArrayList<String> seeItem(String itemId) {
        return usertype.seeItem(itemId);
    }

    @Override
    public ArrayList<String> addCategory(String name, String description) {
        return usertype.addCategory(name, description);
    }

    @Override
    public ArrayList<String> changeCategory(String name, String newName, String description) {
        return usertype.changeCategory(name, newName, description);
    }

// --- debug only (begin) ---
    @Override
    public String teste() {
        return core.teste();
    }
// --- debug only (end) ---
}
