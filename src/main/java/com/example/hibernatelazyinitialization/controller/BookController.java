package com.example.hibernatelazyinitialization.controller;

import com.example.hibernatelazyinitialization.entity.Book;
import com.example.hibernatelazyinitialization.repository.BookRepository;
import com.example.hibernatelazyinitialization.repository.dto.BookProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;


    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{genre}")
    public List<Book> getAllBooks(@PathVariable("genre") String genre) {
        return bookRepository.findByGenre(genre);
    }

    @GetMapping("/by_projection")
    public List<BookProjection> getAllBooksByProjections() {
        return bookRepository.findAllProjectedBy();
    }
}
