package com.pbarczewski.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pbarczewski.customSerialization.DeserializeDate;
import com.pbarczewski.customSerialization.DeserializeIsbn;

/**
 * This is a book class to hold the informations about single book record
 * 
 * @author Patryk Barczewski
 * @version 0.0.1-SNAPSHOT 05/05/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "isbn" })
public class VolumeInfo {

	@JsonProperty("isbn")
	private String isbn;
	private String title, subtitle, publisher, thumbnailUrl, language, previewLink, description;
	@JsonDeserialize(using = DeserializeDate.class)
	private long publishedDate;
	private int pageCount;
	private double averageRating;
	private List<String> authors, categories;


	/**
	 * No-argument constructor initializes instance variables to null
	 * 
	 * @see #setIsbn(String)
	 * @see #setTitle(String)
	 * @see #setSubtitle(String)
	 * @see #setPublisher(String)
	 * @see #setThumbnailUrl(String)
	 * @see #setLanguage(String)
	 * @see #setPreviewLink(String)
	 * @see #setDescription(String)
	 * @see #setPublishedDate(long)
	 */

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

	/*
	 * @JsonProperty("industryIdentifiers") private void
	 * unpackISBNFromNastedObject(List<Map<String, String>> industryIdentifiers) {
	 * for (Map<String, String> iIdentifier : industryIdentifiers) { if
	 * (iIdentifier.containsValue("ISBN_13")) { this.isbn =
	 * iIdentifier.get("identifier"); } } }
	 */

	@JsonProperty("imageLinks")
	private void unpackThumFromNastedObject(Map<String, String> imageLinks) {
		this.thumbnailUrl = imageLinks.get("thumbnail");
	}

	/**
	 * Gets the isbn number
	 * 
	 * @return a <code>string</code> specifying the isbn number
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the isbn number
	 * 
	 * @param isbn the isbn number
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the title
	 * 
	 * @return a <code>string</code> specifying the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title
	 * 
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the subtitle
	 * 
	 * @return a <code>string</code> specifying the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Sets the subtitle
	 * 
	 * @param subtitle the subtitle
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * Gets the publisher
	 * 
	 * @return a <code>string</code> specifying the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Sets the publisher
	 * 
	 * @param publisher the publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Gets the published date
	 * 
	 * @return a <code>long</code> specifying the published date
	 */
	public long getPublishedDate() {
		return publishedDate;
	}

	/**
	 * Set the published date
	 * 
	 * @param publishedDate the published date
	 */
	public void setPublishedDate(long publishedDate) {
		this.publishedDate = publishedDate;
	}

	/**
	 * Gets the page count
	 * 
	 * @return a <code>int</code> specifying the page count
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * Sets the page count
	 * 
	 * @param pageCount the page count
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * Gets the thumbnail url
	 * 
	 * @return a <code>string</code> specifying the thumbnail url
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	/**
	 * Sets the thumbnail url
	 * 
	 * @param thumbnailUrl the thumbnail url
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 * Gets the language
	 * 
	 * @return a <code>string</code> specifying the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language
	 * 
	 * @param language the language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the preview link
	 * 
	 * @return a <code>string</code> specifying the preview link
	 */
	public String getPreviewLink() {
		return previewLink;
	}

	/**
	 * Sets the preview link
	 * 
	 * @param previewLink the preview link
	 */
	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	/**
	 * Get the average rating
	 * 
	 * @return a <code>double</code> specifying the average rating
	 */
	public double getAverageRating() {
		return averageRating;
	}

	/**
	 * Sets the average rating
	 * 
	 * @param averageRating the average rating
	 */
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	/**
	 * Gets the authors
	 * 
	 * @return a authors'<code>List</code>
	 */
	public List<String> getAuthors() {
		return authors;
	}

	/**
	 * Sets the list of authors
	 * 
	 * @param authors the authors
	 */
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	/**
	 * Gets the list of categories
	 * 
	 * @return a categories' <code>List</code>
	 */
	public List<String> getCategories() {
		return categories;
	}

	/**
	 * Sets the list of categories
	 * 
	 * @param categories the categories
	 */
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	/**
	 * Gets the description
	 * 
	 * @return a <code>string</code> specifying the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description
	 * 
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
