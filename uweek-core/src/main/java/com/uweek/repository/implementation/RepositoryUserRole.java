package com.uweek.repository.implementation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uweek.entity.UserRole;
import com.uweek.repository.IRepositoryUserRole;

@Named
public class RepositoryUserRole implements IRepositoryUserRole, Serializable{
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "uweekvisorPU")
    private EntityManager em;
    
    @Override
    public Integer insert(UserRole ur) throws Exception {
        em.persist(ur);
        return ur.getId();
    }

    @Override
    public Integer update(UserRole ur) throws Exception {
        em.merge(ur);
        return ur.getId();
    }

    @Override
    public Integer delete(UserRole ur) throws Exception {
        em.remove(ur);
        return 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRole> list() throws Exception {
        List<UserRole> listUsersRoles = new ArrayList<>();
        
        Query query = em.createQuery("SELECT ur FROM UserRole ur");
        listUsersRoles = query.getResultList();
        return listUsersRoles;
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserRole findById(UserRole d) throws Exception {
        List<UserRole> listUsersRoles = new ArrayList<>();
        Query query = em.createQuery("SELECT ur FROM UserRole ur WHERE ur.id = ?1");
        query.setParameter(1, d.getId());
        
        listUsersRoles = (List<UserRole>) query.getResultList();
        
        return listUsersRoles != null && !listUsersRoles.isEmpty() ? listUsersRoles.get(0) : new UserRole();
        
    }
}
