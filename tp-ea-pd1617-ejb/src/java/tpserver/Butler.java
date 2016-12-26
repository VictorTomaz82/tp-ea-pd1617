package tpserver;

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
        usertype=new Visitor();
    }
    
    
    public String teste() {
        return core.teste();
    }
}
