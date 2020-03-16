package com.pbarczewski.booksService;

import java.util.List;

import com.pbarczewski.entity.Item;
import com.pbarczewski.reader.JsonDataReader;

public interface BooksFinder {

	List<Item> allBooks();
	
	
}
