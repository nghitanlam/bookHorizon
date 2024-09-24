package com.nolan.book.book.service.impl;

import com.nolan.book.book.dto.BookRequestDto;
import com.nolan.book.book.entity.Book;
import com.nolan.book.book.mapper.BookMapper;
import com.nolan.book.book.repository.BookRepository;
import com.nolan.book.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Override
    public Integer save(BookRequestDto request) {
        Book book = bookMapper.toBook(request);
        return bookRepository.save(book).getId();
    }
}
