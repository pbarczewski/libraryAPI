package com.pbarczewski.booksService;

import java.util.List;

import com.pbarczewski.entity.Item;

public interface findBooksWithinCategory {
	List<Item> findBooksWithinCategory(String category);
}
