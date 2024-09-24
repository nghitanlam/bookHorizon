package com.nolan.book.author.dto;

import com.nolan.book.book.entity.Book;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequestDto {

    private Integer id;

    private String authorName;

    private String authorDescription;
}
