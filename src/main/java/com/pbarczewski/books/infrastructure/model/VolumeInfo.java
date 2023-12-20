package com.pbarczewski.books.infrastructure.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class VolumeInfo {

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private String thumbnailUrl;
    private String description;
    private String publishedDate;
    private int pageCount;
    private double averageRating;
    private List<String> authors;
    private List<String> categories;
    private List<IndustryIdentifiers> industryIdentifiers = new ArrayList<>();
    private ReadingModes readingModes;
    private String printType;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IndustryIdentifiers {
        String type;
        String identifier;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ImageLinks {
        private String smallThumbnail;
        private String thumbnail;
    }
}
