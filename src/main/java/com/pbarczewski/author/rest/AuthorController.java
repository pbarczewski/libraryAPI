package com.pbarczewski.author.rest;

import com.pbarczewski.author.domain.model.AuthorModel;
import com.pbarczewski.author.rest.response.AuthorResponseList;
import com.pbarczewski.author.service.AuthorService;
import com.pbarczewski.books.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;


	@GetMapping("/list")
    @Operation(description = "return an author model list")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "author model list has been sucessfuly provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthorResponseList.class))),
        @ApiResponse(responseCode = "404", description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthorResponseList.class)))
    })
    public ResponseEntity<AuthorResponseList> getBooks(@RequestParam(required = false) String category) {
        AuthorResponseList authorResponseList = new AuthorResponseList();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String message = "";
            List<AuthorModel> authorModelList = authorService.getAuthorModelList();
        if (authorModelList != null && !authorModelList.isEmpty()) {
            httpStatus = HttpStatus.OK;
            message = "Poprawnie zwrócono listę autorów";
            authorResponseList.setAuthorModelList(authorModelList);
        } else {
            message = "Wystąpił błąd podczas zwracania listy autorów";
        }
        authorResponseList.setHttpStatus(httpStatus);
        authorResponseList.setMessage(message);
		return new ResponseEntity<>(authorResponseList, httpStatus);
	}
}
