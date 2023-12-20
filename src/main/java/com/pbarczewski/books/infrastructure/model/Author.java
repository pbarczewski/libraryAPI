package com.pbarczewski.books.infrastructure.model;
import lombok.Data;

@Data
public class Author {

	private String name;
	private double averageRating;
	private int count;
}
