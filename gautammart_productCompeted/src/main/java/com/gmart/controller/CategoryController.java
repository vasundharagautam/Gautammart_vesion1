package com.gmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gmart.dao.CategoryDAO;
import com.gmart.model.Category;



@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	public CategoryController() {}
	
	@RequestMapping(value="/InsertCategory", method=RequestMethod.GET)
	public ModelAndView addCategory(Category category) {
		
		ModelAndView mav1=new ModelAndView("Category","category",new Category());
		categoryDAO.insertCategory(category);
		return mav1;
	}
	
	
}