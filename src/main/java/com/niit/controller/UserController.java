package com.niit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDAO;
import com.niit.domain.User;


@Controller
public class UserController {
	
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDAO userDAO;
	@Autowired User user;
	
	//get the user id password from the login page
	//send these values to userDAO.validate
	//based on response , you can navigate to either login.jsp or home.jsp

	
	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("id") String id,@RequestParam("password") String password)
{
	
	ModelAndView mv = new ModelAndView("/Home");
	if(userDAO.validate(id, password)==true)
	{
		user = userDAO.get(id);
		//&{message} - to display in the home.
		mv.addObject("message","WELCOME"+user.getName());
		
		if (user.getRole().equals("admin")) {
			log.debug("You are admin");
			mv.addObject("isAdmin", "true");
		} else {
			log.debug("You are a customer");
			mv.addObject("isAdmin", "false");
		}
	}
	else
	{
		mv.addObject("message", "INvalid credentials....please try again");
	}
	
	return mv;
	
}
}
