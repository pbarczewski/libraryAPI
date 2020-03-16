package com.pbarczewski.booksService;

import com.pbarczewski.entity.Item;

public interface SingleBook {
	
	Item findSingleBook(String isbn);

}
