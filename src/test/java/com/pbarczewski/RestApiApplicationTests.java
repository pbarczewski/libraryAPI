package com.pbarczewski;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import javax.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

@SpringBootTest
class RestApiApplicationTests {
	
	@PostConstruct
	public static void setupConfiguration() {
		RestAssured.baseURI = "http://localhost:8080/api";
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
	}

	@Test
	void givenExistingBookIdWhenGetBookThenReturnBook() {
		
		given()
		.pathParam("isbnNumber", "9780226285108")
		.when().get("books/{isbnNumber}")
		.then()
		.assertThat()
		.body(  "isbn", equalTo("9780226285108"),
				"title", equalTo("The Religion of Java"),
				"subtitle", is(nullValue()),
				"publisher", equalTo("University of Chicago Press"),
				"thumbnailUrl", equalTo("http://books.google.com/books/"
						+ "content?id=-SYM4PW-YAgC&printsec=frontcover&img=1&zoom=1&edge="
						+ "curl&source=gbs_api"),
				"description", endsWith("toward Indonesia and Southeast Asia."),
				"publishedDate", is(189298800000L),
				"pageCount", equalTo(392),
				"averageRating", equalTo(4.0f),
				"categories[0]", equalTo("Religion"),
				"authors[0]", equalTo("Clifford Geertz")
				)
		.assertThat().statusCode(200);
	}
	
	@Test
	void givenNonExistingBookIdWhenGetThenStatusCode404() {
		given()
		.pathParam("nonExistingIsbn", "1112222")
		.when().get("books/{nonExistingIsbn}")
		.then().statusCode(404);
	}
	
	@Test
	void givenExistingCategoryNameWhenGetBooksWithinCategory() {
		given()
		.queryParam("category", "Religion")
		.when().get("books/").then().statusCode(200);
	}
	
	@Test
	void givenNonExistingCategoryNameWhenGetThenStatusCode404() {
		given()
		.queryParam("category", "Szklanki")
		.when().get("books/").then().statusCode(404);
	}
}
