package br.com.restful.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManegerSingleton {

    public static EntityManagerFactory factory;

    public static EntityManager getInstance(String pass) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("javax.persistence.jdbc.password", pass);
        factory = Persistence.createEntityManagerFactory("restful", result);
        final EntityManager em = factory.createEntityManager();
        return em;
    }

}
