package com.pbarczewski.entity;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pbarczewski.data.DateDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "isbn" })
public class VolumeInfo {
    @JsonProperty("isbn")
    private String isbn;
    private String title, subtitle, publisher, thumbnailUrl, language, previewLink, description;
    @JsonDeserialize(using = DateDeserializer.class)
    private long publishedDate;
    private int pageCount;
    private double averageRating;
    private List<String> authors, categories;

    public VolumeInfo() {

    }

    @JsonProperty("industryIdentifiers")
    private void unpackISBNFromNastedObject(List<Map<String, String>> industryIdentifiers) {
        for (Map<String, String> iIdentifier : industryIdentifiers) {
            if (iIdentifier.containsValue("ISBN_13")) {
                this.isbn = iIdentifier.get("identifier");
            }
        }
    }

    @JsonProperty("imageLinks")
    private void unpackThumFromNastedObject(Map<String, String> imageLinks) {
        this.thumbnailUrl = imageLinks.get("thumbnail");
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
