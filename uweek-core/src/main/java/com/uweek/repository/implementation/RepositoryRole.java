package com.uweek.repository.implementation;

import com.uweek.entity.Role;
import com.uweek.repository.IRepositoryRole;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;


@Named
public class RepositoryRole implements IRepositoryRole, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "uweekvisorPU")
    private EntityManager em;

    @Override
    public Integer insert(Role t) throws Exception {
        em.persist(t);
        return t.getId();
    }

    @Override
    public Integer update(Role t) throws Exception {
        em.merge(t);
        return t.getId();
    }

    @Override
    public Integer delete(Role t) throws Exception {
        em.remove(t);
        return 1;
    }

    @Override
    public List<Role> list() throws Exception {
        List<Role> listRoles = new ArrayList<>();
        
        TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r", Role.class);
        listRoles = query.getResultList();
        return listRoles;
    }

    @Override
    public Role findById(Role t) throws Exception {
        List<Role> listRoles = new ArrayList<>();
        TypedQuery<Role> query = em.createQuery("SELECT p FROM Plan p WHERE p.id = ?1", Role.class);
        query.setParameter(1, t.getId());
        
        listRoles = query.getResultList();
        
        return listRoles != null && !listRoles.isEmpty() ? listRoles.get(0) : new Role();
        
    }

}
