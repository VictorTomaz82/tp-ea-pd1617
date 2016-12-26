package tpserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import logic.Item;

@Stateless
public class Concierge implements ConciergeRemote {

    @EJB
    Core core;

    @Override
    public String teste() {
        return core.teste();
    }

    @Override
    public ArrayList<String> seeNews() {
        //return core.getNewsletter().getNews();
        return null;
    }

    @Override
    public ArrayList<String> seeLastThree() {
        ArrayList<Item> itemsSold = new ArrayList<>();
        ArrayList<String> lastThree = new ArrayList<>();

        for (int i = 0; i < core.getItems().size(); i++) {
            if (core.getItems().get(i).isPayed()) {
                itemsSold.add(core.getItems().get(i));
            }
        }

        Collections.sort(itemsSold, (Item o1, Item o2) -> {
            if (o1.getBids().get(o1.getBids().size() - 1) == null || o2.getBids().get(o1.getBids().size() - 1) == null) {
                return 0;
            }
            return o1.getBids().get(o1.getBids().size() - 1).getTime().compareTo(o2.getBids().get(o1.getBids().size() - 1).getTime());
        });

        
        for (int i = 0; i < itemsSold.size(); i++){
            lastThree.add(itemsSold.get(i).getName() + ": \"" + itemsSold.get(i).getDescription() + "\" was sold for: " + itemsSold.get(i).getBids().get(itemsSold.get(i).getBids().size() - 1).getValue() + "€");
            if(lastThree.size() == 3)
                break;
        }
        
        return lastThree;
    }

    @Override
    public void askAccess(String username, String password) {
    }

    @Override
    public void askReactivation(String username, String password) {
    }

}
