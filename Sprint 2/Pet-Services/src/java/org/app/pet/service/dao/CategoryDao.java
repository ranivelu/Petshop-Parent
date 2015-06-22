package org.app.pet.service.dao;

import javax.transaction.Transactional;

import org.app.pet.service.model.Category;

/**
 * Category Dao
 * @author ravelu
 *
 */
@Transactional
public class CategoryDao extends AbsHibernateDao<Category> implements ICategoryDao {

	public CategoryDao(){
		super();
		setClassT(Category.class);
	}
}
