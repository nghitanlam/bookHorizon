package com.nolan.book.author;

import com.nolan.book.book.entity.Book;
import com.nolan.book.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Author extends BaseEntity {

    private String authorName;

    private String authorDescription;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
