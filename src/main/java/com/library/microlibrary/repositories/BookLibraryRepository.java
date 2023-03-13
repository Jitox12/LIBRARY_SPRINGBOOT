package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.BookLibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLibraryRepository extends JpaRepository<BookLibraryEntity, Integer> {
}
