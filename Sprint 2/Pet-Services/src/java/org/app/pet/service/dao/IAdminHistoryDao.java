package org.app.pet.service.dao;

import java.util.List;

import org.app.pet.service.model.AdminHistory;

/**
 * Admin History interface
 * @author ravelu
 *
 */
public interface IAdminHistoryDao {
	
	AdminHistory findById(String primaryCol, long id);
	
	List<Object> findAll();
	
	void create(AdminHistory item);
	
	AdminHistory update(AdminHistory item);
	
	void delete(AdminHistory item);
	
	void deleteById(String primaryCol, long id);

}
