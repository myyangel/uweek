package com.uweek.business.implementation;

import com.uweek.business.IServiceAllergy;
import com.uweek.entity.Allergy;
import com.uweek.repository.implementation.RepositoryAllergy;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class ServiceAllergy implements IServiceAllergy, Serializable{
    
    private static final long serialVersionUID = 1L;

    @Inject
    private RepositoryAllergy repositoryAllergy;
    
    
    @Override
    @Transactional
    public Integer insert(Allergy a) throws Exception {
        return repositoryAllergy.insert(a);
    }

    @Override
    @Transactional
    public Integer update(Allergy a) throws Exception {
        return repositoryAllergy.update(a);
    }

    @Override
    @Transactional
    public Integer delete(Allergy a) throws Exception {
        return repositoryAllergy.delete(a);
    }

    @Override
    @Transactional
    public List<Allergy> list() throws Exception {
        return repositoryAllergy.list();
    }

    @Override
    @Transactional
    public Allergy findById(Allergy a) throws Exception {
        return repositoryAllergy.findById(a);
    }
}
