package com.backendapp.bookstoreapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backendapp.bookstoreapi.model.Book;
import com.backendapp.bookstoreapi.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Book addBook(@RequestBody Book book) {
		return service.save(book);
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return service.findAll();
	}
	
	@RequestMapping(path="/{name}")
	public List<Book> getBookByName(@PathVariable("name") String name) {
		return service.findByName(name);
	}
}
