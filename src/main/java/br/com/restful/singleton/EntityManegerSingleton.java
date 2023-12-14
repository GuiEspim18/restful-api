package br.com.restful.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManegerSingleton {

    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("restful");

    public static EntityManager getInstance() {
        final EntityManager em = factory.createEntityManager();
        return em;
    }

}
