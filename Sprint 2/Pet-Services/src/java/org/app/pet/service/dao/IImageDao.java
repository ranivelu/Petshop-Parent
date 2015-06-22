package org.app.pet.service.dao;

import java.util.List;

import org.app.pet.service.model.Image;

/**
 * Image Dao
 * @author ravelu
 *
 */
public interface IImageDao {

	Image findById(String primaryCol, long id);
	
	List<Object> findAll();
	
	void create(Image item);
	
	Image update(Image item);
	
	void delete(Image item);
	
	void deleteById(String primaryCol, long id);
}
