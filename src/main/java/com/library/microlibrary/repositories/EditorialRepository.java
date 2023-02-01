package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.entities.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditorialRepository extends JpaRepository<EditorialEntity, Integer> {


    List<EditorialEntity> findAll();
    EditorialEntity findByEditorialId(Integer editorialId);
}
