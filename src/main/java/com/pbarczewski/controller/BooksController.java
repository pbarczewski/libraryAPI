package com.pbarczewski.controller;
import java.util.List;
import java.util.Set;

import javax.ws.rs.QueryParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbarczewski.authorService.AuthorServiceImpl;
import com.pbarczewski.booksService.BooksServiceImpl;
import com.pbarczewski.data.DataReader;
import com.pbarczewski.entity.Author;
import com.pbarczewski.entity.Item;

@RestController
@RequestMapping("/api")
public class BooksController {
	
	private final static BooksServiceImpl serviceImpl = new BooksServiceImpl();
	private final static AuthorServiceImpl authorServiceImpl = new AuthorServiceImpl();
	
	@GetMapping("/authors")
	public List<Author> allAuthors2() {
		return authorServiceImpl.findAllAuthors();
	}
	
	@GetMapping("/books")
	public List<Item> allBooks(@QueryParam("category") String category) {
		if(category == null) {
			return serviceImpl.allBooks();
		} else {
			return serviceImpl.findBooksWithinCategory(category);
		}
	}
	
	@GetMapping("/books/{isbnNumber}")
	public Item singleBook(@PathVariable String isbnNumber) {
		return serviceImpl.findSingleBook(isbnNumber);
	}
}
