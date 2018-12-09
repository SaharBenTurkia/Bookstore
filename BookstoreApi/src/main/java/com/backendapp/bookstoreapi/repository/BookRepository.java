package com.backendapp.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backendapp.bookstoreapi.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	// @Query("SELECT b FROM Book b WHERE b.id :=id")
	public Book findById(Long id);
	public List<Book> findByAuthor(String author);
	public List<Book> findByTitle(String title);
}
