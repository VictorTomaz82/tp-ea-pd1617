package tpserver;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class Concierge implements ConciergeLocal {
    
    @PersistenceContext(unitName = "tp1617PU") 
    private EntityManager em;

    @EJB
    Core core;

    // --- Methods ---
//    @PostConstruct
//    public void load() {
//
//    }


}
