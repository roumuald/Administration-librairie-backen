package com.nnr.administrationBookApp.controlleur;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.administrationBookApp.model.Book;
import com.nnr.administrationBookApp.model.Category;
import com.nnr.administrationBookApp.service.InterfaceCategory;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
//@Api(tags = "Livre", description = "Endpoints pour gérer les livres")
public class CategoryController {
	
	private InterfaceCategory interfaceCategory;
	
	public CategoryController(InterfaceCategory interfaceCategory) {
		super();
		this.interfaceCategory = interfaceCategory;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/addCategory")
	//@ApiOperation("Enregistrer une nouvelle categorie")
	public Category addCategory(@RequestBody Category category) {
		return interfaceCategory.addCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getAllCategory")
	//@ApiOperation("recuperer la liste de categorie")
	public List<Category> getAllCategory(){
		return interfaceCategory.getAllCategory();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/deleteCategorie/{categoryId}")
	//@ApiOperation("suppression de categorie")
	public void deleteCategory(@PathVariable Long categoryId) {
		interfaceCategory.deleteCategory(categoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/bookByCategory/{categoryId}")
	//@ApiOperation("recuperer la liste de livres par categorie")
	public List<Book> getBookByCategoryId(@PathVariable Long categoryId){
		return interfaceCategory.getBookByCategoryId(categoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getOneCategory/{categoryId}")
	//@ApiOperation("recuperer une categorie par son identifiant")
	public Category getOnCategory(@PathVariable Long categoryId) {
		return interfaceCategory.getOnCategory(categoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allCategoryByLabel/{label}")
	//@ApiOperation("recuperer la liste de categorie par son label")
	public List<Category> getCategoryByLabel(@PathVariable String label){
		return interfaceCategory.getCategoryByLabel(label);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateCategory/{categoryId}")
	//@ApiOperation("mise a jour d'une categorie")
	public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
		return interfaceCategory.updateCategory(categoryId, category);
	}

}
