package com.niit.shoppingcart.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.CartDAO;
import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.dao.ProductDAO;
import com.niit.shopingcart.dao.SupplierDAO;
import com.niit.shopingcart.model.Category;
import com.niit.shopingcart.model.MyCart;
import com.niit.shopingcart.model.Product;
import com.niit.shopingcart.model.Supplier;

@Controller
public class SpringSecurityController {

	public static Logger log = LoggerFactory.getLogger(SpringSecurityController.class);

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private MyCart myCart;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	

	// authentication-failure-forward-url="/loginError"
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
		//model.addAttribute("invalidCredentials", "true");
		log.debug("Ending of the method loginError");
		return "home";

	}

	// <security:access-denied-handler error-page="/accessDenied" />
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");

		log.debug("Ending of the method accessDenied");
		return "home";

	}
	// <security:form-login authentication-success-forward-url="/success"/>
	/*
	 * @RequestMapping("/success") public ModelAndView successForwardURL() {
	 * log.debug("Starting of the method successForwardURL"); ModelAndView mv =
	 * new ModelAndView("home");
	 * 
	 * Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); String
	 * loggedInUserid = auth.getName(); Collection<GrantedAuthority> authorities
	 * = (Collection<GrantedAuthority>) auth.getAuthorities(); if
	 * (authorities.contains("ROLE_ADMIN")) { mv.addObject("isAdmin", "true");
	 * log.debug("You are Admin"); } else { log.debug("You are not  Admin");
	 * mv.addObject("isAdmin", "false"); // myCart = cartDAO.list(userID);
	 * mv.addObject("myCart", myCart); // Fetch the myCart list based on user ID
	 * List<MyCart> cartList = cartDAO.list(loggedInUserid);
	 * mv.addObject("cartList", cartList); mv.addObject("cartSize",
	 * cartList.size()); }
	 * 
	 * log.debug("Ending of the method successForwardURL"); return mv;
	 * 
	 * }
	 */
/**
 * If we are using spring-security, this method is going to execute after login
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
	//@RequestMapping(value = "validate", method = RequestMethod.GET)
	@RequestMapping(value = "checkRole", method = RequestMethod.GET)
	public ModelAndView checkRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("starting of the method validate");
		ModelAndView mv = new ModelAndView("home");
		// session = request.getSession(true);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userID = auth.getName();
		session.setAttribute("loggedInUser", userID);

		if (request.isUserInRole("ROLE_ADMIN")) {

			session.setAttribute("isAdmin", true);

		} else {

			session.setAttribute("isAdmin", false);
			
			session.setAttribute("myCart", myCart);
			// Fetch the myCart list based on user ID
			List<MyCart> cartList = cartDAO.list(userID);
			session.setAttribute("cartList", cartList);
			session.setAttribute("cartSize", cartList.size());
			session.setAttribute("totalAmount", cartDAO.getTotalAmount(userID));

			

		}
		log.debug("Ending of the method validate");
		return mv;
	}
	
	
	@RequestMapping("/secure_logout")
	public ModelAndView secureLogout()
	{
		//what you attach to session at the time login need to remove.
		
		//session.removeAttribute("loggedInUserID");
		session.invalidate();
		
		ModelAndView mv = new ModelAndView("Home");
		
		//After logout also use should able to browse the categories and products
		//as we invalidated the session, need to load these data again.
		
		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		
		
		session.setAttribute("categoryList", categoryDAO.list());
		
		session.setAttribute("supplierList", supplierDAO.list());
		
		session.setAttribute("productList", productDAO.list());
		
		
		//OR Simpley remove only one attribute from the session.
		
		//session.removeAttribute("loggedInUser"); // you no need to load categoriees,suppliers and products
	
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
