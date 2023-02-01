package com.library.microlibrary.services.authorServices;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.entities.AuthorEntity;

import java.util.List;

public class AuthorServiceImpl implements AuthorService{
    @Override
    public AuthorEntity findAuthorByService(Integer authorId) {
        return null;
    }

    @Override
    public List<AuthorEntity> findAuthorListService() {
        return null;
    }

    @Override
    public void createAuthorService(CreateAuthorDto authorDto) {

    }

    @Override
    public void editAuthorService(EditAuthorDto authorDto, Integer authorId) {

    }
}
