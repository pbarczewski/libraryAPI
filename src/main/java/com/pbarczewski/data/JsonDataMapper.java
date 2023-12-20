package com.pbarczewski.data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbarczewski.books.infrastructure.model.ItemEntity;

public class JsonDataMapper {

	private final static String dataPath = "data/books.json";
	public static final JsonDataMapper INSTANCE = new JsonDataMapper();

	private JsonDataMapper() {
		if (INSTANCE != null) {
			throw new IllegalArgumentException("Class is already existed");
		}
	}

	public List<ItemEntity> readData() {
		List<ItemEntity> itemEntities = new ArrayList<>();
		try {
			itemEntities = Arrays.asList(new ObjectMapper().treeToValue(new ObjectMapper()
					.readTree(new File(this.getClass().getClassLoader().getResource(dataPath).getFile()))
					.get("items"), ItemEntity[].class));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return itemEntities;
	}
}
