package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.domain.Category;

@Controller
public class CategoryController {
	
	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
	//create category
	//fetch all categories
	//delete category
	//update category
	
	@Autowired  CategoryDAO categorydAO;
	
	@Autowired  Category category;
	
	@Autowired  HttpSession session;
	
	
	//@RequestMapping("/manage_category_add")
	@GetMapping("/manage_category_add")
	public ModelAndView  createCategory(@RequestParam("id") String id, 
			@RequestParam("name") String name,  @RequestParam("description") String desc)
   {
		log.debug("Starting of the method manageCategories");
		category.setId(id);
		category.setName(name);
		category.setDescription(desc);
		
		ModelAndView mv = new ModelAndView("Home");
		
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		
		//Before calling save method, check whether the category id already exist in db or not
		
		//if it is does not exist, then only call save method
		
		if (categorydAO.getCategoryByID(id) !=null)
		{
			//category already exist
			mv.addObject("message", "Category already exist with teh id " +id);
			return mv;
			
		}
		else  // actualy else is not required if return statement is there in if condition
		{
			categorydAO.save(category);
			mv.addObject("message", "Category created successfuly ");
		}
		log.debug("End of the method manageCategories");
		return mv;
		
		
		
	}
	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
	{
		
		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("Home");
		 if( categorydAO.delete(id))
		 {
			 mv.addObject("message", "successfully deleted the category");
		 }
		 else
		 {
			 mv.addObject("message", "Not able to delte the category");
		 }
		 
			session.setAttribute("categoryList", categorydAO.list());
			session.setAttribute("category", category);
			
		
			log.debug("Ending of the method deleteCategory");
		 
		 return mv;
		
	
	
	}
	
}