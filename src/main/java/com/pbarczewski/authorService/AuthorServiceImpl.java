package com.pbarczewski.authorService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.pbarczewski.data.DataReader;
import com.pbarczewski.entity.Author;
import com.pbarczewski.entity.Item;

public class AuthorServiceImpl implements findAllAuthors {
	
	private List<Author> authors = new ArrayList<>();
	
	@Override
	public List<Author> findAllAuthors() { 
			authors = DataReader.INSTANCE.readData()
			.stream()
			.filter(x-> x.getVolumeInfo().getAuthors() != null)
			.flatMap(x -> x.getVolumeInfo().getAuthors().stream())
			.distinct()
			.map(y -> {
				return new Author(y);
			})
			.map(x -> x.check(DataReader.INSTANCE.readData()))
			.collect(Collectors.toList());
			return authors;
	}
	
	public void setAvarege() {
				Set<Author> authors2 = new HashSet<Author>(authors);
				
				authors2.stream()
				.forEach(x -> System.out.println(x.getName() + ": " + x.getAverageRating() + " / " + x.getCount()));
				
	}

	
		
	}

