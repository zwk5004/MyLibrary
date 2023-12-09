package com.kdstudio.mylibrary.services;

import com.kdstudio.mylibrary.models.author.AuthorModel;

import java.util.List;
import java.util.Map;

public interface AuthorService {
    Map<Long, List<AuthorModel>> findAuthorsForBooks(List<Long> bookIds);

    AuthorModel save(AuthorModel authorModel);
    List<AuthorModel> searchAuthor(String authorQuery);
}
