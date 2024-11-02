package com.study.jpa.controllers;

import com.study.jpa.dtos.BookRecordDto;
import com.study.jpa.entities.Book;
import com.study.jpa.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookRecordDto bookRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));
    }
}
