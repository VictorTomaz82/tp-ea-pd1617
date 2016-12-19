package tpserver;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import logic.User;

@Singleton
@LocalBean
public class Core implements CoreLocal {

    List<User> users;

    @Override
    public String teste() {
        return "comunica";
    }

    @PostConstruct
    public void load() {

    }

    @PreDestroy
    public void save() {

    }

}
