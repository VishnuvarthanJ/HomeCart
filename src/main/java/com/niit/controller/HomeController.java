package com.niit.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
	


	
	//http://localhost:8080/wheelsportal/

	/*@RequestMapping("/")
	public  String goToHome(Model model)
		{
		System.out.println("In goToHOme method");
		model.addAttribute("message", "Thank you for visiting Shopping Cart");
		return "Home";
		
	}      */

	@RequestMapping("/")
	public  ModelAndView goToHome()
		{
		
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting Wheelskart");
		
	
		return mv;
		
	}   
	
	
	@RequestMapping("/LoginPage")
	public String loginPage(Model model)
	{
		
		model.addAttribute("isUserClickedLogin", "true");
		return "Login";
	}
	
	@RequestMapping("/RegistrationPage")
	public String registrationPage(Model model)
	{
		
		model.addAttribute("isUserClickedRegister", "true");
		
		return "Registration";
	}


			
}