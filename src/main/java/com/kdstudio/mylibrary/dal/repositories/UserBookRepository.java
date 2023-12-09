package com.kdstudio.mylibrary.dal.repositories;

import com.kdstudio.mylibrary.dal.entities.UserBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBookEntity, Long> {
}
