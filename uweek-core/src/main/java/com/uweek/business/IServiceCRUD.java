
package com.uweek.business;

import java.util.List;

public interface IServiceCRUD<T> {
    	Integer insert(T t) throws Exception;
	Integer update(T t) throws Exception;
	Integer delete(T t) throws Exception;
	List<T> list() throws Exception;
	T findById(T t) throws Exception; 
}
