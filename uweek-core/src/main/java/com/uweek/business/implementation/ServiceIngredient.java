/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uweek.business.implementation;

import java.io.Serializable;

import com.uweek.business.IServiceIngredient;
import com.uweek.entity.Ingredient;
import com.uweek.repository.implementation.RepositoryIngredient;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
/**
 *
 * @author arman
 */
@Named
public class ServiceIngredient implements IServiceIngredient, Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private RepositoryIngredient repositoryIngredient;
    
    
    @Override
    @Transactional
    public Integer insert(Ingredient t) throws Exception {
        return repositoryIngredient.insert(t);
    }

    @Override
    @Transactional
    public Integer update(Ingredient t) throws Exception {
        return repositoryIngredient.update(t);
    }

    @Override
    @Transactional
    public Integer delete(Ingredient t) throws Exception {
        return repositoryIngredient.delete(t);
    }

    @Override
    @Transactional
    public List<Ingredient> list() throws Exception {
        return repositoryIngredient.list();
    }

    @Override
    @Transactional
    public Ingredient findById(Ingredient t) throws Exception {
        return repositoryIngredient.findById(t);
    }
    
}
