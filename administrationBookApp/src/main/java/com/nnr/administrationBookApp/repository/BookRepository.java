package com.nnr.administrationBookApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.administrationBookApp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	public List<Book> findByTitleLikeIgnoreCase(String title);

}
