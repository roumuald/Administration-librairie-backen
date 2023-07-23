package com.nnr.administrationBookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.administrationBookApp.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

}
