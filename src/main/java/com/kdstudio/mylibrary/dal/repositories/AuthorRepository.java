package com.kdstudio.mylibrary.dal.repositories;

import com.kdstudio.mylibrary.dal.entities.author.AuthorBookSummaryEntity;
import com.kdstudio.mylibrary.dal.entities.author.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    @Query("SELECT new com.kdstudio.mylibrary.dal.entities.author.AuthorBookSummaryEntity(a.id, ba.bookId, a.name) FROM AuthorEntity a INNER JOIN BookAuthorEntity ba ON a.id = ba.authorId WHERE ba.bookId IN :booksId")
    List<AuthorBookSummaryEntity> findAuthorsForBooks(List<Long> bookIds);

    List<AuthorEntity> findAuthorEntitiesByNameContainingIgnoreCase(String name);
}
