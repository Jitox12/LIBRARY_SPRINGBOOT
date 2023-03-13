package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.BookEditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEditorialRepository extends JpaRepository<BookEditorialEntity, Integer> {
}
