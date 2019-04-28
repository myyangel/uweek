package com.uweek.repository.implementation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.uweek.entity.User;
import com.uweek.repository.IRepositoryUser;

@Named
public class RepositoryUser implements IRepositoryUser, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "uweekvisorPU")
	private EntityManager em;

	@Override
	public Integer insert(User t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(User t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(User t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() throws Exception {
		List<User> listCustomers = new ArrayList<>();

		Query q = em.createQuery("SELECT c FROM User c");
		listCustomers = (List<User>) q.getResultList();
		return listCustomers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findById(User t) throws Exception {
		List<User> customers = new ArrayList<>();
		Query q = em.createQuery("FROM User c where c.id = ?1");
		q.setParameter(1, t.getId());

		customers = (List<User>) q.getResultList();

		return customers != null && !customers.isEmpty() ? customers.get(0) : new User();
	}
        @Override
	public List<User> findByName(String name) throws Exception {
		return em.createQuery("from User where name like :name", User.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}



}