package com.uweek.business.implementation;

import com.uweek.business.IServiceDish;
import com.uweek.entity.Dish;
import javax.inject.Inject;
import javax.inject.Named;

import com.uweek.repository.implementation.RepositoryDish;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;

@Named
public class ServiceDish implements IServiceDish, Serializable{
    
    private static final long serialVersionUID = 1L;

    @Inject
    private RepositoryDish repositoryDish;
    
    
    @Override
    @Transactional
    public Integer insert(Dish d) throws Exception {
        return repositoryDish.insert(d);
    }

    @Override
    @Transactional
    public Integer update(Dish d) throws Exception {
        return repositoryDish.update(d);
    }

    @Override
    @Transactional
    public Integer delete(Dish d) throws Exception {
        return repositoryDish.delete(d);
    }

    @Override
    @Transactional
    public List<Dish> list() throws Exception {
        return repositoryDish.list();
    }

    @Override
    @Transactional
    public Dish findById(Dish d) throws Exception {
        return repositoryDish.findById(d);
    }
}
