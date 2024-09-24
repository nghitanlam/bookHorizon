package com.nolan.book.book.service;

import com.nolan.book.book.dto.BookRequestDto;
import jakarta.validation.Valid;

public interface BookService {
    Integer save(@Valid BookRequestDto request);
}
