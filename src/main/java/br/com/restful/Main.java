package br.com.restful;

import br.com.restful.control.entity.Users;
import br.com.restful.singleton.EntityManegerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        final EntityManager em = EntityManegerSingleton.getInstance(""); // your db password here

        try {
            // add user to database
            final Users users = new Users();
            users.setName("Heloisa Santos Nascimento");
            users.setEmail("santosnascimentoheloisa@gmail.com");
            users.setPassword("helosn08");

            em.getTransaction().begin();
            em.persist(users);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Unsuccessful register!");
        } finally {
            em.close();
        }
    }
}
