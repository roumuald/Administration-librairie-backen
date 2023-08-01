package com.nnr.administrationBookApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.administrationBookApp.enumerate.LoanStatus;
import com.nnr.administrationBookApp.exception.AdministrationBookException;
import com.nnr.administrationBookApp.model.Book;
import com.nnr.administrationBookApp.model.Customer;
import com.nnr.administrationBookApp.model.Loan;
import com.nnr.administrationBookApp.repository.BookRepository;
import com.nnr.administrationBookApp.repository.CustomerRepository;
import com.nnr.administrationBookApp.repository.LoanRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ImplementInterfaceLoan implements InterfaceLoan{
	
	private LoanRepository loanRepository;
	private CustomerRepository customerRepository;
	private BookRepository bookRepository;
	
	public ImplementInterfaceLoan(LoanRepository loanRepository, CustomerRepository customerRepository,
			BookRepository bookRepository) {
		super();
		this.loanRepository = loanRepository;
		this.customerRepository = customerRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public Loan saveLoan(Loan loan, Long customerId, Long bookId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		Optional<Book> book = bookRepository.findById(bookId);
		if(customer.isPresent()&&book.isPresent()) {
			loan.setBook(book.get());
			loan.setCustomer(customer.get());
			
			Loan finalLoan = loanRepository.save(loan);
			return finalLoan;
		}else {
			log.error("Impossible de creer un pret sans le livre et le client");
			throw new AdministrationBookException("Impossible de creer un pret sans le livre et le client");
		}
	}

	@Override
	public List<Loan> getAllLoan() {
		List<Loan> loan = loanRepository.findAll();
		if(loan.isEmpty()) {
			log.error("Aucun pret disponible en base de donnees");
			throw new AdministrationBookException("Aucun pret disponible en base de donnees");
		}else {
			return loan;
		}
		
	}

	@Override
	public void closeLoan(Long bookId, Long customerId) {
	    Optional<Book> book = bookRepository.findById(bookId);
	    Optional<Customer> customer = customerRepository.findById(customerId);
	    Loan loan = loanRepository.findLoanByCustomerIdBookIdAndStatus(bookId, customerId, LoanStatus.OPEN);
	    if (customer.isPresent() && book.isPresent()) {
	    	loan.setBook(book.get());
	    	loan.setCustomer(customer.get());
	    	loan.setStatus(LoanStatus.CLOSE);
	        loanRepository.save(loan);
	    }
	}
	
	@Override
	public void openLoan(Long bookId, Long customerId) {
		 	Optional<Book> book = bookRepository.findById(bookId);
		    Optional<Customer> customer = customerRepository.findById(customerId);
		    Loan loan = loanRepository.findLoanByCustomerIdBookIdAndStatus(bookId, customerId, LoanStatus.CLOSE);
		    if (customer.isPresent() && book.isPresent()) {
		    	loan.setBook(book.get());
		    	loan.setCustomer(customer.get());
		    	loan.setStatus(LoanStatus.OPEN);
		        loanRepository.save(loan);
		    }
	}	

	@Override
	public List<Loan> findLoansByEmailAndStatus(String email, LoanStatus status) {
		List<Loan> loan = loanRepository.getAllOpenLoansOfThisCustomer(email, status);
		if(loan.isEmpty()) {
			log.error("Aucun pret disponible en base de donnees");
			throw new AdministrationBookException("Aucun pret disponible en base de donnees");
		}else {
			return loan;
		}
	}

	@Override
	public Customer getCustomerByLoanId(Long loanId) {
		Optional<Loan> loan = loanRepository.findById(loanId);
		if(loan.isPresent()) {
			Customer customer = loan.get().getCustomer();
			return customer;
		}
		log.error("pas de pret disponible avec l'identifiant"+" "+ loanId);
		throw new AdministrationBookException("pas de pret disponible avec l'identifiant"+" "+ loanId);
	}
	
}
