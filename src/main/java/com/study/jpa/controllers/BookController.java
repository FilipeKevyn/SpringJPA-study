package com.study.jpa.controllers;

import com.study.jpa.dtos.BookRecordDto;
import com.study.jpa.entities.Book;
import com.study.jpa.services.BookService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletById(@PathVariable UUID uuid){
        bookService.deletBook(uuid);
        return ResponseEntity.noContent().build();
    }
}
