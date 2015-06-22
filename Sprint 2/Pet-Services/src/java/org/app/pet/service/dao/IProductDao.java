package org.app.pet.service.dao;

import java.util.List;

import org.app.pet.service.model.Product;

/**
 * Product Dao
 * @author ravelu
 *
 */
public interface IProductDao {
	
	Product findById(String primaryCol, long id);
	
	List<Object> findAll();
	
	void create(Product item);
	
	Product update(Product item);
	
	void delete(Product item);
	
	void deleteById(String primaryCol, long id);

}
