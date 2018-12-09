package com.backendapp.bookstoreapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendapp.bookstoreapi.model.Book;
import com.backendapp.bookstoreapi.repository.BookRepository;


public interface BookService {

	public List<Book> findAll();
	
	public Book findById(Long id);
	
	public List<Book> findByName(String name);
	
	public List<Book> findByAuthor(String author);
	
	List<Book> findByTitle(String title);
	
	void delete(Long id);
	
	Book save(Book book);
}
