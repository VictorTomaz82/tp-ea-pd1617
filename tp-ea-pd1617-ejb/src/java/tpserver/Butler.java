package tpserver;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import user.types.*;

@Stateful
public class Butler implements ButlerRemote {

    @EJB
    Core core;

    UserType usertype;

    @PostConstruct
    public void load() {

        //by default any user is a visitor
        usertype = new Visitor();
    }

    //only "true" function of buttler
    @Override
    public void login(String username, String password) {

        //ToDo validation of user login on core
        //change usertype from visitor to user or admin
    }

    // for every request from remote the butler will ask the interface usertype
    // to ensure user previleges are being followed
    @Override
    public String seeNews() {
        return usertype.seeNews();
    }

    @Override
    public String seeLastThree() {
        return usertype.seeLastThree();
    }

    @Override
    public void askAccess(String username, String password, String confirmPassword) {
        usertype.askAccess(username, password, confirmPassword);
    }

    @Override
    public void askReactivation(String username, String password) {
        usertype.askReactivation(username, password);
    }

    @Override
    public void changePassword(String username, String password, String confirmPassword) {
        usertype.changePassword(username, password, confirmPassword);
    }

    @Override
    public void messageUser(String senderId, String recipientId, String title, String body, Date time) {
        usertype.messageUser(senderId, recipientId, title, body, time);

    }

    @Override
    public void doSale(String name, String description, String sellerId, int startPrice) {
        usertype.doSale(name, description, sellerId, startPrice);

    }

    @Override
    public void follow(String itemId) {
        usertype.follow(itemId);

    }

    @Override
    public void doBid(String itemId) {
        usertype.doBid(itemId);

    }

    @Override
    public void denunce(String userId, String itemId, String motive) {

        usertype.denunce(userId, itemId, motive);

    }

    @Override
    public void addBalance(int money) {
        usertype.addBalance(money);
    }

    @Override
    public void payItem(String itemId) {
        usertype.payItem(itemId);
    }

    @Override
    public void askSuspension(String userId, String motive) {
        usertype.askSuspension(userId, motive);
    }

    @Override
    public void unactivate(String userId) {
        usertype.unactivate(userId);
    }

    @Override
    public void suspendUser(String userId, String motive) {
        usertype.suspendUser(userId, motive);
    }

    @Override
    public void reactivateUser(String userId) {
        usertype.reactivateUser(userId);
    }

    @Override
    public void seeUser(String userId) {
        usertype.seeUser(userId);
    }

    @Override
    public void seeItem(String itemId) {
        usertype.seeItem(itemId);
    }

    @Override
    public void addCategory(String name, String description) {
        usertype.addCategory(name, description);
    }

    @Override
    public void changeCategory(String name, String newName, String description) {
        usertype.changeCategory(name, newName, description);
    }

// --- debug only (begin) ---
    @Override
    public String teste() {
        return core.teste();
    }
// --- debug only (end) ---
}
