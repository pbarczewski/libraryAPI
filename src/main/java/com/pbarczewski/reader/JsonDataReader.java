package com.pbarczewski.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbarczewski.RestbooksApplication;
import com.pbarczewski.entity.Item;
import com.pbarczewski.entity.VolumeInfo;

@Service
public class JsonDataReader {
	
	private List<Item> items = new ArrayList<>();
	
	public JsonDataReader() {
		
	}
	
	public List<Item> readData() {
		try {
			items = Arrays.asList(new ObjectMapper().treeToValue(
					new ObjectMapper().readTree(new File(
							this.getClass()
							.getClassLoader()
							.getResource("data/books.json")
							.getFile()
							)).get("items"), 
							Item[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;	
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
