package com.kdstudio.mylibrary.dal.repositories;

import com.kdstudio.mylibrary.dal.entities.BookGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenreEntity, Long> {
}
