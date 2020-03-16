package com.pbarczewski.reader;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pbarczewski.entity.Item;


public class JsonDataReaderTest {
	
	
	private JsonDataReader jsonReader;
	
	
	@Test
	@DisplayName("Method check if list size of items is equal 40")
	public void methodShouldReturnsValueOfFourtAsSizeOfJsonItems() {
		
		//given
		jsonReader = new JsonDataReader();
		
		//when
		jsonReader.readData();
		
		//then
		assertThat(jsonReader.getItems().size(), is(40) );
		
	}
	
	
	@Test
	@DisplayName("List of Items should not be null after calling 'readData' method")
	public void checkIfItemListIsNotNullAfterCallingReadDataMethod() {
		
		//given
		jsonReader = new JsonDataReader();
				
		//when
		jsonReader.readData();
		
		//then
		assertThat(jsonReader.getItems(), is(notNullValue()));
		
	}
	
	@Test
	@DisplayName("List should contains an instances of Item object")
	public void checkIfItemListContainsAnObjectOfItemClass () {
		
		//given
		jsonReader = new JsonDataReader();
						
		//when
		List<Item> listOfItems = jsonReader.readData();
		
		//then
		assertThat(listOfItems.get(0), is(instanceOf(Item.class)));
		
	}

	
	
	
	
	
	
}
