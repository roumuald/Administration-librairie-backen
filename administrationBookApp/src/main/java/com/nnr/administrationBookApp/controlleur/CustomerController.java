package com.nnr.administrationBookApp.controlleur;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.administrationBookApp.model.Customer;
import com.nnr.administrationBookApp.service.InterfaceCustomer;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
//@Api(tags = "client", description = "Endpoints pour gérer les clients")
public class CustomerController {
	
	private InterfaceCustomer interfaceCustomer;
	
	public CustomerController(InterfaceCustomer interfaceCustomer) {
		super();
		this.interfaceCustomer = interfaceCustomer;
	}


	@RequestMapping(method = RequestMethod.POST, path = "/addCustomer")
	//@ApiOperation("Enregistrement d'un nouveau client")
	public Customer addCustomer(@RequestBody Customer customer) {
		return interfaceCustomer.addCustomer(customer);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allCustomer")
	//@ApiOperation("recuperer la liste de tous les clients")
	public List<Customer> getAllCustomer(){
		return interfaceCustomer.getAllCustomer();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/customerByEmail/{email}")
	//@ApiOperation("recuperer un client par son email")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return interfaceCustomer.getCustomerByEmail(email);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/deleteCustomer/{customerId}")
	//@ApiOperation("suppression d'un client par son identifiant")
	public void deleteCustomer(@PathVariable Long customerId) {
		 interfaceCustomer.deleteCustomer(customerId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getOnCustomer/{customerId}")
	//@ApiOperation("recuperer un client par son identifiant")
	public Customer getOneCustomer(@PathVariable Long customerId) {
		return interfaceCustomer.getOneCustomer(customerId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateCustomer/{customerId}")
	//@ApiOperation("mise a jour d'un client par son identifiant")
	public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
		return interfaceCustomer.updateCustomer(customerId, customer);
	}

}
