package com.library.microlibrary.dao.authorDao;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.entities.AuthorEntity;

import java.util.List;

public interface AuthorDao {

    public AuthorEntity findAuthorByIdDao(Integer authorId);
    public List<AuthorEntity> findAuthorListDao();
    public void createAuthorDao(CreateAuthorDto authorDto, GetCityDto cityDto);
    public void editAuthorDao(EditAuthorDto authorDto, GetCityDto cityDto);

}
