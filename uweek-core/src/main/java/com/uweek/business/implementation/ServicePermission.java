package com.uweek.business.implementation;

import com.uweek.business.IServicePermission;
import com.uweek.entity.Permission;
import javax.inject.Inject;
import javax.inject.Named;

import com.uweek.repository.implementation.RepositoryPermission;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;

@Named
public class ServicePermission implements IServicePermission, Serializable{
    
    private static final long serialVersionUID = 1L;

    @Inject
    private RepositoryPermission repositoryPermission;
    
    
    @Override
    @Transactional
    public Integer insert(Permission p) throws Exception {
        return repositoryPermission.insert(p);
    }

    @Override
    @Transactional
    public Integer update(Permission p) throws Exception {
        return repositoryPermission.update(p);
    }

    @Override
    @Transactional
    public Integer delete(Permission p) throws Exception {
        return repositoryPermission.delete(p);
    }

    @Override
    @Transactional
    public List<Permission> list() throws Exception {
        return repositoryPermission.list();
    }

    @Override
    @Transactional
    public Permission findById(Permission p) throws Exception {
        return repositoryPermission.findById(p);
    }
    
}
