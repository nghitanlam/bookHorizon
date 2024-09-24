package com.nolan.book.book.mapper;

import com.nolan.book.book.dto.BookRequestDto;
import com.nolan.book.book.dto.BookResponseDto;
import com.nolan.book.book.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookRequestDto request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .synopsis(request.synopsis())
                .isbn(request.isbn())
                .price(request.price())
                .available(request.available())
                .build();
    }

    public BookResponseDto toBookResponse(Book book) {
        return BookResponseDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthor().getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .price(book.getPrice())
                .available(book.isAvailable())
                .build();
    }
}
