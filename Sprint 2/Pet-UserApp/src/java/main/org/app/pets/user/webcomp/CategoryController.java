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
  * This is used for request handling related to categories.
  */
@Controller
public class CategoryController {
	
	Log log = LogFactory.getLog(this.getClass());

	@RequestMapping("/categoryList")
	public ModelAndView categoryList(
			@RequestParam(value = "cname", required = false, defaultValue = "all") String name) {
		 
		log.info("[" + this.getClass() + "]" + ": categoryList >>");
		ModelAndView mv = new ModelAndView("categorylist");
		mv.addObject("message", "Category - Page Under Construction");
		mv.addObject("cname", name);
		return mv;
	}
	
	@RequestMapping("/cdetails/{catCode}")
	public ModelAndView categoryDetails(@PathVariable("catCode") String catCode) {		
		log.info("["+this.getClass()+"]"+": categoryDetails >>");		
		ModelAndView mv = new ModelAndView("cdetails");				
		return mv;
	}
}