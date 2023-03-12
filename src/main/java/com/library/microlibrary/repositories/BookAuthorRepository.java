package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.BookAuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthorEntity, Integer> {

}
