package com.kdstudio.mylibrary.mappers.book;

import com.kdstudio.mylibrary.dal.entities.book.BookEntity;
import com.kdstudio.mylibrary.models.book.BookResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface BookEntityToResponseMapper {
    BookResponse map(BookEntity bookEntity);

    List<BookResponse> mapList(List<BookEntity> entityList);
}
