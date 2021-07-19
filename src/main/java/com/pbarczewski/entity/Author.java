package com.pbarczewski.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
	
	private String name;
	private double averageRating;
	@JsonIgnore
	private int count;
	
	public String getName() {
		return name;
	}
	
	public Author(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public Author check(List<Item> list) {
		for(Item item : list) {
			if(item.getVolumeInfo().getAuthors() != null && item.getVolumeInfo().getAuthors().contains(this.name)) {
				this.averageRating += item.getVolumeInfo().getAverageRating();
				this.count++;
			}
		}
		if(this.averageRating != 0) {
			this.averageRating = this.averageRating / this.count;
		}
		return this;
	}
}