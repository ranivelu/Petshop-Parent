package org.app.pet.service.json;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.pet.service.dao.IOrderItemDao;
import org.app.pet.service.dao.IOrdersDao;
import org.app.pet.service.model.Orders;
import org.app.pet.service.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author ravelu
 *
 * Order Service perform "Add to Cart" related operations
 */
public class OrderService {
	
	Log logger=LogFactory.getLog(this.getClass());

	@Autowired
	private IOrderItemDao iOrderItemDao;

	@Autowired
	private IOrdersDao iOrdersDao;
	
	/**
	 * Order Service instance bean loading
	 */
	public OrderService(){
		super();		
		if(iOrderItemDao == null) {
			iOrderItemDao = PetShopUtil.getContext().getBean(IOrderItemDao.class);
		}		
		if(iOrdersDao == null) {
			iOrdersDao = PetShopUtil.getContext().getBean(IOrdersDao.class);
		}
	}
     
	/**
	 * Get Order by Id
	 * @param ordId
	 * @return
	 */
    @RequestMapping(value = "/rest/order/{id}", method = RequestMethod.GET)
    public @ResponseBody Orders getOrdersById(@PathVariable("id") long ordId) {
    	logger.debug("getOrdersById >> "+ordId);         
        return iOrdersDao.findById(Orders.PK_COLUMN_NAME, ordId);
    }
     
    /**
     * Get Orders
     * @return
     */
    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET)
    public @ResponseBody List<Object> getAllOrders() {
    	logger.debug("getAllOrders >>");    	
        return iOrdersDao.findAll();
    }
     
    /**
     * Create Order 
     * @param item
     * @return
     */
    @RequestMapping(value =  "/rest/order/create", method = RequestMethod.POST)
    public @ResponseBody Orders createOrders(@RequestBody Orders item) {
    	logger.debug("createOrders >>");
    	System.out.println("createOrders >> getOrdCode" + item.getOrdCode());
    	System.out.println("createOrders >> getUsrCode" + item.getUsrCode());
    	iOrdersDao.create(item);
        return item;
    }
     
    /**
     * Delete Order, by Id
     * @param ordId
     */
    @RequestMapping(value = "/rest/order/delete/{id}", method = RequestMethod.DELETE)
    public void deleteOrders(@PathVariable("id") long ordId) {
    	logger.debug("deleteOrders >>");
    	System.out.println("deleteOrders >> getOrdCode" + ordId);
    	iOrdersDao.deleteById(Orders.PK_COLUMN_NAME, ordId);
    }

    /**
     * Get OrderItem by id 
     * @param ordItmId
     * @return
     */
    @RequestMapping(value = "/rest/orderitem/{id}", method = RequestMethod.GET)
    public @ResponseBody OrderItem getOrderItemsById(@PathVariable("id") long ordItmId) {
    	logger.debug("getOrderItemsById >> "+ordItmId);         
        return iOrderItemDao.findById(OrderItem.PK_COLUMN_NAME, ordItmId);
    }
     
    /**
     * Get all orderitem
     * @return
     */
    @RequestMapping(value = "/rest/orderitems", method = RequestMethod.GET)
    public @ResponseBody List<Object> getAllOrderItems() {
    	logger.debug("getAllOrderItems >>");    	
        return iOrderItemDao.findAll();
    }
     
    /**
     * Create OrderItem
     * @param item
     * @return
     */
    @RequestMapping(value =  "/rest/orderitem/create", method = RequestMethod.POST)
    public @ResponseBody OrderItem createOrderItem(@RequestBody OrderItem item) {
    	logger.debug("createOrderItem >>");
    	iOrderItemDao.create(item);
        return item;
    }
     
    /**
     * Delete Order Item by id
     * @param ordItmId
     */
    @RequestMapping(value = "/rest/orderitem/delete/{id}", method = RequestMethod.DELETE)
    public void deleteOrderItem(@PathVariable("id") long ordItmId) {
    	logger.debug("deleteOrderItem >>");
    	iOrderItemDao.deleteById(Orders.PK_COLUMN_NAME, ordItmId);
    }
}
