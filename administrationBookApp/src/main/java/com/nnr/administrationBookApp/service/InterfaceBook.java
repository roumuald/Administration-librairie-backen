package com.nnr.administrationBookApp.service;

import java.util.List;

import com.nnr.administrationBookApp.model.Book;

public interface InterfaceBook {
	
	public Book saveBook(Book book, Long categoryId);
	
	public List<Book> getAllBook();
	
	public List<Book> getAllBookByTitle(String title);
	
	public void deleteBook(Long bookId);
	
	public Book updateBook(Book book, Long bookId);
}
