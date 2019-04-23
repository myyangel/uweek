/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uweek.business.implementation;

import java.io.Serializable;

import com.uweek.business.IServicePlan;
import com.uweek.entity.Plan;
import com.uweek.repository.implementation.RepositoryPlan;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author arman
 */
@Named
public class ServicePlan implements IServicePlan, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RepositoryPlan repositoryPlan;

    @Override
    @Transactional
    public Integer insert(Plan t) throws Exception {
        return repositoryPlan.insert(t);
    }

    @Override
    @Transactional
    public Integer update(Plan t) throws Exception {
        return repositoryPlan.update(t);
    }

    @Override
    @Transactional
    public Integer delete(Plan t) throws Exception {
        return repositoryPlan.delete(t);
    }

    @Override
    @Transactional
    public List<Plan> list() throws Exception {
        return repositoryPlan.list();
    }

    @Override
    @Transactional
    public Plan findById(Plan t) throws Exception {
        return repositoryPlan.findById(t);
    }

}
