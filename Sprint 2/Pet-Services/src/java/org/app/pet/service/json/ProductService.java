package org.app.pet.service.json;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.pet.service.dao.IProductDao;
import org.app.pet.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Product related REST API
 * @author ravelu
 *
 */
@RestController
public class ProductService {
	
	Log logger=LogFactory.getLog(this.getClass());

	@Autowired
	private IProductDao iProductDao;
	
	
	public ProductService(){
		super();		
		if(iProductDao == null) {
			iProductDao = PetShopUtil.getContext().getBean(IProductDao.class);
		}
	}
     
    @RequestMapping(value = "/rest/product/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getproductById(@PathVariable("id") long prdId) {
    	logger.debug("getproductById >> "+prdId);         
        return iProductDao.findById(Product.PK_COLUMN_NAME, prdId);
    }
     
    @RequestMapping(value = "/rest/products", method = RequestMethod.GET)
    public @ResponseBody List<Object> getAllProducts() {
    	logger.debug("getAllProducts >>");    	
        return iProductDao.findAll();
    }
     
    @RequestMapping(value =  "/rest/product/create", method = RequestMethod.POST)
    public @ResponseBody Product createProduct(@RequestBody Product item) {
    	logger.debug("createProduct >>");
    	
    	System.out.println("createProduct >> getPrdCode" +item.getPrdCode());
    	System.out.println("createProduct >> getPrdCode" +item.getPrdName());
    	iProductDao.create(item);
        return item;
    }
     
    @RequestMapping(value = "/rest/product/delete/{id}", method = RequestMethod.PUT)
    public void deleteProduct(@PathVariable("id") long prdId) {
    	logger.debug("deleteProduct >>");
    	System.out.println("createProduct >> getPrdCode" +prdId);
    	iProductDao.deleteById(Product.PK_COLUMN_NAME, prdId);
    }
}