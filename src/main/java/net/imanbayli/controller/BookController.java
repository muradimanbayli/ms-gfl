package net.imanbayli.controller;

import lombok.RequiredArgsConstructor;
import net.imanbayli.model.BookRequest;
import net.imanbayli.model.BookResponse;
import net.imanbayli.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody @Valid BookRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.add(request));
    }

}
