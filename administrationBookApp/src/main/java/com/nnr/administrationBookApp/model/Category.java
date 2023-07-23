package com.nnr.administrationBookApp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Category implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "categoryId")
	private Long id;
	
	@NotNull
	private String code;
	
	@NotNull
	private String label;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Book> book = new ArrayList<>();
}
