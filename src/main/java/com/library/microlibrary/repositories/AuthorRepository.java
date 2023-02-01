package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    List<AuthorEntity> findAll();
    AuthorEntity findByAuthorId(Integer authorId);
}
