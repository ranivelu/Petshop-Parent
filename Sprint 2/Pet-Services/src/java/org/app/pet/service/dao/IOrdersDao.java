package org.app.pet.service.dao;

import java.util.List;

import org.app.pet.service.model.Orders;

/**
 * Order Dao
 * @author ravelu
 *
 */
public interface IOrdersDao {
	
	Orders findById(String primaryCol, long id);
	
	List<Object> findAll();
	
	void create(Orders item);
	
	Orders update(Orders item);
	
	void delete(Orders item);
	
	void deleteById(String primaryCol, long id);
}
