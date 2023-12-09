package com.kdstudio.mylibrary.services.impl;

import com.kdstudio.mylibrary.dal.entities.author.AuthorBookSummaryEntity;
import com.kdstudio.mylibrary.dal.entities.author.AuthorEntity;
import com.kdstudio.mylibrary.dal.repositories.AuthorRepository;
import com.kdstudio.mylibrary.mappers.author.AuthorBookSummaryEntityToResponseMapper;
import com.kdstudio.mylibrary.mappers.author.AuthorEntityToModelMapper;
import com.kdstudio.mylibrary.mappers.author.AuthorModelToEntityMapper;
import com.kdstudio.mylibrary.models.author.AuthorModel;
import com.kdstudio.mylibrary.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private AuthorBookSummaryEntityToResponseMapper authorBookSummaryEntityToResponseMapper;
    private AuthorModelToEntityMapper authorModelToEntityMapper;
    private AuthorEntityToModelMapper authorEntityToModelMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             AuthorBookSummaryEntityToResponseMapper authorBookSummaryEntityToResponseMapper,
                             AuthorModelToEntityMapper authorModelToEntityMapper,
                             AuthorEntityToModelMapper authorEntityToModelMapper) {
        this.authorRepository = authorRepository;
        this.authorBookSummaryEntityToResponseMapper = authorBookSummaryEntityToResponseMapper;
        this.authorModelToEntityMapper = authorModelToEntityMapper;
        this.authorEntityToModelMapper = authorEntityToModelMapper;
    }

    @Override
    public Map<Long, List<AuthorModel>> findAuthorsForBooks(List<Long> bookIds) {
        List<AuthorBookSummaryEntity> authorEntities = authorRepository.findAuthorsForBooks(bookIds);
        return authorEntities.stream().collect(
                Collectors.groupingBy(AuthorBookSummaryEntity::getBookId,
                        Collectors.mapping(entity -> authorBookSummaryEntityToResponseMapper.map(entity), Collectors.toList())));
    }

    @Override
    public AuthorModel save(AuthorModel authorModel) {
        return authorEntityToModelMapper.map(authorRepository.save(authorModelToEntityMapper.map(authorModel)));
    }

    @Override
    public List<AuthorModel> searchAuthor(String authorQuery) {
        return authorEntityToModelMapper.mapList(authorRepository.findAuthorEntitiesByNameContainingIgnoreCase(authorQuery));
    }
}
