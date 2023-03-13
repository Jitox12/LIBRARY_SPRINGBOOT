package com.library.microlibrary.services.serviceImpl;

import com.library.microlibrary.dao.AuthorDao;
import com.library.microlibrary.dao.CityDao;
import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.AuthorMappers;
import com.library.microlibrary.mappers.CityMappers;
import com.library.microlibrary.services.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;
    private final CityDao cityDao;

    private final AuthorMappers authorMappers;
    private final CityMappers cityMappers;

    public AuthorServiceImpl(AuthorDao authorDao, CityDao cityDao, AuthorMappers authorMappers, CityMappers cityMappers) {
        this.authorDao = authorDao;
        this.cityDao = cityDao;
        this.authorMappers = authorMappers;
        this.cityMappers = cityMappers;
    }


    @Override
    public GetAuthorDto findAuthorByIdService(Integer authorId) {
        AuthorEntity author = null;
        GetAuthorDto authorDto = null;

        try {
            author = authorDao.findAuthorByIdDao(authorId);
            if(Objects.isNull(author)){
                throw new BadRequestException("Author does not exist with id: ".concat(String.valueOf(authorId)));
            }
            authorDto = authorMappers.authorEntityToGetAuthorDto(author);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return authorDto;
    }

    @Override
    public List<GetAuthorDto> findAuthorListService() {
        List<AuthorEntity> author = null;
        List<GetAuthorDto> authorListDto = null;

        try {
            author = authorDao.findAuthorListDao();
            if(Objects.isNull(author)){
                throw new BadRequestException("does not exist any record");
            }
            authorListDto = author.stream()
                    .map(authorMappers::authorEntityToGetAuthorDto).collect(Collectors.toList());

            return authorListDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createAuthorService(CreateAuthorDto authorDto) {
        GetCityCountryDto cityDto = null;
        CityEntity city = null;

        try{
            city = cityDao.findCityByIdDao(authorDto.getCityIdDto());
            if(Objects.isNull(city)){
                throw new BadRequestException("City does not exist with id ".concat(String.valueOf(authorDto.getCityIdDto())));
            }
            cityDto = cityMappers.cityEntityToGetCityCountryDto(city);

            authorDao.createAuthorDao(authorDto, cityDto);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editAuthorService(EditAuthorDto authorDto, Integer authorId) {
        GetCityCountryDto cityDto = null;
        CityEntity city = null;

        try{
            city = cityDao.findCityByIdDao(authorDto.getCityIdDto());
            if(Objects.isNull(city)){
                throw new BadRequestException("City does not exist with id: ".concat(String.valueOf(authorDto.getCityIdDto())));
            }
            cityDto = cityMappers.cityEntityToGetCityCountryDto(city);

            authorDto.setAuthorIdDto(authorId);

            authorDao.editAuthorDao(authorDto, cityDto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
