package org.app.pet.service.dao;

import javax.transaction.Transactional;

import org.app.pet.service.model.Users;

/**
 * User Dao
 * @author ravelu
 *
 */
@Transactional
public class UserDao  extends AbsHibernateDao<Users> implements IUsersDao{

	public UserDao(){
		super();
		setClassT(Users.class);
	}
}
