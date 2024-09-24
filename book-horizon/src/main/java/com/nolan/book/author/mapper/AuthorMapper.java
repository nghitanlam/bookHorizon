package com.nolan.book.author.mapper;

import com.nolan.book.author.dto.AuthorRequestDto;
import com.nolan.book.author.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper {

    public Author toAuthor(AuthorRequestDto request) {
        return Author.builder()
                .authorName(request.getAuthorName())
                .authorDescription(request.getAuthorDescription())
                .build();
    }
}
