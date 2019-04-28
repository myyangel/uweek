package com.uweek.repository.implementation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uweek.entity.Dish;
import com.uweek.repository.IRepositoryDish;

@Named
public class RepositoryDish implements IRepositoryDish, Serializable{
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "uweekvisorPU")
    private EntityManager em;
    
    @Override
    public Integer insert(Dish d) throws Exception {
        em.persist(d);
        return d.getId();
    }

    @Override
    public Integer update(Dish d) throws Exception {
        em.merge(d);
        return d.getId();
    }

    @Override
    public Integer delete(Dish d) throws Exception {
        em.remove(d);
        return 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dish> list() throws Exception {
        List<Dish> listDishes = new ArrayList<>();
        
        Query query = em.createQuery("SELECT d FROM Dish d");
        listDishes = query.getResultList();
        return listDishes;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Dish findById(Dish d) throws Exception {
        List<Dish> listDishes = new ArrayList<>();
        Query query = em.createQuery("SELECT d FROM Dish d WHERE d.id = ?1");
        query.setParameter(1, d.getId());
        
        listDishes = (List<Dish>) query.getResultList();
        
        return listDishes != null && !listDishes.isEmpty() ? listDishes.get(0) : new Dish();
        
    }
}
