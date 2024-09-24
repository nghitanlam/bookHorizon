package com.nolan.book.book.entity;

import com.nolan.book.author.entity.Author;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

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
