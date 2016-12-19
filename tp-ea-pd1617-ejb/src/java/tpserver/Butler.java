package tpserver;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class Butler implements ButlerRemote {

    @EJB
    Core core;

    public String teste() {
        return core.teste();
    }
}
