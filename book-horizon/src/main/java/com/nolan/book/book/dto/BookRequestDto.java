package com.nolan.book.book.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookRequestDto (

        Integer id,

        @NotNull(message = "100")
        @NotEmpty(message = "100")
        String title,

        @NotNull(message = "101")
        @NotEmpty(message = "101")
        String isbn,

        @NotNull(message = "102")
        @NotEmpty(message = "102")
        String synopsis,

        @NotNull(message = "103")
        Long price,

        @NotNull(message = "103")
        Integer authorId,

        boolean available
) { }
