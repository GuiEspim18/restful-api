package br.com.restful.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManegerSingleton {

    public static EntityManagerFactory factory;

    public static EntityManager getInstance() {
        factory = Persistence.createEntityManagerFactory("restful");
        final EntityManager em = factory.createEntityManager();
        return em;
    }

}
