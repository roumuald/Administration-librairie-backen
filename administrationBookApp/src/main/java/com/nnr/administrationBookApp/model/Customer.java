package com.nnr.administrationBookApp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "customerId")
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdDate;
	
	private String firstName;
	
	@NotNull
	private String lastName;
	
	private String job;
	
	@NotNull
	private String email;
	
	@NotNull
	private String adress;

	@OneToMany(mappedBy = "customer")
	private List<Loan> loan = new ArrayList<>();
	
}
