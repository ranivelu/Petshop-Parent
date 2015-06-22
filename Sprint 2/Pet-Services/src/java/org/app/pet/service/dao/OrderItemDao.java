package org.app.pet.service.dao;

import javax.transaction.Transactional;

import org.app.pet.service.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Order Item
 * @author ravelu
 *
 */
@Transactional
public class OrderItemDao extends AbsHibernateDao<OrderItem> implements IOrderItemDao {

	@Autowired
	public OrderItemDao(){
		super();
		setClassT(OrderItem.class);
	}
}
