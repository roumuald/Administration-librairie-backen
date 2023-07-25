package com.nnr.administrationBookApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.administrationBookApp.exception.AdministrationBookException;
import com.nnr.administrationBookApp.model.Book;
import com.nnr.administrationBookApp.model.Category;
import com.nnr.administrationBookApp.repository.BookRepository;
import com.nnr.administrationBookApp.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ImplementInterfaceBook implements InterfaceBook{
	
	private CategoryRepository categoryRepository;
	private BookRepository bookRepository;
	
	public ImplementInterfaceBook(CategoryRepository categoryRepository, BookRepository bookRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public Book saveBook(Book book, Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isPresent()) {
			book.setCategory(category.get());
			book.setStock(book.getTotalExamp());
			Book finalBook = bookRepository.save(book);
			
			return finalBook;
		}
		log.error("pas de categorie disponible avec le label"+" "+categoryId);
		throw new AdministrationBookException("pas de categorie disponible avec le label"+" "+categoryId);
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> book = bookRepository.findAll();
		if(book.isEmpty()) {
			log.error("Aucun livre disponible a la base de donnees");
			throw new AdministrationBookException("Aucun livre disponible a la base de donnees");
		}
		return book;
	}

	@Override
	public List<Book> getAllBookByTitle(String title) {
		List<Book> book = bookRepository.findByTitleLikeIgnoreCase(title);
		if(book.isEmpty()) {
			log.error("Aucun livre disponible a la base de donnees avec le titre"+""+title);
			throw new AdministrationBookException("Aucun livre disponible a la base de donnees avec le titre"+""+title);
		}else {
			return book;
		}
		
	}

}
