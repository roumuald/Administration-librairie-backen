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
import com.nnr.administrationBookApp.model.Loan;
import com.nnr.administrationBookApp.service.InterfaceLoan;

@RestController
@CrossOrigin("*")
public class LoanController {
	
	private InterfaceLoan interfaceLoan;
	
	public LoanController(InterfaceLoan interfaceLoan) {
		super();
		this.interfaceLoan = interfaceLoan;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/addLoan/{customerId}/{bookId}")
	public Loan saveLoan(@RequestBody Loan loan, @PathVariable Long customerId, @PathVariable Long bookId) {
		loan.setStartDate(new Date());
		loan.setStatus(LoanStatus.OPEN);
		return interfaceLoan.saveLoan(loan, customerId, bookId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allLoans")
	public List<Loan> getAllLoan(){
		return interfaceLoan.getAllLoan();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allOpenLoansOfThisCustomer/{email}/{status}")
	public List<Loan> findLoansByEmailAndStatus(@PathVariable String email, @PathVariable LoanStatus status) {
		return interfaceLoan.findLoansByEmailAndStatus(email, status);
	}

}
