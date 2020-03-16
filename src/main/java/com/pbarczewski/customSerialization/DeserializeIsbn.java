package com.pbarczewski.customSerialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbarczewski.entity.Item;
import com.pbarczewski.entity.VolumeInfo;
import com.pbarczewski.reader.JsonDataReader;

public class DeserializeIsbn extends JsonDeserializer<Item> {

	@Override
	public Item deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		JsonNode itemNode = p.readValueAsTree();

		Item item = new Item();

		VolumeInfo volumeInfo = new ObjectMapper().treeToValue(itemNode.get("volumeInfo"), VolumeInfo.class);

		if (volumeInfo.getIsbn() == null) {
			volumeInfo.setIsbn(itemNode.get("id").asText());
		}
		
		item.setVolumeInfo(volumeInfo);

		return item;
	}

}
