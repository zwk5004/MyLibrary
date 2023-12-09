package com.kdstudio.mylibrary.mappers.author;

import com.kdstudio.mylibrary.dal.entities.author.AuthorBookSummaryEntity;
import com.kdstudio.mylibrary.models.author.AuthorModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthorBookSummaryEntityToResponseMapper {
    AuthorModel map(AuthorBookSummaryEntity entity);
    List<AuthorModel> mapList(List<AuthorBookSummaryEntity> entityList);
}
