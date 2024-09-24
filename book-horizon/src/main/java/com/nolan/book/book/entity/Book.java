package com.nolan.book.book.entity;

import com.nolan.book.author.Author;
import com.nolan.book.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    private String title;

    private String isbn;

    private String synopsis;

    private Long price;

    private String bookCover;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
