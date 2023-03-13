package com.library.microlibrary.services.serviceImpl;

import com.library.microlibrary.dao.CityDao;
import com.library.microlibrary.dao.LibraryDao;
import com.library.microlibrary.dto.bookDto.GABookDto;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.dto.libraryDto.GetLibraryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.LibraryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.CityMappers;
import com.library.microlibrary.mappers.LibraryMappers;
import com.library.microlibrary.services.LibraryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    //DAO
    private final LibraryDao libraryDao;
    private final CityDao cityDao;

    //MAPPERS
    private final LibraryMappers libraryMappers;
    private final CityMappers cityMappers;

    public LibraryServiceImpl(LibraryDao libraryDao, CityDao cityDao, LibraryMappers libraryMappers, CityMappers cityMappers) {
        this.libraryDao = libraryDao;
        this.cityDao = cityDao;
        this.libraryMappers = libraryMappers;
        this.cityMappers = cityMappers;
    }


    @Override
    public GetLibraryDto findLibraryByIdService(Integer libraryId) {
        LibraryEntity library = null;
        GetLibraryDto libraryDto = null;

        try {
            library = libraryDao.findLibraryByIdDao(libraryId);
            if (Objects.isNull(library)) {
                throw new BadRequestException("Library does not exist with Id: ".concat(String.valueOf(libraryId)));
            }
            libraryDto = libraryMappers.libraryEntityToGetLibraryDto(library);
            return libraryDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetLibraryDto> findLibraryListService() {
        List<LibraryEntity> libraryList = null;
        List<GetLibraryDto> libraryListDto = null;

        try {
            libraryList = libraryDao.findLibraryListDao();
            libraryListDto = libraryList.stream().map(libraryMappers::libraryEntityToGetLibraryDto).collect(Collectors.toList());

            return libraryListDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createLibraryService(CreateLibraryDto libraryDto) {
        CityEntity city = null;
        GetCityCountryDto cityCountryDto = null;

        try {
            city = cityDao.findCityByIdDao(libraryDto.getCityIdDto());
            if(Objects.isNull(city)){
                throw new BadRequestException("City does not exist with Id: ".concat(String.valueOf(libraryDto.getCityIdDto())));
            }
            cityCountryDto = cityMappers.cityEntityToGetCityCountryDto(city);
            libraryDao.createLibraryDao(libraryDto, cityCountryDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editLibraryService(EditLibraryDto libraryDto, Integer libraryId) {
        CityEntity city = null;
        GetCityCountryDto cityCountryDto = null;

        try {
            libraryDto.setLibraryIdDto(libraryId);

            city = cityDao.findCityByIdDao(libraryDto.getCityIdDto());
            if (Objects.isNull(city)) {
                throw new BadRequestException("City does not exist with id: ".concat(String.valueOf(libraryDto.getCityIdDto())));
            }
            cityCountryDto = cityMappers.cityEntityToGetCityCountryDto(city);

            libraryDao.editLibraryDao(libraryDto, cityCountryDto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createBookToLibraryService(Integer libraryId , List<GABookDto> bookList) {
        LibraryEntity library = null;
        try{
            library = libraryDao.findLibraryByIdDao(libraryId);
            if(Objects.isNull(library)){
                throw new BadRequestException("Library does not exist with id: ".concat(String.valueOf(libraryId)));
            }

            libraryDao.createBookToLibraryDao(libraryId, bookList);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}