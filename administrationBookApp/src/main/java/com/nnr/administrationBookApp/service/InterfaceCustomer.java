package com.nnr.administrationBookApp.service;

import java.util.List;

import com.nnr.administrationBookApp.model.Customer;
import com.nnr.administrationBookApp.model.Loan;

public interface InterfaceCustomer {
	
	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAllCustomer();
	
	public Customer getCustomerByEmail(String email);
	
	public void deleteCustomer(Long customerId);
	
	public Customer getOneCustomer(Long customerId);
	
	public Customer updateCustomer(Long customerId, Customer customer);
	
	public List<Loan> getAllOpenLoanByCustomerId(Long customerId);

}
