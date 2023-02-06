package com.library.microlibrary.dao.authorDao;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDao{

    private  final AuthorRepository authorRepository;

    @Override
    public AuthorEntity findAuthorByIdDao(Integer authorId)  throws IOException {
        return null;
    }

    @Override
    public List<AuthorEntity> findAuthorListDao()  throws IOException{
        return null;
    }

    @Override
    public void createAuthorDao(CreateAuthorDto authorDto, GetCityDto cityDto) throws IOException{
        AuthorEntity author = null;
        CityEntity city = null;



    }

    @Override
    public void editAuthorDao(EditAuthorDto authorDto, GetCityDto cityDto) throws IOException{

    }
}
