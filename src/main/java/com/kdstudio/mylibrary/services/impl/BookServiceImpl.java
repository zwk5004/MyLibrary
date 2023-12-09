package com.kdstudio.mylibrary.services.impl;

import com.kdstudio.mylibrary.dal.entities.BookAuthorEntity;
import com.kdstudio.mylibrary.dal.entities.BookTypeEntity;
import com.kdstudio.mylibrary.dal.entities.SeriesEntity;
import com.kdstudio.mylibrary.dal.entities.book.BookEntity;
import com.kdstudio.mylibrary.dal.repositories.BookAuthorRepository;
import com.kdstudio.mylibrary.dal.repositories.BookRepository;
import com.kdstudio.mylibrary.dal.repositories.BookTypeRepository;
import com.kdstudio.mylibrary.dal.repositories.SeriesRepository;
import com.kdstudio.mylibrary.mappers.book.BookEntityToResponseMapper;
import com.kdstudio.mylibrary.mappers.book.BookRequestToEntityMapper;
import com.kdstudio.mylibrary.mappers.book.BookSummaryEntityToResponseMapper;
import com.kdstudio.mylibrary.models.author.AuthorModel;
import com.kdstudio.mylibrary.models.book.BookRequest;
import com.kdstudio.mylibrary.models.book.BookResponse;
import com.kdstudio.mylibrary.services.AuthorService;
import com.kdstudio.mylibrary.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookTypeRepository bookTypeRepository;
    private SeriesRepository seriesRepository;
    private BookAuthorRepository bookAuthorRepository;
    private BookEntityToResponseMapper bookEntityToResponseMapper;
    private BookSummaryEntityToResponseMapper bookSummaryEntityToResponseMapper;
    private BookRequestToEntityMapper bookRequestToEntityMapper;
    private AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository,
                           BookTypeRepository bookTypeRepository,
                           SeriesRepository seriesRepository,
                           BookAuthorRepository bookAuthorRepository,
                           BookEntityToResponseMapper bookEntityToResponseMapper,
                           BookSummaryEntityToResponseMapper bookSummaryEntityToResponseMapper,
                           BookRequestToEntityMapper bookRequestToEntityMapper,
                           AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.bookTypeRepository = bookTypeRepository;
        this.seriesRepository = seriesRepository;
        this.bookAuthorRepository = bookAuthorRepository;
        this.bookEntityToResponseMapper = bookEntityToResponseMapper;
        this.bookSummaryEntityToResponseMapper = bookSummaryEntityToResponseMapper;
        this.bookRequestToEntityMapper = bookRequestToEntityMapper;
        this.authorService = authorService;
    }

    @Override
    public BookResponse findBook(Long id) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);
        return bookEntityOptional.map(bookEntity -> bookEntityToResponseMapper.map(bookEntity)).orElse(null);
    }

    @Override
    public List<BookResponse> findAllBooks() {
        return bookSummaryEntityToResponseMapper.mapList(bookRepository.findAllSummaries());
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        // if book type id is null and book type is not null, then create the book type
        if (bookRequest.getBookTypeId() == null && bookRequest.getBookType() != null) {
            BookTypeEntity bookTypeEntity = BookTypeEntity.builder().name(bookRequest.getBookType()).build();
            bookRequest.setBookTypeId(bookTypeRepository.save(bookTypeEntity).getId());
        }
        // if the series id is null and series is not null, then create the series
        if (bookRequest.getSeriesId() == null && bookRequest.getSeries() != null) {
            SeriesEntity seriesEntity = SeriesEntity.builder().name(bookRequest.getSeries()).build();
            bookRequest.setSeriesId(seriesRepository.save(seriesEntity).getId());
        }

        BookResponse bookResponse = bookEntityToResponseMapper.map(bookRepository.save(bookRequestToEntityMapper.map(bookRequest)));

        // Create authors that don't have an ID associated and link them in the authorBook table
        bookRequest.getAuthors().forEach(authorModel -> {
            AuthorModel savedAuthor;
            // if null, then create it and use ID to create association
            if (authorModel.getId() == null) {
                savedAuthor = authorService.save(authorModel);
            } else {
                savedAuthor = authorModel;
            }
            BookAuthorEntity bookAuthorEntity = BookAuthorEntity.builder()
                    .authorId(savedAuthor.getId())
                    .bookId(bookResponse.getId())
                    .build();
            bookAuthorRepository.save(bookAuthorEntity);
        });

        return bookResponse;
    }
}
