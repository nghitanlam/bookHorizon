package com.nolan.book.author.controller;

import com.nolan.book.author.dto.AuthorRequestDto;
import com.nolan.book.author.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("author")
@Tag(name = "Author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Integer> saveAuthor(@Valid @RequestBody AuthorRequestDto request) {
        return ResponseEntity.ok(authorService.save(request));
    }
}
