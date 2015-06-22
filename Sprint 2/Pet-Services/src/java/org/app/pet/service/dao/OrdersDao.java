package org.app.pet.service.dao;

import javax.transaction.Transactional;

import org.app.pet.service.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Order Dao
 * @author ravelu
 *
 */
@Transactional
public class OrdersDao extends AbsHibernateDao<Orders> implements IOrdersDao {
	
	@Autowired
	public OrdersDao() {
		super();
		setClassT(Orders.class);
	}

}
