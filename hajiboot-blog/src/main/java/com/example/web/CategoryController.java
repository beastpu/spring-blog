package com.example.web;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Category;

import com.example.repository.CategoryDao;




@Controller
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;
	
	
	

	@ResponseBody
	@RequestMapping(value = "/category/add",method = RequestMethod.POST)
	public Category add(@RequestParam(value = "categoryName", required = true) String categoryName) {

		Category category = new Category();
		category.setName(categoryName);
		

		return categoryDao.save(category);

	}
	
	
	
	
}