package com.nnr.administrationBookApp.controlleur;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.administrationBookApp.model.Book;
import com.nnr.administrationBookApp.service.InterfaceBook;

@RestController
@CrossOrigin("*")
public class BookController {
	
	private InterfaceBook interfaceBook;
	
	public BookController(InterfaceBook interfaceBook) {
		super();
		this.interfaceBook = interfaceBook;
	}

	@RequestMapping(method = RequestMethod.POST, path ="/addBook/{categoryId}")
	public Book saveBook(@RequestBody Book book, @PathVariable Long categoryId) {
		return interfaceBook.saveBook(book, categoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/allBooks")
	public List<Book> getAllBook(){
		return interfaceBook.getAllBook();
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/allBookByTitle/{title}")
	public List<Book> getAllBookByTitle(@PathVariable String title){
		return interfaceBook.getAllBookByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path ="/deleteBook/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {
		interfaceBook.deleteBook(bookId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/updateBook/{bookId}")
	public Book updateBook(@RequestBody Book newBook, @PathVariable Long bookId) {
		return interfaceBook.updateBook(newBook, bookId);
	}

}
