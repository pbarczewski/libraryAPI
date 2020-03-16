package com.pbarczewski.booksService;

import java.util.List;

import com.pbarczewski.entity.Item;

public interface BooksByCategory {

	List<Item> findBooksByCategory(String category);
	
}
