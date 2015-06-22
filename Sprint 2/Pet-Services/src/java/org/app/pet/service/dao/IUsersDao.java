package org.app.pet.service.dao;

import java.util.List;

import org.app.pet.service.model.Users;

/**
 * User
 * @author ravelu
 *
 */
public interface IUsersDao {
	
	Users findById(String primaryCol, long id);
	
	Users findByColumns(String primaryCol, String id);
	
	List<Object> findAll();
	
	void create(Users item);
	
	Users update(Users item);
	
	void delete(Users item);
	
	void deleteById(String primaryCol, long id);

}
