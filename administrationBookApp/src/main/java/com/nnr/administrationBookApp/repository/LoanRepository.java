package com.nnr.administrationBookApp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nnr.administrationBookApp.enumerate.LoanStatus;
import com.nnr.administrationBookApp.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	public List<Loan> findByEndDateBefore(Date maxEndDate);
    
//    @Query("SELECT lo "
//         + "FROM Loan lo "
//         + "INNER JOIN lo.pk.customer c "
//         + "WHERE UPPER(c.email) = UPPER(?1) "
//         + "   AND lo.status = ?2 ")
//    public List<Loan> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);

}
