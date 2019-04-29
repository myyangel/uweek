package com.uweek.business.implementation;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.uweek.entity.User;
import com.uweek.business.IServiceUser;
import com.uweek.repository.IRepositoryUser;


@Named
public class ServiceUser implements IServiceUser,Serializable {


	private static final long serialVersionUID = 1L;
	@Inject
	private IRepositoryUser repositoryUser;

	@Transactional
	@Override
	public Integer insert(User t) throws Exception {
		return repositoryUser.insert(t);
	}

	@Transactional
	@Override
	public Integer update(User t) throws Exception {
		return repositoryUser.update(t);
	}

	@Transactional
	@Override
	public Integer delete(User t) throws Exception {
		return repositoryUser.delete(t);
	}

	@Override
	public List<User> list() throws Exception {
		return repositoryUser.list();
	}

	@Override
	public User findById(User t) throws Exception {
		return repositoryUser.findById(t);
	}
        @Override
	public List<User> findByName(String name) throws Exception {
		return repositoryUser.findByName(name);
	}

}
