package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.entities.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {

    List<LibraryEntity> findAll();
    LibraryEntity findByLibraryId(Integer libraryId);
}
