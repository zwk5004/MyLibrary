package com.kdstudio.mylibrary.dal.entities.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorBookSummaryEntity {
    private Long authorId;
    private Long bookId;
    private Long authorName;
}
