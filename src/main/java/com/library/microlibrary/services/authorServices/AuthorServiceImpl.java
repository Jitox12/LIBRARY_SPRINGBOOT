package com.library.microlibrary.services.authorServices;

import com.library.microlibrary.dao.authorDao.AuthorDao;
import com.library.microlibrary.dao.cityDao.CityDao;
import com.library.microlibrary.dto.authorDto.CreateAuthorDto;
import com.library.microlibrary.dto.authorDto.EditAuthorDto;
import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.mappers.authorMappers.AuthorEntityToGetAuthorDtoMapper;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityCountryDtoMapper;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityDtoMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;
    private final CityDao cityDao;

    private final AuthorEntityToGetAuthorDtoMapper authorEntityToGetAuthorDtoMapper;
    private final CityEntityToGetCityDtoMapper cityEntityToGetCityDtoMapper;
    private final CityEntityToGetCityCountryDtoMapper cityEntityToGetCityCountryDtoMapper;

    public AuthorServiceImpl(AuthorDao authorDao, CityDao cityDao, AuthorEntityToGetAuthorDtoMapper authorEntityToGetAuthorDtoMapper, CityEntityToGetCityDtoMapper cityEntityToGetCityDtoMapper, CityEntityToGetCityCountryDtoMapper cityEntityToGetCityCountryDtoMapper) {
        this.authorDao = authorDao;
        this.cityDao = cityDao;
        this.authorEntityToGetAuthorDtoMapper = authorEntityToGetAuthorDtoMapper;
        this.cityEntityToGetCityDtoMapper = cityEntityToGetCityDtoMapper;
        this.cityEntityToGetCityCountryDtoMapper = cityEntityToGetCityCountryDtoMapper;
    }


    @Override
    public GetAuthorDto findAuthorByIdService(Integer authorId) {
        AuthorEntity author = null;
        GetAuthorDto authorDto = null;

        try {
            author = authorDao.findAuthorByIdDao(authorId);
            authorDto = authorEntityToGetAuthorDtoMapper.authorEntityToGetAuthorDto(author);
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
            authorListDto = author.stream()
                    .map(authorEntityToGetAuthorDtoMapper::authorEntityToGetAuthorDto).collect(Collectors.toList());

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
            cityDto = cityEntityToGetCityCountryDtoMapper.cityEntityToGetCityDto(city);

            authorDao.createAuthorDao(authorDto, cityDto);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editAuthorService(EditAuthorDto authorDto, Integer authorId) {

    }
}
