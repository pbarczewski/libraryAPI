package com.pbarczewski.deserializers;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbarczewski.entity.Item;
import com.pbarczewski.entity.VolumeInfo;

public class IsbnDeserializer extends JsonDeserializer<Item> {

    @Override
    public Item deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Item item = new Item();
        JsonNode itemNode = parser.readValueAsTree();
        VolumeInfo volumeInfo = new ObjectMapper().treeToValue(itemNode.get("volumeInfo"), VolumeInfo.class);
        if (volumeInfo.getIsbn() == null) {
            volumeInfo.setIsbn(itemNode.get("id").asText());
        }
        item.setVolumeInfo(volumeInfo);
        return item;
    }
}
