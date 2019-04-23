/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uweek.repository.implementation;

import com.uweek.entity.Ingredient;
import com.uweek.repository.IRepositoryIngredient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

/**
 *
 * @author arman
 */
public class RepositoryIngredient implements IRepositoryIngredient, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "uweekvisorPU")
    private EntityManager em;

    @Override
    public Integer insert(Ingredient t) throws Exception {
        em.persist(t);
        return t.getId();
    }

    @Override
    public Integer update(Ingredient t) throws Exception {
        em.merge(t);
        return t.getId();
    }

    @Override
    public Integer delete(Ingredient t) throws Exception {
        em.remove(t);
        return 1;
    }

    @Override
    public List<Ingredient> list() throws Exception {
        List<Ingredient> listIngredients = new ArrayList<>();

        TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
        listIngredients = query.getResultList();
        return listIngredients;
    }

    @Override
    public Ingredient findById(Ingredient t) throws Exception {
        List<Ingredient> listIngredients = new ArrayList<>();
        TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i WHERE i.id = ?1", Ingredient.class);
        query.setParameter(1, t.getId());

        listIngredients = query.getResultList();

        return listIngredients != null && !listIngredients.isEmpty() ? listIngredients.get(0) : new Ingredient();

    }

}
