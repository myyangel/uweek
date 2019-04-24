package com.uweek.repository.implementation;

import com.uweek.entity.Dish;
import com.uweek.entity.Plan;
import com.uweek.repository.IRepositoryDish;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
public class RepositoryDish implements IRepositoryDish{
    
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

    @Override
    public List<Dish> list() throws Exception {
        List<Dish> listDishes = new ArrayList<>();
        
        TypedQuery<Dish> query = em.createQuery("SELECT d FROM Dish d", Dish.class);
        listDishes = query.getResultList();
        return listDishes;
    }

    @Override
    public Dish findById(Dish d) throws Exception {
        List<Dish> listDishes = new ArrayList<>();
        TypedQuery<Dish> query = em.createQuery("SELECT d FROM Dish d WHERE d.id = ?1", Dish.class);
        query.setParameter(1, d.getId());
        
        listDishes = query.getResultList();
        
        return listDishes != null && !listDishes.isEmpty() ? listDishes.get(0) : new Dish();
        
    }
}
