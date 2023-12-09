package com.kdstudio.mylibrary.models.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {
    private Long id;
    private String name;
    private String bookType;
    private String location;
    private String isbn;
    private String series;
    private String author;
}
