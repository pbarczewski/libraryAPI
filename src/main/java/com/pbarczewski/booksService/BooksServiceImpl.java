package com.pbarczewski.booksService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.pbarczewski.data.DataReader;
import com.pbarczewski.entity.Item;
import com.pbarczewski.exceptions.CustomizeException;
public class BooksServiceImpl implements GetAllBooks, findSingleBook, findBooksWithinCategory {

	@Override
	public List<Item> allBooks() {
		return DataReader.INSTANCE.readData();
	}
	
	@Override
	public Item findSingleBook(String isbnNumber) {
		Item book = DataReader.INSTANCE.readData().stream()
				.filter(singleBook -> singleBook.getVolumeInfo().getIsbn().equals(isbnNumber)).findFirst().orElse(null);
		if (book != null) {
			return book;
		}
		throw new CustomizeException("Book with isbn " + isbnNumber + " doesn't exist");
	}

	@Override
	public List<Item> findBooksWithinCategory(String category) {
		List<Item> booksWithinCategory = new ArrayList<>();
		if (category != "") {
		  booksWithinCategory = DataReader.INSTANCE.readData().stream() 
				 .filter(singleItem -> singleItem.getVolumeInfo().getCategories() != null)
				 .filter(singleItem -> singleItem.getVolumeInfo().getCategories().contains(category))
				 .collect(Collectors.toList());
		} else {
		  booksWithinCategory = 
				  DataReader.INSTANCE.readData().stream() 
				 .filter(x -> x.getVolumeInfo().getCategories() == null)
				 .collect(Collectors.toList());
		} if (booksWithinCategory.size() == 0) {
			throw new com.pbarczewski.exceptions.CustomizeException("Category: '" + category + "' doesn't exist");
		}
		 return booksWithinCategory;
	}
}
