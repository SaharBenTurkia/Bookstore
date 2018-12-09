package com.backendapp.bookstoreapi.service;

import java.util.ArrayList;
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
	public List<Book> findByAuthor(String author) {
		return bookDAO.findByAuthor(author);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		List<Book> bookList = bookDAO.findAll();
		List<Book> activeBookList = new ArrayList<Book>();
		
		for (Book book : bookList) {
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}
		return activeBookList;
	}

	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.save(book);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		bookDAO.delete(id);
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		List<Book> bookList = bookDAO.findByTitle(title);
		List<Book> activeBookList = new ArrayList<Book>();
		
		for (Book book : bookList) {
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}
		return activeBookList;
	}
}
