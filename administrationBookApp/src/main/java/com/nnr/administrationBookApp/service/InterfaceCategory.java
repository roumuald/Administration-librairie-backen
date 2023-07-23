package com.nnr.administrationBookApp.service;

import java.util.List;

import com.nnr.administrationBookApp.model.Category;

public interface InterfaceCategory {
	
	public Category addCategory(Category category);
	
	public List<Category> getAllCategory();
	
	public void deleteCategory(Long categoryId);

}
