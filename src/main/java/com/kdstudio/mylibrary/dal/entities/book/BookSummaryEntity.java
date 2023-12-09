package com.kdstudio.mylibrary.dal.entities.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookSummaryEntity {
    private Long id;
    private String name;
    private String bookType;
    private String location;
    private String isbn;
    private String series;
}
