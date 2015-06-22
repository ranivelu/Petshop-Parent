package org.app.pets.user.webcomp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * Spring Controller
 * @author ravelu
 *
 * This is used for request handling related to product.
 */
@Controller
public class ProductController {

	Log log =LogFactory.getLog(this.getClass());
	
	@RequestMapping("/productList")
	public ModelAndView productList(
			@RequestParam(value = "pname", required = false, defaultValue = "all") String name) {
		
		log.info("["+this.getClass()+"]"+": productList >>");
		//String prdNameList = new ProductUtil().getProductList();
		ModelAndView mv = new ModelAndView("productlist");
		//mv.addObject("message", prdNameList );		
		return mv;
	}
	
	@RequestMapping("/pdetails/{prdCode}")
	public ModelAndView productDetails(@PathVariable("prdCode") String username) {		
		log.info("["+this.getClass()+"]"+": productDetails >>");		
		ModelAndView mv = new ModelAndView("pdetails");				
		return mv;
	}
}
