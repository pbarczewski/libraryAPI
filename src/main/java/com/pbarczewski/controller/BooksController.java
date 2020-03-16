package com.pbarczewski.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbarczewski.booksServiceImpl.BooksSearcher;
import com.pbarczewski.entity.Item;
import com.pbarczewski.entity.VolumeInfo;
import com.pbarczewski.exception.CustomizeException;
import com.pbarczewski.reader.JsonDataReader;


/**
 * This class is a main rest controller of the project.
 * 
 * @author Patryk Barczewski
 * @version 0.0.1-SNAPSHOT 05/05/2019
 */
@RestController
@RequestMapping("/api")
public class BooksController {

	
	private final BooksSearcher jsonReader;

	
	@Autowired
	public BooksController(BooksSearcher jsonReader) {
		this.jsonReader = jsonReader;
	}


	@GetMapping("/books")
	public List<Item> books(@QueryParam("category") String category){
		if(category == null) {
			return jsonReader.allBooks();
		}
		return jsonReader.findBooksByCategory(category);
	}
	
	@GetMapping("/books/{isbn}")
	public Item singleBook(@PathVariable String isbn){
		return jsonReader.findSingleBook(isbn);
	}

}
