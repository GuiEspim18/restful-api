package br.com.restful.control.dao.generic;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {
    protected EntityManager em;

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl(EntityManager em) {
        this.em = em;
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void post(T entity) {
        em.persist(entity);
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public T getOne(K key) {
        return em.find(clazz, key);
    }

    @Override
    public void delete(K key) throws Exception {
        T entity = getOne(key);
        if (entity != null) {
            em.remove(entity);
        } else {
            throw new Exception("Entity with key " + key + " not found.");
        }
    }

    @Override
    public List<T> getAll() {
        String query = "SELECT e FROM " + clazz.getSimpleName() + " e";
        return em.createQuery(query, clazz).getResultList();
    }

    @Override
    public void commit() throws Exception {
        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
