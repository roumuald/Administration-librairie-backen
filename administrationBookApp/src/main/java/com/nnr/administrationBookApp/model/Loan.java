package com.nnr.administrationBookApp.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.nnr.administrationBookApp.enumerate.LoanStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	
	private LoanStatus status;

	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
   
	@ManyToOne(fetch = FetchType.EAGER)
	private Book book;

}
