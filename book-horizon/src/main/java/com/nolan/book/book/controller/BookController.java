package com.nolan.book.book.controller;

import com.nolan.book.book.dto.BookRequestDto;
import com.nolan.book.book.service.BookService;
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
}
