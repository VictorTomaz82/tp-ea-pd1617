//package tpserver;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import logic.Item;
//
//@Stateless
//public class Concierge implements ConciergeRemote {
//
//    @EJB
//    Core core;
//
//    @Override
//    public String teste() {
//        return core.teste();
//    }
//
//    @Override
//    public ArrayList<String> seeNews() {
//        //return core.getNewsletter().getNews();
//        return null;
//    }
//
//    @Override
//    public ArrayList<String> seeLastThree() {
//        ArrayList<Item> itemsSold = new ArrayList<>();
//        ArrayList<String> lastThree = new ArrayList<>();
//        return lastThree;
//    }
//
//    @Override
//    public void askAccess(String username, String password) {
//    }
//
//    @Override
//    public void askReactivation(String username, String password) {
//    }
//
//}
