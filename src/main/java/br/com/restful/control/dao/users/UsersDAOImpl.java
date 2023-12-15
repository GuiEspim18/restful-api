package br.com.restful.control.dao.users;

import br.com.restful.control.dao.generic.GenericDAOImpl;
import br.com.restful.control.entity.Users;

import javax.persistence.EntityManager;

public class UsersDAOImpl extends GenericDAOImpl<Users, Integer> {

    public UsersDAOImpl(EntityManager em) {
        super(em);
    }

}
