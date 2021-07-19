package com.pbarczewski.data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbarczewski.entity.Item;

public class DataReader {

	private final static String dataPath = "data/books.json";
	public static final DataReader INSTANCE = new DataReader();

	private DataReader() {
		if (INSTANCE != null) {
			throw new IllegalArgumentException("Class is already existed");
		}
	}

	public List<Item> readData() {
		List<Item> items = new ArrayList<>();
		try {
			items = Arrays.asList(new ObjectMapper().treeToValue(new ObjectMapper()
					.readTree(new File(this.getClass().getClassLoader().getResource(dataPath).getFile()))
					.get("items"), Item[].class));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return items;
	}
}
