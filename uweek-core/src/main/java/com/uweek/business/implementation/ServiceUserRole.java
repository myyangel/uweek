package com.uweek.business.implementation;

import com.uweek.business.IServiceUserRole;
import com.uweek.entity.UserRole;
import javax.inject.Inject;
import javax.inject.Named;

import com.uweek.repository.implementation.RepositoryUserRole;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;

@Named
public class ServiceUserRole implements IServiceUserRole, Serializable{
    
    private static final long serialVersionUID = 1L;

    @Inject
    private RepositoryUserRole repositoryUserRole;
    
    
    @Override
    @Transactional
    public Integer insert(UserRole ur) throws Exception {
        return repositoryUserRole.insert(ur);
    }

    @Override
    @Transactional
    public Integer update(UserRole ur) throws Exception {
        return repositoryUserRole.update(ur);
    }

    @Override
    @Transactional
    public Integer delete(UserRole ur) throws Exception {
        return repositoryUserRole.delete(ur);
    }

    @Override
    @Transactional
    public List<UserRole> list() throws Exception {
        return repositoryUserRole.list();
    }

    @Override
    @Transactional
    public UserRole findById(UserRole ur) throws Exception {
        return repositoryUserRole.findById(ur);
    }
}
