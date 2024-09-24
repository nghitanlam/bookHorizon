package com.nolan.book.author.entity;

import com.nolan.book.book.entity.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    private String authorName;

    private String authorDescription;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
