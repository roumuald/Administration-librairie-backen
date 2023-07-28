package com.nnr.administrationBookApp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nnr.administrationBookApp.enumerate.LoanStatus;
import com.nnr.administrationBookApp.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	public List<Loan> findByEndDateBefore(Date maxEndDate);
    
    @Query("SELECT l FROM Loan l JOIN l.customer c WHERE c.email = :email AND l.status = :status")
    public List<Loan> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);
    
    @Query("SELECT l FROM Loan l WHERE l.customer.id = :customerId AND l.book.id = :bookId AND l.status = :status")
    public Loan findLoanByCustomerIdBookIdAndStatus(@Param("customerId") Long customerId, @Param("bookId") Long bookId, @Param("status") LoanStatus status);
    
  
}
