package tpserver;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class Concierge implements ConciergeRemote {

    @EJB
    Core core;

    @Override
    public String teste() {
        return core.teste();
    }

}
