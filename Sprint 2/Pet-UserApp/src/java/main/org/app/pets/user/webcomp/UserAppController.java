package org.app.pets.user.webcomp;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
/**
 * Spring Controller
 * @author ravelu
 *
 * This is used for request handling related to user.
 */
@Controller
@SessionAttributes("name")
public class UserAppController {
	String message = "Welcome to User Module(Pet Shop Application)!";
	
	Log log = LogFactory.getLog(this.getClass());
 
	@RequestMapping("/welcome")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "Guest") String name, 
			@RequestParam(value = "id", required = false, defaultValue = "0") String id,
			HttpSession session) {
		
		/*WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(
				 getServletContext());
		*/
		log.info("["+this.getClass()+"]"+": showMessage >>");
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message", message);
		mv.addObject("name", name);
		mv.addObject("id", id);
		session.setAttribute("id", id);		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView registerUser() {
		log.info("["+this.getClass()+"]"+": registerUser >>");
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView userLogin() {
		log.info("["+this.getClass()+"]"+": userLogin >>");
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/tbd")
	public ModelAndView toBeDone() {
		log.info("["+this.getClass()+"]"+": toBeDone >>");
		ModelAndView mv = new ModelAndView("tbd");
		mv.addObject("message", "Page Under Construction");
		mv.addObject("name", ": Future Sprints !");
		return mv;
	}
}