package com.nnr.administrationBookApp.service;

import java.util.List;

import com.nnr.administrationBookApp.model.Loan;

public interface InterfaceLoan {
	
	public Loan saveLoan(Loan loan, Long customerId, Long bookId);
	
	public List<Loan> getAllLoan();
	
	public void closeLoan(Long bookId, Long customerId);

}
