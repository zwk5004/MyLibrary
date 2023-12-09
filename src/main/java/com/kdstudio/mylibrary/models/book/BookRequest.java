package com.kdstudio.mylibrary.models.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kdstudio.mylibrary.models.author.AuthorModel;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {
    private Long id;
    private String name;
    private String bookType;
    private Long bookTypeId;
    private String location;
    private String isbn;
    private String series;
    private Long seriesId;
    private List<AuthorModel> authors;
}
