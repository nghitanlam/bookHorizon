package com.nolan.book.book.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDto {

    private Integer id;

    private String title;

    private String isbn;

    private String synopsis;

    private Long price;

    private String authorName;

    private byte[] cover;

    private boolean available;
}
