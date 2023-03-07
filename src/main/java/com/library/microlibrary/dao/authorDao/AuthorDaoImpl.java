package com.library.microlibrary.dao.authorDao;

import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
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

    private final AuthorRepository authorRepository;

    @Override
    public AuthorEntity findAuthorByIdDao(Integer authorId)  throws IOException {
        AuthorEntity author = null;
        author = authorRepository.findByAuthorId(authorId);

        return author;
    }

    @Override
    public List<AuthorEntity> findAuthorListDao()  throws IOException{
        List<AuthorEntity> authorList = null;
        authorList = authorRepository.findAll();

        return authorList;
    }

    @Override
    public void createAuthorDao(CreateAuthorDto authorDto, GetCityCountryDto cityDto) throws IOException{
        AuthorEntity author = null;
        CityEntity city = null;

        city = CityEntity.builder()
                .cityId(cityDto.getCityIdDto())
                .cityName(cityDto.getCityNameDto())
                .country(cityDto.getCountryDto())
                .build();
        author = AuthorEntity.builder()
                .authorName(authorDto.getAuthorNameDto())
                .city(city)
                .build();

        authorRepository.save(author);
    }

    @Override
    public void editAuthorDao(EditAuthorDto authorDto, GetCityCountryDto cityDto) throws IOException{
        AuthorEntity author = null;
        CityEntity city = null;

        city = CityEntity.builder()
                .cityId(cityDto.getCityIdDto())
                .cityName(cityDto.getCityNameDto())
                .country(cityDto.getCountryDto())
                .build();
        author = AuthorEntity.builder()
                .authorId(authorDto.getAuthorIdDto())
                .authorName(authorDto.getAuthorNameDto())
                .city(city)
                .build();

        authorRepository.save(author);
    }
}
