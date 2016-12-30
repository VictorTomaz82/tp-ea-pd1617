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

    String currentUsername;
    ArrayList<String> responseToClient;

    @PostConstruct
    public void load() {

        //by default any user is a visitor
        currentUsername = Response.VISITOR.toString();
        usertype = new Visitor(core);

        responseToClient = new ArrayList();
    }

    //only "true" function of butler
    @Override
    public ArrayList<String> login(String username, String password) {
        responseToClient.clear();
        for (int i = 0; i < core.getUsers().size(); i++) {
            if (core.getUsers().get(i).getUsername().equalsIgnoreCase(username)
                    && core.getUsers().get(i).getPassword().equals(password)
                    && core.getUsers().get(i).isActive()) {

                if (core.getUsers().get(i).isAdministrator()) {
                    currentUsername = Response.ADMIN.toString();
                    usertype = new Admin(core);
                    responseToClient.add(Response.LOGIN_SUCCESS + core.getUsers().get(i).getUsername() + ".");
                    return responseToClient;
                } else {
                    currentUsername = username;
                    usertype = new NormalUser(core);
                    responseToClient.add(Response.LOGIN_SUCCESS + core.getUsers().get(i).getUsername() + ".");
                    return responseToClient;
                }
            }
        }
        responseToClient.add(Response.LOGIN_FAIL.toString());
        return responseToClient;
    }
    
    @Override
    public void logout(){
        this.load();
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
    public ArrayList<String> askAccess(String username, String password, String name, String address) {
        return usertype.askAccess(username, password, name, address);
    }

    @Override
    public ArrayList<String> askReactivation(String username, String password) {
        return usertype.askReactivation(username, password);
    }

    @Override
    public ArrayList<String> changePassword(String username, String password, String newPassword, String confirmPassword) {
        return usertype.changePassword(username, password, newPassword, confirmPassword);
    }

    @Override
    public ArrayList<String> messageUser(String senderId, String recipientId, String title, String body, Date time) {
        return usertype.messageUser(senderId, recipientId, title, body, time);

    }

    @Override
    public ArrayList<String> doSale(String sellerUsername, String itemName, String description, int startPrice, int buyout) {
        return usertype.doSale(sellerUsername, itemName, description, startPrice, buyout);

    }

    @Override
    public ArrayList<String> follow(String itemId) {
        return usertype.follow(currentUsername, itemId);

    }

    @Override
    public ArrayList<String> doBid(String itemId, int bid) {
        return usertype.doBid(currentUsername, itemId, bid);

    }

    @Override
    public ArrayList<String> denunceItem(String itemId, String motive) {

        return usertype.denunceItem(itemId, motive);

    }

    @Override
    public ArrayList<String> denunceUser(String username, String motive) {

        return usertype.denunceUser(username, motive);

    }

    @Override
    public ArrayList<String> addBalance(String username, int money) {
        return usertype.addBalance(username, money);
    }

    @Override
    public ArrayList<String> payItem(String itemId) {
        return usertype.payItem(null, itemId);
    }

    @Override
    public ArrayList<String> askSuspension(String username, String motive) {
        return usertype.askSuspension(username, motive);
    }

//    @Override
//    public ArrayList<String> unactivate(String userId) {
//        return usertype.unactivate(userId);
//    }
    @Override
    public ArrayList<String> suspendUser(String username, String motive) {
        return usertype.suspendUser(username, motive);
    }

    @Override
    public ArrayList<String> reactivateUser(String username) {
        return usertype.reactivateUser(username);
    }

    @Override
    public ArrayList<String> seeUser(String username) {
        return usertype.seeUser(username);
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

    @Override
    public String getCurrentUsername() {
        return currentUsername;
    }

//    public void setCurrentUsername(String currentUsername) {
//        this.currentUsername = currentUsername;
//    }
// --- debug only (begin) ---
//    @Override
//    public String teste() {
////        return core.teste();
//        return usertype.teste();
//    }
// --- debug only (end) ---
}
