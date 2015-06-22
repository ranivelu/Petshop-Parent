package org.app.pet.service.dao;

import java.util.List;

import org.app.pet.service.model.Category;

/**
 * Category Dao
 * @author ravelu
 *
 */
public interface ICategoryDao {
	
	Category findById(String primaryCol, long id);
	
	List<Object> findAll();
	
	void create(Category item);
	
	Category update(Category item);
	
	void delete(Category item);
	
	void deleteById(String primaryCol, long id);
}
