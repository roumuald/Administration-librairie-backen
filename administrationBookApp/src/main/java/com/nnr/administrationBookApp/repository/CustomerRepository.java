package com.nnr.administrationBookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.administrationBookApp.model.Category;

@Repository
public interface CustomerRepository extends JpaRepository<Category, Long>{

}
