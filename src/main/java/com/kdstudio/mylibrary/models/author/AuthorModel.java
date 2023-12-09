package com.kdstudio.mylibrary.models.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorModel {
    private Long id;
    private String name;
}
