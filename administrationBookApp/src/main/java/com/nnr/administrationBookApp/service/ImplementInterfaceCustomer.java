package com.nnr.administrationBookApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.administrationBookApp.enumerate.LoanStatus;
import com.nnr.administrationBookApp.exception.AdministrationBookException;
import com.nnr.administrationBookApp.model.Customer;
import com.nnr.administrationBookApp.model.Loan;
import com.nnr.administrationBookApp.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ImplementInterfaceCustomer implements InterfaceCustomer{
	
	private CustomerRepository customerRepository;
	
	public ImplementInterfaceCustomer(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		if(customer==null) {
			log.error("le customer est null !!!");
			throw new AdministrationBookException("le customer est null !!!");
		}else {
			Customer cust = customerRepository.save(customer);
			return cust;
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customer = customerRepository.findAll();
		if(customer.isEmpty()) {
			log.error("Pas de client disponible dans la base de donnees !!!");
			throw new AdministrationBookException("Pas de client disponible dans la base de donnees !!!");
		}else {
			return customer;
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		if(email==null) {
			log.error("L'adresse email est null !!!");
			throw new AdministrationBookException("L'adresse email est null !!!");
		}
		
		Optional<Customer>  customer = Optional.ofNullable(customerRepository.findByEmail(email));
		if(customer.isPresent()) {
			return customer.get();
		}
		log.error("pas de client avec l'adresse email"+""+email);
		throw new AdministrationBookException("pas de client avec l'adresse email"+""+email);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent()) {
			customerRepository.delete(customer.get());
		}else {
			log.error("pas de client avec l'identifiant"+""+customerId);
			throw new AdministrationBookException("pas de client avec l'identifiant"+""+customerId);
		}
		
	}

	@Override
	public Customer getOneCustomer(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent()) {
			return customer.get();
		}else {
			log.error("pas de client avec l'identifiant"+""+customerId);
			throw new AdministrationBookException("pas de client avec l'identifiant"+""+customerId);
		}
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer customer) {
		Optional<Customer> cust = customerRepository.findById(customerId);
		if(cust.isPresent()) {
			cust.get().setId(customer.getId());
			cust.get().setAdress(customer.getAdress());
			cust.get().setCreatedDate(customer.getCreatedDate());
			cust.get().setEmail(customer.getEmail());
			cust.get().setFirstName(customer.getFirstName());
			cust.get().setLastName(customer.getLastName());
			cust.get().setJob(customer.getJob());
			cust.get().setLoan(customer.getLoan());
			
			Customer newCustomer = customerRepository.save(cust.get());
			
			return newCustomer;
		}else {
			log.error("pas de client avec l'identifiant"+""+customerId);
			throw new AdministrationBookException("pas de client avec l'identifiant"+""+customerId);
		}
	}
	
	@Override
	public List<Loan> getAllOpenLoanByCustomerId(Long customerId){
		List<Loan> finalLoan = new ArrayList<>();
		Optional<Customer> customer =  customerRepository.findById(customerId);
		if(customer.isPresent()) {
			List<Loan> loan = customer.get().getLoan();
			for(int i=0; i<loan.size(); i++) {
				if(loan.get(i).getStatus()==LoanStatus.OPEN) {
					finalLoan.add(loan.get(i));
				}
			}
			return finalLoan;
		}else {
			log.error("pas de client avec l'identifiant"+""+customerId);
			throw new AdministrationBookException("pas de client avec l'identifiant"+""+customerId);
		}
	}
	

}
