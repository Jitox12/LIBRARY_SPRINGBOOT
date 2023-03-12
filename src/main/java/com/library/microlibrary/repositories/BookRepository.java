package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findAll();
    BookEntity findByBookId(Integer bookId);
    BookEntity save(BookEntity book);
}
