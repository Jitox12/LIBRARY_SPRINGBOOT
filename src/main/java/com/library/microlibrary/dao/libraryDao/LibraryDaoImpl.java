package com.library.microlibrary.dao.libraryDao;

import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.LibraryEntity;
import com.library.microlibrary.repositories.LibraryRepository;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Library;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class LibraryDaoImpl implements LibraryDao{

    private final LibraryRepository libraryRepository;

    @Override
    public LibraryEntity findLibraryByIdDao(Integer libraryId) throws IOException {
        LibraryEntity library = null;
        library = libraryRepository.findByLibraryId(libraryId);

        return library;
    }

    @Override
    public List<LibraryEntity> findLibraryListDao() throws IOException{
        List<LibraryEntity> libraryList = null;
        libraryList = libraryRepository.findAll();

        return libraryList;
    }

    @Override
    public LibraryEntity createLibraryDao(CreateLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException{
        LibraryEntity library = null;
        CityEntity city = null;

        LibraryEntity savedLibrary = null;

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .cityId(cityDto.getCityIdDto())
                .country(cityDto.getCountryDto())
                .build();

        library = LibraryEntity.builder()
                .libraryName(libraryDto.getLibraryNameDto())
                .city(city)
                .build();

        savedLibrary = libraryRepository.save(library);

        return savedLibrary;
    }

    @Override
    public LibraryEntity editLibraryDao(EditLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException{
        LibraryEntity library = null;
        CityEntity city = null;

        LibraryEntity editedLibrary = null;

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .cityId(cityDto.getCityIdDto())
                .country(cityDto.getCountryDto())
                .build();

        library = LibraryEntity.builder()
                .libraryId(libraryDto.getLibraryIdDto())
                .libraryName(libraryDto.getLibraryNameDto())
                .city(city)
                .build();

        editedLibrary = libraryRepository.save(library);

        return editedLibrary;
    }
}
