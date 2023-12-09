package com.kdstudio.mylibrary.mappers.book;

import com.kdstudio.mylibrary.dal.entities.book.BookSummaryEntity;
import com.kdstudio.mylibrary.models.book.BookResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface BookSummaryEntityToResponseMapper {
    BookResponse map(BookSummaryEntity bookEntity);

    List<BookResponse> mapList(List<BookSummaryEntity> entityList);
}
