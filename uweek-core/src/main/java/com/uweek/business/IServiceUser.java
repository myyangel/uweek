package com.uweek.business;


import com.uweek.entity.User;
import java.util.List;

public interface IServiceUser extends IServiceCRUD<User> {
    List<User> findByName(String name) throws Exception ;



}
