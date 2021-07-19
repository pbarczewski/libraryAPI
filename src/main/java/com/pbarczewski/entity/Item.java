package com.pbarczewski.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pbarczewski.deserializers.IsbnDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = IsbnDeserializer.class)
public class Item {
    private String id;
    @JsonValue
    private VolumeInfo volumeInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}