package org.app.pet.service.json;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.pet.service.dao.IUsersDao;
import org.app.pet.service.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User related REST API
 * @author ravelu
 *
 */
@RestController
public class UserService {
	
	Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private IUsersDao iUserDao;
	
	public UserService() {
		super();
		if(iUserDao == null) {
			iUserDao = PetShopUtil.getContext().getBean(IUsersDao.class);
		}
	}
	
	/**
	 * User Authentication API
	 * @param item
	 * @return
	 */
	@RequestMapping(value =  "/rest/authenticate", method = RequestMethod.POST)
    public @ResponseBody Users authenticateUser(@RequestBody Users item) {
		logger.debug("authenticateUser >> " + item.getUsrAlias() +";"+item.getUsrPwd());
		if(item != null && item.getUsrAlias() != null) {	    	
			Users user = (Users) iUserDao.findByColumns(Users.COL_USR_ALIAS, item.getUsrAlias());
			logger.debug("Comparing :  " + user.getUsrPwd() +";"+item.getUsrPwd());
	    	if(user.getUsrPwd().equals(item.getUsrPwd())) {	    		
	    		logger.debug("Login Success User."); 
	    		 return user;
	    	} else {
	    		logger.debug("Login Failure");	    		
	    	}
	    }
    	return new Users();
    }
	/**
	 * Find by alias
	 * @param alias
	 * @return
	 */
	//http://localhost:8080/petuser/rest/user/find/ravelu
	@RequestMapping(value = "/rest/user/find/{alias}", method = RequestMethod.GET)
    public @ResponseBody Users getUserByAlias(@PathVariable("alias") String alias) {
		logger.debug("getUserById >> "+alias);         
        return 	iUserDao.findByColumns(Users.COL_USR_ALIAS, alias);
    }
     
	/**
	 * Find by id
	 * @param usrId
	 * @return
	 */
    @RequestMapping(value = "/rest/user/{id}", method = RequestMethod.GET)
    public @ResponseBody Users getUserById(@PathVariable("id") long usrId) {
    	logger.debug("getUserById >> "+usrId);         
        return iUserDao.findById(Users.PK_COLUMN_NAME, usrId);
    }
     
    /**
     * Get all Users
     * @return
     */
    @RequestMapping(value = "/rest/users", method = RequestMethod.GET)
    public @ResponseBody List<Object> getAllUsers() {
    	logger.debug("getAllUsers >>");    	
        return iUserDao.findAll();
    }
     
    @RequestMapping(value =  "/rest/user/create", method = RequestMethod.POST)
    public @ResponseBody Users createUser(@RequestBody Users item) {
    	logger.debug("createUser >>");
    	System.out.println("createUser >> getUsrCode" +item.getUsrCode());
    	System.out.println("createUser >> getUsrName" +item.getUsrName());
    	iUserDao.create(item);
        return item;
    }
    
    /**
     * Update User
     * @param item
     * @return
     */
    @RequestMapping(value =  "/rest/user/update", method = RequestMethod.POST)
    public @ResponseBody Users updateUser(@RequestBody Users item) {
    	logger.debug("updateUser >>");
    	System.out.println("createUser >> getUsrCode" +item.getUsrCode());
    	System.out.println("createUser >> getUsrName" +item.getUsrName());
    	iUserDao.create(item);
        return item;
    }
     
    /**
     * Delete User
     * @param usrId
     */
    @RequestMapping(value = "/rest/user/delete/{id}", method = RequestMethod.PUT)
    public void deleteUser(@PathVariable("id") int usrId) {
    	logger.debug("deleteUser >>");
    	System.out.println("deleteUser >> getUsrCode" +usrId);
    	iUserDao.deleteById(Users.PK_COLUMN_NAME, usrId);
    }

}
