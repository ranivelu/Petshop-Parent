package org.app.pet.service.json;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.pet.service.dao.ICategoryDao;
import org.app.pet.service.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author ravelu
 *
 * REST API to perform categories add/get/delete.
 *
 */
@RestController
public class CategoriesService {
	
	Log logger=LogFactory.getLog(this.getClass());

	@Autowired
	private ICategoryDao iCategoryDao;
		
	public CategoriesService(){
		super();		
		if(iCategoryDao == null) {
			iCategoryDao = PetShopUtil.getContext().getBean(ICategoryDao.class);
		}
	}
     
	/**
	 * Get Category By Id
	 * @param catId
	 * @return
	 */
    @RequestMapping(value = "/rest/category/{id}", method = RequestMethod.GET)
    public @ResponseBody Category getCategoryById(@PathVariable("id") long catId) {
    	logger.debug("getCategoryById >> " + catId);         
        return iCategoryDao.findById(Category.PK_COLUMN_NAME, catId);
    }
     
    /**
     * Get all Categories
     * @return
     */
    @RequestMapping(value = "/rest/categories", method = RequestMethod.GET)
    public @ResponseBody List<Object> getAllCategories() {
    	logger.debug("getAllCategories >>");    	
        return iCategoryDao.findAll();
    }
     
    /**
     * Create Category
     * @param item
     * @return
     */
    @RequestMapping(value =  "/rest/category/create", method = RequestMethod.POST)
    public @ResponseBody Category createCategory(@RequestBody Category item) {
    	logger.debug("createCategory >>");
    	iCategoryDao.create(item);
        return item;
    }
     
    /**
     * Delete Categories
     * @param catId
     */
    @RequestMapping(value = "/rest/category/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCategoryById(@PathVariable("id") long catId) {
    	logger.debug("deleteCategoryById >>");
    	iCategoryDao.deleteById(Category.PK_COLUMN_NAME, catId);
    }
}