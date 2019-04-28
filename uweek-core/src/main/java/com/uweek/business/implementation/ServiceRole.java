/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uweek.business.implementation;

import java.io.Serializable;

import com.uweek.business.IServiceRole;
import com.uweek.entity.Role;
import com.uweek.repository.implementation.RepositoryRole;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author arman
 */
@Named
public class ServiceRole implements IServiceRole, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RepositoryRole repositoryRole;

    @Override
    @Transactional
    public Integer insert(Role t) throws Exception {
        return repositoryRole.insert(t);
    }

    @Override
    @Transactional
    public Integer update(Role t) throws Exception {
        return repositoryRole.update(t);
    }

    @Override
    @Transactional
    public Integer delete(Role t) throws Exception {
        return repositoryRole.delete(t);
    }

    @Override
    @Transactional
    public List<Role> list() throws Exception {
        return repositoryRole.list();
    }

    @Override
    @Transactional
    public Role findById(Role t) throws Exception {
        return repositoryRole.findById(t);
    }

}
