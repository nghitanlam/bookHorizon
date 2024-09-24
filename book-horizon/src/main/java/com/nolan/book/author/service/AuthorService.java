package com.nolan.book.author.service;

import com.nolan.book.author.dto.AuthorRequestDto;
import jakarta.validation.Valid;

public interface AuthorService {
    Integer save(@Valid AuthorRequestDto request);
}
