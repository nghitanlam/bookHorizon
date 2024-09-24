package com.nolan.book.book.repository;

import com.nolan.book.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("""
            SELECT book
            FROM Book book
            WHERE book.available = true
            """)
    Page<Book> findAllDisplayableBooks(Pageable pageable);
}
