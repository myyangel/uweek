package com.uweek.repository.implementation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uweek.entity.Permission;
import com.uweek.repository.IRepositoryPermission;

@Named
public class RepositoryPermission implements IRepositoryPermission, Serializable{
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "uweekvisorPU")
    private EntityManager em;
    
    @Override
    public Integer insert(Permission d) throws Exception {
        em.persist(d);
        return d.getId();
    }

    @Override
    public Integer update(Permission d) throws Exception {
        em.merge(d);
        return d.getId();
    }

    @Override
    public Integer delete(Permission d) throws Exception {
        em.remove(d);
        return 1;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Permission> list() throws Exception {
        List<Permission> listPermissions = new ArrayList<>();
        
        Query query = em.createQuery("SELECT p FROM Permission p");
        listPermissions = query.getResultList();
        return listPermissions;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Permission findById(Permission d) throws Exception {
        List<Permission> listPermission = new ArrayList<>();
        Query query = em.createQuery("SELECT p FROM Permission p WHERE p.id = ?1");
        query.setParameter(1, d.getId());
        
        listPermission = (List<Permission>) query.getResultList();
        
        return listPermission != null && !listPermission.isEmpty() ? listPermission.get(0) : new Permission();
        
    }
}
