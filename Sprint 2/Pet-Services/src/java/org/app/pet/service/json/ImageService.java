package org.app.pet.service.json;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.pet.service.dao.IImageDao;
import org.app.pet.service.model.Image;
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
 * REST API to perform  add/get/delete on images.
 *
 */
@RestController
public class ImageService {
	
	Log logger=LogFactory.getLog(this.getClass());

	@Autowired
	private IImageDao iImageDao;
	
	/**
	 * Create Image Dao
	 */
	public ImageService(){
		super();		
		if(iImageDao == null) {
			iImageDao = PetShopUtil.getContext().getBean(IImageDao.class);
		}
	}
     
	/**
	 * Get Image by id
	 * @param prdId
	 * @return
	 */
    @RequestMapping(value = "/rest/image/{id}", method = RequestMethod.GET)
    public @ResponseBody Image getImageById(@PathVariable("id") long prdId) {
    	logger.debug("getImageById >> "+prdId);         
        return iImageDao.findById(Image.PK_COLUMN_NAME, prdId);
    }
     
    /**
     * Get all Images
     * @return
     */
    @RequestMapping(value = "/rest/images", method = RequestMethod.GET)
    public @ResponseBody List<Object> getAllImages() {
    	logger.debug("getAllImages >>");    	
        return iImageDao.findAll();
    }
     
    /**
     * Create Images
     * @param item
     * @return
     */
    @RequestMapping(value =  "/rest/image/create", method = RequestMethod.POST)
    public @ResponseBody Image createImage(@RequestBody Image item) {
    	logger.debug("createImage >>");
    	iImageDao.create(item);
        return item;
    }
     
    /**
     * Delete Images
     * @param prdId
     */
    @RequestMapping(value = "/rest/image/delete/{id}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") long prdId) {
    	logger.debug("deleteImage >>");
    	iImageDao.deleteById(Image.PK_COLUMN_NAME, prdId);
    }

}
