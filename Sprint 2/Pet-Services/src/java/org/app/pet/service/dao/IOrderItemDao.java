package org.app.pet.service.dao;

import java.util.List;

import org.app.pet.service.model.OrderItem;

/**
 * Order Item
 * @author ravelu
 *
 */
public interface IOrderItemDao {
	
	OrderItem findById(String primaryCol, long id);
	
	List<Object> findAll();
	
	void create(OrderItem item);
	
	OrderItem update(OrderItem item);
	
	void delete(OrderItem item);
	
	void deleteById(String primaryCol, long id);

}
