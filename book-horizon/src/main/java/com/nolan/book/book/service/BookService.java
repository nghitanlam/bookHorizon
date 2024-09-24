package com.nolan.book.book.service;

import com.nolan.book.book.dto.BookRequestDto;
import com.nolan.book.book.dto.BookResponseDto;
import com.nolan.book.common.PageResponse;
import jakarta.validation.Valid;

public interface BookService {

    Integer save(@Valid BookRequestDto request);

    BookResponseDto findById(Integer bookId);

    PageResponse<BookResponseDto> findAllBooks(int page, int size);
}
