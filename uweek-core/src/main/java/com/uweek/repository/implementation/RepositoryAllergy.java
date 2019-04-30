package com.uweek.repository.implementation;

import com.uweek.entity.Allergy;
import com.uweek.repository.IRepositoryAllergy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
public class RepositoryAllergy implements IRepositoryAllergy, Serializable{
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "uweekvisorPU")
    private EntityManager em;
    
    @Override
    public Integer insert(Allergy ur) throws Exception {
        em.persist(ur);
        return ur.getId();
    }

    @Override
    public Integer update(Allergy ur) throws Exception {
        em.merge(ur);
        return ur.getId();
    }

    @Override
    public Integer delete(Allergy ur) throws Exception {
        em.remove(ur);
        return 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Allergy> list() throws Exception {
        List<Allergy> listAllergies = new ArrayList<>();
        
        Query query = em.createQuery("SELECT a FROM Allergy a");
        listAllergies = query.getResultList();
        return listAllergies;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Allergy findById(Allergy d) throws Exception {
        List<Allergy> listAllergies = new ArrayList<>();
        Query query = em.createQuery("SELECT a FROM Allergy a WHERE a.id = ?1");
        query.setParameter(1, d.getId());
        
        listAllergies = (List<Allergy>) query.getResultList();
        
        return listAllergies != null && !listAllergies.isEmpty() ? listAllergies.get(0) : new Allergy();
        
    }
}
