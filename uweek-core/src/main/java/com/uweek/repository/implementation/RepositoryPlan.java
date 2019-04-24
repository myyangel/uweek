
package com.uweek.repository.implementation;

import com.uweek.entity.Plan;
import com.uweek.repository.IRepositoryPlan;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;


@Named
public class RepositoryPlan implements IRepositoryPlan, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "uweekvisorPU")
    private EntityManager em;

    @Override
    public Integer insert(Plan t) throws Exception {
        em.persist(t);
        return t.getId();
    }

    @Override
    public Integer update(Plan t) throws Exception {
        em.merge(t);
        return t.getId();
    }

    @Override
    public Integer delete(Plan t) throws Exception {
        em.remove(t);
        return 1;
    }

    @Override
    public List<Plan> list() throws Exception {
        List<Plan> listPlans = new ArrayList<>();
        
        TypedQuery<Plan> query = em.createQuery("SELECT p FROM Plan p", Plan.class);
        listPlans = query.getResultList();
        return listPlans;
    }

    @Override
    public Plan findById(Plan t) throws Exception {
        List<Plan> listPlans = new ArrayList<>();
        TypedQuery<Plan> query = em.createQuery("SELECT p FROM Plan p WHERE p.id = ?1", Plan.class);
        query.setParameter(1, t.getId());
        
        listPlans = query.getResultList();
        
        return listPlans != null && !listPlans.isEmpty() ? listPlans.get(0) : new Plan();
        
    }

}
