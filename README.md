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

## Get books from specified category

#### Request
GET /api/books?category=Religion

#### Response

Content-Type: application/json;charset=UTF-8  
Transfer-Encoding: chunked  
Date: Mon, 16 Mar 2020 14:49:07 GMT  

[{"isbn":"9780226285108","title":"The Religion of Java","subtitle":null,"publisher":"University of Chicago Press","thumbnailUrl":"http://books.google.com/books/content?id=-SYM4PW-YAgC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api","language":"en","previewLink":"http://books.google.pl/books?id=-SYM4PW-YAgC&printsec=frontcover&dq=java&hl=&cd=2&source=gbs_api", "description":"Written with a rare combination of analysis and speculation, this comprehensive study of Javanese religion is one of the few books on the religion of a non-Western people which emphasizes variation and conflict in belief as well as similarity and harmony. The reader becomes aware of the intricacy and depth of Javanese spiritual life and the problems of political and social integration reflected in the religion. The Religion of Java will interest specialists in Southeast Asia, anthropologists and sociologists concerned with the social analysis of religious belief and ideology, students of comparative religion, and civil servants dealing with governmental policy toward Indonesia and Southeast Asia.","publishedDate":189298800000,"pageCount":392,"averageRating":4.0,"authors":["Clifford Geertz"],"categories":["Religion"]}]

## Get books with no category

#### Request
curl -i http://localhost:8080/api/books?category=

#### Response
Content-Type: application/json;charset=UTF-8  
Transfer-Encoding: chunked  
Date: Mon, 16 Mar 2020 15:04:56 GMT  

[{"isbn":"9781592432172","title":"A Hypervista of the Java Landscape","subtitle":null,"publisher":"InfoStrategist.com","thumbnailUrl":"http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api","language":"en","previewLink":"http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api","description":null,"publishedDate":0,"pageCount":0,"averageRating":0.0,"authors":null,"categories":null},{"isbn":"9788120602229","title":"Monumental Java","subtitle":null,"publisher":"Asian Educational Services","thumbnailUrl":"http://books.google.com/books/content?id=u67rbsVqB1oC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api","language":"en","previewLink":"http://books.google.pl/books?id=u67rbsVqB1oC&printsec=frontcover&dq=java&hl=&cd=9&source=gbs_api","description":"With Illustrations And Vignettes After Drawings Of Javanese Chandi Ornaments.","publishedDate":820450800000,"pageCount":302,"averageRating":0.0,"authors":["J.F. Scheltema"],"categories":null},{"isbn":"_-dCAAAAcAAJ","title":"The History of Java","subtitle":null,"publisher":null,"thumbnailUrl":"http://books.google.com/books/content?id=_-dCAAAAcAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api","language":"en","previewLink":"http://books.google.pl/books?id=_-dCAAAAcAAJ&printsec=frontcover&dq=java&hl=&cd=24&source=gbs_api","description":null,"publishedDate":-4828208400000,"pageCount":4,"averageRating":0.0,"authors":["Thomas Stamford Raffles"],"categories":null},{"isbn":"9788131755440","title":"The Class Of Java","subtitle":null,"publisher":"Pearson Education India","thumbnailUrl":"http://books.google.com/books/content?id=lGRpeBZQYPoC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api","language":"en","previewLink":"http://books.google.pl/books?id=lGRpeBZQYPoC&printsec=frontcover&dq=java&hl=&cd=33&source=gbs_api","description":null,"publishedDate":1293836400000,"pageCount":492,"averageRating":5.0,"authors":["Jain Pravin"],"categories":null},{"isbn":"WYrpzP8U3XIC","title":"Sketches, Civil and Military, of the Island of Java and Its Immediate Dependencies","subtitle":"Comprising Interesting Details of Batavia, and Authentic Particulars of the Celebrated Poison-tree : Illustrated with a Map of Java, Plan of Batavia, and Chart of the Strait of Madura, from Actual Survey","publisher":null,"thumbnailUrl":"http://books.google.com/books/content?id=WYrpzP8U3XIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api","language":"en","previewLink":"http://books.google.pl/books?id=WYrpzP8U3XIC&pg=PA407&dq=java&hl=&cd=37&source=gbs_api","description":null,"publishedDate":-4986061200000,"pageCount":450,"averageRating":0.0,"authors":["Samuel Auchmuty"],"categories":null}]

## Get books with non existing category

#### Request
curl -i http://localhost:8080/api/books?category=fantasy

#### Response
Content-Type: application/json;charset=UTF-8  
Transfer-Encoding: chunked  
Date: Mon, 16 Mar 2020 15:16:57 GMT  

{"status":404,"message":"Name of category: 'fantasy' doesn't exist","timeStamp":1584371817289}

## Status
New features will bring a list of authors and their average rating






