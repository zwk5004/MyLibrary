package com.kdstudio.mylibrary.controllers;

import com.kdstudio.mylibrary.models.author.AuthorModel;
import com.kdstudio.mylibrary.services.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
@CrossOrigin(originPatterns = {"http://*:*"})
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/forBooks")
    public Map<Long, List<AuthorModel>> getAuthorsMappedToBooks(@RequestBody List<Long> bookIds) {
        return authorService.findAuthorsForBooks(bookIds);
    }

    @PostMapping
    public AuthorModel save(@RequestBody AuthorModel authorModel) {
        return authorService.save(authorModel);
    }

    @GetMapping("/search")
    public List<AuthorModel> searchAuthors(@RequestParam String authorQuery) {
        return authorService.searchAuthor(authorQuery);
    }
}
