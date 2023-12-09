package com.kdstudio.mylibrary.dal.repositories;

import com.kdstudio.mylibrary.dal.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
