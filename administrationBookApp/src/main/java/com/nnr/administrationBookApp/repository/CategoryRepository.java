package com.nnr.administrationBookApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.administrationBookApp.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	public List<Category> findByLabelLikeIgnoreCase(String label);

}
