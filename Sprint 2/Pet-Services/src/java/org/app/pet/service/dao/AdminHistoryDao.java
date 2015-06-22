package org.app.pet.service.dao;

import javax.transaction.Transactional;

import org.app.pet.service.model.AdminHistory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Admin History Dao
 * @author ravelu
 *
 */
@Transactional
public class AdminHistoryDao extends AbsHibernateDao<AdminHistory> implements IAdminHistoryDao{

	@Autowired
	public AdminHistoryDao() {
		super();
		setClassT(AdminHistory.class);
	}
}
