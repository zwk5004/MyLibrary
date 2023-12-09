package com.kdstudio.mylibrary.dal.repositories;

import com.kdstudio.mylibrary.dal.entities.book.BookEntity;
import com.kdstudio.mylibrary.dal.entities.book.BookSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT new com.kdstudio.mylibrary.dal.entities.book.BookSummaryEntity(b.id, b.name, bt.name, b.location, b.isbn, s.name) FROM BookEntity b LEFT JOIN SeriesEntity s ON b.seriesId = s.id LEFT JOIN BookTypeEntity bt ON b.bookTypeId = bt.id")
    List<BookSummaryEntity> findAllSummaries();
}
