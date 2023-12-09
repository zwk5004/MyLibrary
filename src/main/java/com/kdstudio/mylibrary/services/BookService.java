package com.kdstudio.mylibrary.services;

import com.kdstudio.mylibrary.models.book.BookRequest;
import com.kdstudio.mylibrary.models.book.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse findBook(Long id);
    List<BookResponse> findAllBooks();

    BookResponse save(BookRequest bookRequest);
}
