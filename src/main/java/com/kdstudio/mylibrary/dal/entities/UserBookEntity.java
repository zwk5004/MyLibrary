package com.kdstudio.mylibrary.dal.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBookEntity {
    @Id
    @Column(name = "id", columnDefinition = "bigserial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "user_id")
    private Long userId;

    @Basic
    @Column(name = "book_id")
    private Long bookId;

    @Basic
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "rating")
    private Integer rating;
}
