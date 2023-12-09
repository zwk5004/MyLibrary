package com.kdstudio.mylibrary.controllers;

import com.kdstudio.mylibrary.models.book.BookRequest;
import com.kdstudio.mylibrary.models.book.BookResponse;
import com.kdstudio.mylibrary.services.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(originPatterns = {"http://*:*"})
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> getBooks() {
        return this.bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        return this.bookService.findBook(id);
    }

    @PostMapping
    public BookResponse saveBook(@RequestBody BookRequest bookRequest) {
        return this.bookService.save(bookRequest);
    }
}
