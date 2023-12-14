package br.com.restful;

import br.com.restful.control.entity.Users;
import br.com.restful.singleton.EntityManegerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        final EntityManager em = EntityManegerSingleton.getInstance();

        try {
            // add user to database
            final Users users = new Users();
            users.setName("Guilherme Monteiro Espim");
            users.setEmail("guilherme.monteiro.espim@gmail.com");
            users.setPassword("guilherme123");

            em.getTransaction().begin();
            em.persist(users);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
