package com.library.microlibrary.dao.authorDao;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDao{

    private  final AuthorRepository authorRepository;

    @Override
    public AuthorEntity findAuthorByIdDao(Integer authorId) {
        return null;
    }

    @Override
    public List<AuthorEntity> findAuthorListDao() {
        return null;
    }

    @Override
    public void createAuthorDao(CreateAuthorDto authorDto, GetCityDto cityDto) {

    }

    @Override
    public void editAuthorDao(EditAuthorDto authorDto, GetCityDto cityDto) {

    }
}
