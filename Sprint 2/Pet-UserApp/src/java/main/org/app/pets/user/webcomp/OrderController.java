package org.app.pets.user.webcomp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.pet.service.model.Orders;
import org.app.pet.service.model.Product;
import org.app.pets.user.rest.api.PetsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring Controller
 * @author ravelu
 *
 * This is used for request handling related to 'Add to Cart'.
 */
@Controller
@SessionAttributes("productInCart")
public class OrderController {
	
	Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * Add to Cart
	 * @param pCode
	 * @param session
	 * @return
	 */
	@RequestMapping("/paddcart/{prdCode}")
	public ModelAndView productAddtoCart(@PathVariable("prdCode") long pCode, HttpSession session) 
	{	
		log.info("["+this.getClass()+"]"+": productAddtoCart >>");
		
		ArrayList<Product> lstPrd = (ArrayList<Product>) session.getAttribute("productInCart");		
		if(lstPrd == null) {
			lstPrd = new ArrayList<Product>();
		} 
		Product prd = new PetsUtil().getProductById(pCode);
		if(prd != null) {
			lstPrd.add(prd);
		}
		session.setAttribute("productInCart" , lstPrd);
		
		ModelAndView mv = new ModelAndView("paddcart");				
		return mv;
	}
	
	/**
	 * Delete from Cart
	 * @param pCode
	 * @param session
	 * @return
	 */
	@RequestMapping("/pdelcart/{prdCode}")
	public ModelAndView productDelFromCart(@PathVariable("prdCode") long pCode, HttpSession session) 
	{	
		log.info("["+this.getClass()+"]"+": productDelFromCart >>");
		
		ArrayList<Product> lstPrd = (ArrayList<Product>) session.getAttribute("productInCart");		
		if(lstPrd != null) {
			
			Iterator<Product> itr = lstPrd.iterator();
			// remove all even numbers
			while (itr.hasNext()) {
				Product prd = itr.next();

			    if (prd.getPrdCode() == pCode) {
			       itr.remove();
			    }
			}
			
		} 
		
		session.setAttribute("productInCart" , lstPrd);
		
		ModelAndView mv = new ModelAndView("paddcart");				
		return mv;
	}
	
	/**
	 * Place Order
	 * @param session
	 * @return
	 */
	@RequestMapping("/pOrder")
	public ModelAndView placeOrder(HttpSession session) 
	{	
		log.info("["+this.getClass()+"]"+": placeOrder >>");
		String orderId = "XXXX";
		Object id = session.getAttribute("id");
		long usrCode = 0; //Guest User
		if(id != null) {
			usrCode = Integer.parseInt(id.toString());	
		} 
		
		ArrayList<Product> lstPrd = (ArrayList<Product>) session.getAttribute("productInCart");		
		if(lstPrd == null) {  
			
			Orders ord = new Orders();
			ord.setUsrCode(usrCode);
			ord.setCreatedBy(usrCode);
			ord.setModifiedBy(usrCode);
			ord.setCreatedOn(new Date());
			ord.setModifiedOn(new Date());
			
			
		} 
		
		
		ModelAndView mv = new ModelAndView("porder");	
		mv.addObject("orderId", orderId );
		
		return mv;
	}
}
