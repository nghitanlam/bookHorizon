package com.nolan.book.book.controller;

import com.nolan.book.book.dto.BookRequestDto;
import com.nolan.book.book.dto.BookResponseDto;
import com.nolan.book.book.service.BookService;
import com.nolan.book.common.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@Tag(name = "Book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Integer> saveBook(@Valid @RequestBody BookRequestDto request) {
        return ResponseEntity.ok(bookService.save(request));
    }

    @GetMapping("{book-id}")
    public ResponseEntity<BookResponseDto> findBookById(
            @PathVariable("book-id") Integer bookId
    ) {
        return ResponseEntity.ok(bookService.findById(bookId));
    }

    @GetMapping
    public ResponseEntity<PageResponse<BookResponseDto>> findAllBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(bookService.findAllBooks(page, size));
    }
}
