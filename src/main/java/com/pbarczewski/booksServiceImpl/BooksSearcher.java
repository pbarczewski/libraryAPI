package com.pbarczewski.booksServiceImpl;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbarczewski.booksService.BooksByCategory;
import com.pbarczewski.booksService.BooksFinder;
import com.pbarczewski.booksService.SingleBook;
import com.pbarczewski.entity.Item;
import com.pbarczewski.exception.CustomizeException;
import com.pbarczewski.reader.JsonDataReader;



@Service
public class BooksSearcher implements BooksFinder, BooksByCategory, SingleBook  {

	private final JsonDataReader jsonDataReader;
	private final List<Item> items;
	
	@Autowired
	public BooksSearcher(JsonDataReader itemReader) {
		this.jsonDataReader = itemReader;
		items = itemReader.readData();
	}
	
	@Override
	public List<Item> allBooks() {
		return items;
	}

	@Override
	public List<Item> findBooksByCategory(String category) {
		List<Item> booksWithSpecificCategory = new ArrayList<>();
		if(category != "") {
		  booksWithSpecificCategory = items.stream() 
				  .filter(x -> x.getVolumeInfo().getCategories() != null)
				  .filter(singleItem ->
		  singleItem.getVolumeInfo().getCategories().contains(category))
		  .collect(Collectors.toList());
		 
		} else {
			booksWithSpecificCategory = items.stream() 
					  .filter(x -> x.getVolumeInfo().getCategories() == null)
			  .collect(Collectors.toList());
			
		}
		if(booksWithSpecificCategory.size() == 0) {
			throw new CustomizeException("Name of category: '" + category + "' doesn't exist");
		}
		
		 return booksWithSpecificCategory;
		
	}

	@Override
	public Item findSingleBook(String isbn) {
		Item item = items.stream()
				.filter(singleItem -> singleItem.getVolumeInfo().getIsbn().equals(isbn))
				.findFirst().orElse(null);
		
		if(item == null) {
			throw new CustomizeException("There is no book with isbn: " + isbn);
		}
		
		return item;
	}
	
	
	
	 
}
