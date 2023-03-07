package com.library.microlibrary.dao.authorDao;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.entities.AuthorEntity;

import java.io.IOException;
import java.util.List;

public interface AuthorDao {

    public AuthorEntity findAuthorByIdDao(Integer authorId) throws IOException;
    public List<AuthorEntity> findAuthorListDao() throws IOException;
    public void createAuthorDao(CreateAuthorDto authorDto, GetCityCountryDto cityDto) throws IOException;
    public void editAuthorDao(EditAuthorDto authorDto, GetCityCountryDto cityDto) throws IOException;

}
