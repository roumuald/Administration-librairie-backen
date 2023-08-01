package com.nnr.administrationBookApp.controlleur;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.administrationBookApp.enumerate.LoanStatus;
import com.nnr.administrationBookApp.model.Customer;
import com.nnr.administrationBookApp.model.Loan;
import com.nnr.administrationBookApp.service.InterfaceLoan;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
//@Api(tags = "Pret", description = "Endpoints pour gérer les prets")
public class LoanController {
	
	private InterfaceLoan interfaceLoan;
	
	public LoanController(InterfaceLoan interfaceLoan) {
		super();
		this.interfaceLoan = interfaceLoan;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/addLoan/{customerId}/{bookId}")
	//@ApiOperation("Enregistrement d'un pret en fonction du livre et du client")
	public Loan saveLoan(@RequestBody Loan loan, @PathVariable Long customerId, @PathVariable Long bookId) {
		loan.setStartDate(new Date());
		loan.setStatus(LoanStatus.OPEN);
		return interfaceLoan.saveLoan(loan, customerId, bookId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allLoans")
	//@ApiOperation("recuperer la liste de prets")
	public List<Loan> getAllLoan(){
		return interfaceLoan.getAllLoan();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allOpenLoansOfThisCustomer/{email}/{status}")
	//@ApiOperation("recuperer les prets d'un utilisateur en fonction de son statut")
	public List<Loan> findLoansByEmailAndStatus(@PathVariable String email, @PathVariable LoanStatus status) {
		return interfaceLoan.findLoansByEmailAndStatus(email, status);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/closeLoan/{bookId}/{customerId}")
	//@ApiOperation("cloturer un pret pour un utilisateur et un livre")
	public void closeLoan(@PathVariable Long bookId, @PathVariable Long customerId) {
		interfaceLoan.closeLoan(bookId, customerId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/openLoan/{bookId}/{customerId}")
	//@ApiOperation("ouverture d'un pret pour un utilisateur et un livre")
	public void openLoan(@PathVariable Long bookId, @PathVariable Long customerId) {
		interfaceLoan.openLoan(bookId, customerId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/customerByloanId/{loanId}")
	//@ApiOperation("Avoir un client en fonction de l'identifiant de pret")
	public Customer getCustomerByLoanId(@PathVariable Long loanId) {
		return interfaceLoan.getCustomerByLoanId(loanId);
	}

}
