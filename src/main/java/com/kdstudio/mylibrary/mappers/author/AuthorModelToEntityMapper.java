package com.kdstudio.mylibrary.mappers.author;

import com.kdstudio.mylibrary.dal.entities.author.AuthorEntity;
import com.kdstudio.mylibrary.models.author.AuthorModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthorModelToEntityMapper {
    AuthorEntity map(AuthorModel model);
    List<AuthorEntity> mapList(List<AuthorModel> authorModelList);
}
