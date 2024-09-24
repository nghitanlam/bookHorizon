package com.nolan.book.author.service.impl;

import com.nolan.book.author.dto.AuthorRequestDto;
import com.nolan.book.author.entity.Author;
import com.nolan.book.author.mapper.AuthorMapper;
import com.nolan.book.author.repository.AuthorRepository;
import com.nolan.book.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    @Override
    public Integer save(AuthorRequestDto request) {
        Author author = authorMapper.toAuthor(request);
        return authorRepository.save(author).getId();
    }
}
