package com.sevgul.spring.shopping.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sevgul.spring.shopping.backend.dao.CategoryDao;
import com.sevgul.spring.shopping.backend.dto.Category;

@Controller
public class FrontController {

	@Autowired
	private CategoryDao catDao;
	
	
	@RequestMapping(value= {"/", "/index", "/home"} )
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("homeSelected", true);
		mv.addObject("categories", catDao.list());
		
		return mv;
	}
	
	
	@RequestMapping(value= {"/products"} )
	public ModelAndView products() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Products");
		mv.addObject("productsSelected", true);
		
		return mv;
	}
	
	
	@RequestMapping(value= {"/about"} )
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("aboutSelected", true);
		
		return mv;
	}
	

	@RequestMapping(value= {"/contact"} )
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("contactSelected", true);
		
		return mv;
	}
	

	@RequestMapping(value= {"/products/all"} )
	public ModelAndView productsAll() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Products");
		mv.addObject("productsAllSelected", true);
		mv.addObject("categories", catDao.list());
		
		return mv;
	}
	

	@RequestMapping(value= {"/category/{id}/products"} )
	public ModelAndView categoryProducts( @PathVariable("id") int id)  {
		ModelAndView mv = new ModelAndView("page");
		
		Category cat = catDao.get(id);
		if(cat != null) {
			mv.addObject("title", cat.getCategory());
			mv.addObject("category", cat);
			mv.addObject("categories", catDao.list());
			mv.addObject("categoryProductsSelected", true);
		}
		return mv;
	}
	


}
