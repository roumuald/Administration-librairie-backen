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

@RestController
@CrossOrigin("*")
public class CustomerController {
	
	private InterfaceCustomer interfaceCustomer;
	
	public CustomerController(InterfaceCustomer interfaceCustomer) {
		super();
		this.interfaceCustomer = interfaceCustomer;
	}


	@RequestMapping(method = RequestMethod.POST, path = "/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return interfaceCustomer.addCustomer(customer);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allCustomer")
	public List<Customer> getAllCustomer(){
		return interfaceCustomer.getAllCustomer();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/customerByEmail/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return interfaceCustomer.getCustomerByEmail(email);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable Long customerId) {
		 interfaceCustomer.deleteCustomer(customerId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getOnCustomer/{customerId}")
	public Customer getOneCustomer(@PathVariable Long customerId) {
		return interfaceCustomer.getOneCustomer(customerId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateCustomer/{customerId}")
	public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
		return interfaceCustomer.updateCustomer(customerId, customer);
	}

}
