package com.library.microlibrary.services;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {

    public GetAuthorDto findAuthorByIdService(Integer authorId);
    public List<GetAuthorDto> findAuthorListService();
    public void createAuthorService(CreateAuthorDto authorDto);
    public void editAuthorService(EditAuthorDto authorDto, Integer authorId);
}
