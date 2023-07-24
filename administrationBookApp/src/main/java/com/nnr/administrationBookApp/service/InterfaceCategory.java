package com.nnr.administrationBookApp.service;

import java.util.List;

import com.nnr.administrationBookApp.model.Book;
import com.nnr.administrationBookApp.model.Category;

public interface InterfaceCategory {
	
	public Category addCategory(Category category);
	
	public List<Category> getAllCategory();
	
	public void deleteCategory(Long categoryId);
	
	public List<Book> getBookByCategoryId(Long categoryId);
	
	public Category getOnCategory(Long categoryId);
	
	public List<Category> getCategoryByLabel(String label);
	
	public Category updateCategory(Long categoryId, Category category);

}
