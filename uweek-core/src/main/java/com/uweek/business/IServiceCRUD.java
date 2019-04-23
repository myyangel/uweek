/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uweek.business;

import java.util.List;

/**
 *
 * @author arman
 * @param <T>
 */
public interface IServiceCRUD<T> {
    	Integer insert(T t) throws Exception;
	Integer update(T t) throws Exception;
	Integer delete(T t) throws Exception;
	List<T> list() throws Exception;
	T findById(T t) throws Exception; 
}
