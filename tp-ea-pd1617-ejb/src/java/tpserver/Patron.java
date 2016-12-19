package tpserver;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class Patron implements PatronRemote {

    @EJB
    Core core;

    public String teste() {
        return core.teste();
    }

}
