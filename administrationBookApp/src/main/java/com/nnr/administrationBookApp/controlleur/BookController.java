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

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
//@Api(tags = "Livre", description = "Endpoints pour gérer les livres")
public class BookController {
	
	private InterfaceBook interfaceBook;
	
	public BookController(InterfaceBook interfaceBook) {
		super();
		this.interfaceBook = interfaceBook;
	}

	@RequestMapping(method = RequestMethod.POST, path ="/addBook/{categoryId}")
	//@ApiOperation("Enregistrement d'un livre en fonction de la categorie")
	public Book saveBook(@RequestBody Book book, @PathVariable Long categoryId) {
		return interfaceBook.saveBook(book, categoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/allBooks")
	//@ApiOperation("Obtenir la liste de tous les livres")
	public List<Book> getAllBook(){
		return interfaceBook.getAllBook();
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/allBookByTitle/{title}")
	//@ApiOperation("recherche de livre par leur titre")
	public List<Book> getAllBookByTitle(@PathVariable String title){
		return interfaceBook.getAllBookByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path ="/deleteBook/{bookId}")
	//@ApiOperation("supression d'un livre par son identifiant")
	public void deleteBook(@PathVariable Long bookId) {
		interfaceBook.deleteBook(bookId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/updateBook/{bookId}")
	//@ApiOperation("mise a jour de livre")
	public Book updateBook(@RequestBody Book newBook, @PathVariable Long bookId) {
		return interfaceBook.updateBook(newBook, bookId);
	}

}
