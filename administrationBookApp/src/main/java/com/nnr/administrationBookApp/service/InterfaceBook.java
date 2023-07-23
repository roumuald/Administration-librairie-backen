package com.nnr.administrationBookApp.service;

import java.util.List;

import com.nnr.administrationBookApp.model.Book;

public interface InterfaceBook {
	
	public Book saveBook(Book book, Long categoryId);
    
    public Book updateBook(Book book);
    
    public void deleteBook(Integer bookId);
    
    public List<Book> findBooksByTitleOrPartTitle(String title);
    
    public Book findBookByIsbn(String isbn);
    
    public boolean checkIfIdexists(Integer id);
    
    public List<Book> getBooksByCategory(String codeCategory);

}
