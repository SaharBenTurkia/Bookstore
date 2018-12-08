package com.backendapp.bookstoreapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backendapp.bookstoreapi.model.Book;
import com.backendapp.bookstoreapi.service.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	BookServiceImpl service;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return service.findAll();
	}
	
	@RequestMapping(path="/book/{name}")
	public List<Book> getBookByName(@PathVariable("name") String name) {
		return service.findByName(name);
	}
}
