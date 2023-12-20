package com.pbarczewski.books.rest;
import java.util.List;

import com.pbarczewski.books.domain.model.VolumeInfoModel;
import com.pbarczewski.books.rest.response.BookResponse;
import com.pbarczewski.books.rest.response.BookResponseList;
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
import com.pbarczewski.books.infrastructure.model.ItemEntity;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
    private BookService bookService;


	@GetMapping("/list")
    @Operation(description = "return volume info model list")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "volume info model list has been sucessfuly provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookResponseList.class))),
        @ApiResponse(responseCode = "404", description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookResponseList.class)))
    })
    public ResponseEntity<BookResponseList> getBooks(@RequestParam(required = false) String category) {
        BookResponseList bookResponseList = new BookResponseList();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String message = "";
        String categoryMsg = category != null ? " z kategorii " + category : ".";
            List<VolumeInfoModel> volumeInfoModels = bookService.getVolumeInfoList(category);
        if (volumeInfoModels != null && !volumeInfoModels.isEmpty()) {
            httpStatus = HttpStatus.OK;
            message = "Poprawnie zwrócono listę książek" + categoryMsg;
            bookResponseList.setVolumeInfoModel(volumeInfoModels);
        } else {
            message = "Wystąpił błąd podczas zwracania listy książek" + categoryMsg;
        }
        bookResponseList.setHttpStatus(httpStatus);
        bookResponseList.setMessage(message);
		return new ResponseEntity<>(bookResponseList, httpStatus);
	}

    @GetMapping("/{isbn}")
    @Operation(description = "return volume info model list")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "volume info model list has been sucessfuly provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookResponse.class))),
        @ApiResponse(responseCode = "404", description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookResponse.class)))
    })
    public ResponseEntity<BookResponse> getBookByIsbn(@PathVariable String isbn) {
        BookResponse bookResponse = new BookResponse();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String message = "";

        VolumeInfoModel volumeInfoModel = bookService.getVolumeInfoModelByIsbn(isbn);
        if (volumeInfoModel != null) {
            httpStatus = HttpStatus.OK;
            message = "Poprawnie zwrócono książe o numerze isbn " + isbn;
            bookResponse.setVolumeInfoModel(volumeInfoModel);
        } else {
            message = "Wystąpił błąd podczas zwracania książki o numerze isbn " + isbn;
        }
        bookResponse.setHttpStatus(httpStatus);
        bookResponse.setMessage(message);
        return new ResponseEntity<>(bookResponse, httpStatus);
    }
}
