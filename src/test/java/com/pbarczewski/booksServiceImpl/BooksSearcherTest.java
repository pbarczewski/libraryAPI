package com.pbarczewski.booksServiceImpl;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.pbarczewski.entity.Item;
import com.pbarczewski.exception.CustomizeException;
import com.pbarczewski.reader.JsonDataReader;


public class BooksSearcherTest {
	
	
	private static BooksSearcher booksSearcher;
	private static JsonDataReader jsonDataReader;
	
	@BeforeAll
	static void init() {
		jsonDataReader = new JsonDataReader();
		booksSearcher = new BooksSearcher(jsonDataReader);
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = {"Fantasy", "Science fiction", "Biology"}) 
	@DisplayName("Customize Exception should be thrown if there "
			+ "is not any books with indicated category")
	void exceptionShouldBeThrownIfCategoryDoesNotMatchToListContent(String category) {
		assertThrows(CustomizeException.class, ()-> booksSearcher.findBooksByCategory(category));
		
	}
	
	@Test
	@DisplayName("Category field from single Book should returns empty if "
			+ "requestParam is blank")
	void itemListShouldContainsObjectsWithNoCategorySet() {
		
		//given
		String requestParam = "";
		List<Item> booksWithSpecificCategory = booksSearcher.findBooksByCategory(requestParam);
			
		//when
		List<String> categories = booksWithSpecificCategory.get(0).getVolumeInfo().getCategories();
		
		//then
		assertThat(categories, is(nullValue()));
		assertThat(booksWithSpecificCategory, hasSize(0));
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"123456", "abcdefg", "987654321", "IsbnFromDreams"}) 
	@DisplayName("Customize Exception should be thrown if book with suitable isbn is not found")
	void test(String isbn) {
		assertThrows(CustomizeException.class, ()-> booksSearcher.findSingleBook(isbn));
	}
	
	
	 
	

}
