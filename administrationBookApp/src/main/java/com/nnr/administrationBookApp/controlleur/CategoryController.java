package com.nnr.administrationBookApp.controlleur;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.administrationBookApp.model.Category;
import com.nnr.administrationBookApp.service.InterfaceCategory;

@RestController
@CrossOrigin("*")
public class CategoryController {
	
	private InterfaceCategory interfaceCategory;
	
	public CategoryController(InterfaceCategory interfaceCategory) {
		super();
		this.interfaceCategory = interfaceCategory;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/addCategory")
	public Category addCategory(@RequestBody Category category) {
		return interfaceCategory.addCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getAllCategory")
	public List<Category> getAllCategory(){
		return interfaceCategory.getAllCategory();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/deleteCategorie/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId) {
		interfaceCategory.deleteCategory(categoryId);
	}

}
