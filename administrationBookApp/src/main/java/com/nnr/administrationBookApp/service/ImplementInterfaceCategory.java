package com.nnr.administrationBookApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.administrationBookApp.exception.AdministrationBookException;
import com.nnr.administrationBookApp.model.Book;
import com.nnr.administrationBookApp.model.Category;
import com.nnr.administrationBookApp.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ImplementInterfaceCategory implements InterfaceCategory{
	
	private CategoryRepository categoryRepository;
	
	public ImplementInterfaceCategory(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category addCategory(Category category) {
		if(category==null) {
			log.error("la category est null !!!");
			throw new AdministrationBookException("la category est null !!!");
		}
		Category cat = categoryRepository.save(category);
		return cat;
	}
	
	@Override
	public List<Category> getAllCategory(){
		List<Category> category=categoryRepository.findAll();
		if(!category.isEmpty()) {
			return category;
		}
		log.error("Aucune categorie disponible");
		throw new AdministrationBookException("Aucune categorie disponible");
	}
	
	@Override
	public void deleteCategory(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isPresent()) {
			categoryRepository.delete(category.get());
		}else {
		log.error("pas de categorie avec l'identifiant"+ categoryId);
		throw new AdministrationBookException("pas de categorie avec l'identifiant"+ categoryId);
		}
	}

	@Override
	public List<Book> getBookByCategoryId(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isPresent()) {
			List<Book> book= category.get().getBook();
			return book;
		}else {
			log.error("pas de categorie disponible avec l'identifiant"+" "+categoryId);
			throw new AdministrationBookException("pas de categorie disponible avec l'identifiant"+" "+categoryId);
		}
		
	}

	@Override
	public Category getOnCategory(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isPresent()) {
			return category.get();
		}
		log.error("pas de categorie disponible avec l'identifiant"+" "+categoryId);
		throw new AdministrationBookException("pas de categorie disponible avec l'identifiant"+" "+categoryId);
	}

	@Override
	public List<Category> getCategoryByLabel(String label) {
		List<Category> cate = categoryRepository.findByLabelLikeIgnoreCase(label);
		if(!cate.isEmpty()) {
			return cate;
		}
		log.error("pas de categorie disponible avec le label"+" "+label);
		throw new AdministrationBookException("pas de categorie disponible avec le label"+" "+label);
	}

	@Override
	public Category updateCategory(Long categoryId, Category category) {
		Optional<Category> cat = categoryRepository.findById(categoryId);
		if(cat.isPresent()) {
			cat.get().setId(category.getId());
			cat.get().setCode(category.getCode());
			cat.get().setLabel(category.getLabel());
			cat.get().setBook(category.getBook());
			Category cate = categoryRepository.save(cat.get());
			
			return cate;
		}else {
			log.error("pas de categorie disponible avec l'identifiant"+" "+categoryId);
			throw new AdministrationBookException("pas de categorie disponible avec l'identifiant"+" "+categoryId);
		}
	}
	
	
}
