package com.nolan.book.book.service.impl;

import com.nolan.book.author.entity.Author;
import com.nolan.book.author.repository.AuthorRepository;
import com.nolan.book.book.dto.BookRequestDto;
import com.nolan.book.book.dto.BookResponseDto;
import com.nolan.book.book.entity.Book;
import com.nolan.book.book.mapper.BookMapper;
import com.nolan.book.book.repository.BookRepository;
import com.nolan.book.book.service.BookService;
import com.nolan.book.common.PageResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final BookMapper bookMapper;

    @Override
    public Integer save(BookRequestDto request) {
        Book book = bookMapper.toBook(request);

        Author author = authorRepository.findById(request.authorId())
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));

        book.setAuthor(author);

        return bookRepository.save(book).getId();
    }

    @Override
    public BookResponseDto findById(Integer bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::toBookResponse)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with the ID:: " + bookId));
    }

    @Override
    public PageResponse<BookResponseDto> findAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("price").descending());
        Page<Book> books = bookRepository.findAllDisplayableBooks(pageable);
        List<BookResponseDto> bookResponse = books.stream()
                .map(bookMapper::toBookResponse)
                .toList();

        return new PageResponse<>(
                bookResponse,
                books.getNumber(),
                books.getSize(),
                books.getTotalElements(),
                books.getTotalPages(),
                books.isFirst(),
                books.isLast()
        );
    }

}
