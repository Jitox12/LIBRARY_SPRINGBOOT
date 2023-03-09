package com.library.microlibrary.dao.libraryDao;

import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.LibraryEntity;
import com.library.microlibrary.repositories.LibraryRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class LibraryDaoImpl implements LibraryDao{

    private final LibraryRepository libraryRepository;

    public LibraryDaoImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

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
    public void createLibraryDao(CreateLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException{
        LibraryEntity library ;
        CityEntity city ;

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .cityId(cityDto.getCityIdDto())
                .country(cityDto.getCountryDto())
                .build();
        System.out.println(cityDto.getCountryDto().getCountryName());
        library = LibraryEntity.builder()
                .libraryName(libraryDto.getLibraryNameDto())
                .city(city)
                .build();
        try{
            libraryRepository.save(library);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void editLibraryDao(EditLibraryDto libraryDto, GetCityCountryDto cityDto) throws IOException{
        LibraryEntity library = null;
        CityEntity city = null;

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

         libraryRepository.save(library);

    }
}
