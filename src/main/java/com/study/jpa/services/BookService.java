package com.study.jpa.services;

import com.study.jpa.dtos.BookRecordDto;
import com.study.jpa.entities.Book;
import com.study.jpa.entities.Review;
import com.study.jpa.repositories.AuthorRepository;
import com.study.jpa.repositories.BookRepository;
import com.study.jpa.repositories.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public Book saveBook(BookRecordDto bookRecordDto){
        Book book = new Book();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherid()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorsIds()).stream().collect(Collectors.toSet()));

        Review review = new Review();
        review.setComment(bookRecordDto.reviewComent());
        review.setBook(book);
        book.setReview(review);

        return bookRepository.save(book);
    }
}
