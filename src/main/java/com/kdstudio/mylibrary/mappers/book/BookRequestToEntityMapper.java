package com.kdstudio.mylibrary.mappers.book;

import com.kdstudio.mylibrary.dal.entities.book.BookEntity;
import com.kdstudio.mylibrary.models.book.BookRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BookRequestToEntityMapper {
    BookEntity map(BookRequest bookRequest);
}
