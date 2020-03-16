# libraryAPI

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Rest Api](#rest-api)
* [Status](#status)

## General Info
This is a simple RestAPI project. It allows to search by books and authors from "https://www.googleapis.com/books/v1/volumes?q=java&maxResults=40" resource.

## Technologies
Project is created with:
- Java 1.8
- Spring framework 5.1.6
- Jackson 2.9.10.3
- hamcrest 1.3

## Setup
### Run the app
mvn spring-boot:run

## Rest Api
curl http://localhost:8080

## Get list of books
#### Request
GET /api/books

curl -i http://localhost:8080/api/books

#### Response

Content-Type: application/json;charset=UTF-8  
Transfer-Encoding: chunked  
Date: Mon, 16 Mar 2020 14:37:09 GMT  
[...]

## Get a specific book
#### Request

GET /api/books/id

curl -i http://localhost:8080/api/books/9781592432172

##### Response

Content-Type: application/json;charset=UTF-8  
Transfer-Encoding: chunked  
Date: Mon, 16 Mar 2020 14:36:33 GMT  

{"isbn":"9781592432172","title":"A Hypervista of the Java Landscape","subtitle":null,"publisher":"InfoStrategist.com","thumbnailUrl":"http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api","language":"en","previewLink":"http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api" ,"description":null,"publishedDate":0,"pageCount":0,"averageRating":0.0,"authors":null,"categories":null}

## Get a non existing book
#### Request
GET /api/books/id

curl -i http://localhost:8080/api/books/1

##### Response

Content-Type: application/json;charset=UTF-8  
Transfer-Encoding: chunked  
Date: Mon, 16 Mar 2020 14:35:56 GMT  

{"status":404,"message":"There is no book with isbn: 1","timeStamp":1584369356100}




