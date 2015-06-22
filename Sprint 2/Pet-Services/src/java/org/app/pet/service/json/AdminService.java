package org.app.pet.service.json;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author ravelu
 *
 * REST API to perform Admin related Order Changes.
 *
 */

@RestController
public class AdminService {

	Log logger=LogFactory.getLog(this.getClass());

	/*@Autowired
	public IAdminHistoryDao iAdminHistoryDao;
		
	public AdminService(){
		super();		
		if(iAdminHistoryDao == null) {
			iAdminHistoryDao = PetShopUtil.getContext().getBean(IAdminHistoryDao.class);
		}
	}
     
    @RequestMapping(value = "/rest/admin/{id}", method = RequestMethod.GET)
    public @ResponseBody AdminHistory getAdminHisById(@PathVariable("id") long adhId) {
    	logger.debug("getAdminHisById >> " + adhId);         
        return iAdminHistoryDao.findById(AdminHistory.PK_COLUMN_NAME, adhId);
    }
     
    @RequestMapping(value = "/rest/adminhistory", method = RequestMethod.GET)
    public @ResponseBody List<Object> getAllAdminHistory() {
    	logger.debug("getAllAdminHistory >>");    	
        return iAdminHistoryDao.findAll();
    }
     
    @RequestMapping(value =  "/rest/admin/create", method = RequestMethod.POST)
    public @ResponseBody AdminHistory createAdminHistory(@RequestBody AdminHistory item) {
    	logger.debug("createAdminHistory >>");
    	iAdminHistoryDao.create(item);
        return item;
    }
     
    @RequestMapping(value = "/rest/admin/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAdminHistoryById(@PathVariable("id") long adhId) {
    	logger.debug("deleteAdminHistoryById >>");
    	iAdminHistoryDao.deleteById(AdminHistory.PK_COLUMN_NAME, adhId);
    }*/
}
