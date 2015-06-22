package org.app.pet.service.dao;

import javax.transaction.Transactional;

import org.app.pet.service.model.Product;

/**
 * Product Dao
 * @author ravelu
 *
 */
@Transactional
public class ProductDao extends AbsHibernateDao<Product> implements IProductDao {

	public ProductDao() {
		super();
		setClassT(Product.class);
	}
}
