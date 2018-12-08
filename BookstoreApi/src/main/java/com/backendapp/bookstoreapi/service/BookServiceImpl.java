package com.backendapp.bookstoreapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendapp.bookstoreapi.model.Book;
import com.backendapp.bookstoreapi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookDAO;
	
	public Book findById(Long id) {
		return bookDAO.findById(id);
	}
	
	public List<Book> findByName(String name) {
		return bookDAO.findByName(name);
	}
	public List<Book> findByAuthor(String author) {
		return bookDAO.findByAuthor(author);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDAO.findAll();
	}
}
