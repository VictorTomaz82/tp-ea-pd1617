package tpserver;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class Patron implements PatronRemote {

    @EJB
    Core core;

    @Override
    public String teste() {
        return core.teste();
    }

}
