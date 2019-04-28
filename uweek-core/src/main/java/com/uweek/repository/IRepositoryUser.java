package com.uweek.repository;

import com.uweek.entity.User;
import java.util.List;



public interface IRepositoryUser extends IRepositoryCRUD<User> {

	List<User> findByName(String name) throws Exception;
}