package com.library.microlibrary.services.libraryServices;

import com.library.microlibrary.dao.cityDao.CityDao;
import com.library.microlibrary.dao.libraryDao.LibraryDao;
import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.libraryDto.CreateLibraryDto;
import com.library.microlibrary.dto.libraryDto.EditLibraryDto;
import com.library.microlibrary.dto.libraryDto.GetLibraryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.LibraryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityCountryDtoMapper;
import com.library.microlibrary.mappers.libraryMappers.LibraryEntityToGetLibraryDtoMapper;
import com.library.microlibrary.utils.returnTextUtils.libraryTextUtils.LibraryReturnTextUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LibraryServiceImpl implements LibraryService {

    //DAO
    private final LibraryDao libraryDao;
    private final CityDao cityDao;

    //MAPPERS
    private final LibraryEntityToGetLibraryDtoMapper libraryEntityToGetLibraryDtoMapper;
    private final CityEntityToGetCityCountryDtoMapper cityEntityToGetCityCountryDtoMapper;

    @Override
    public GetLibraryDto findLibraryByIdService(Integer libraryId) {
        LibraryEntity library = null;
        GetLibraryDto libraryDto = null;

        try {
            library = libraryDao.findLibraryByIdDao(libraryId);
            if (Objects.isNull(library)) {
                throw new BadRequestException("Library does not exist with Id: ".concat(String.valueOf(libraryId)));
            }
            libraryDto = libraryEntityToGetLibraryDtoMapper.libraryEntityToGetLibraryDto(library);
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
            libraryListDto = libraryList.stream().map(libraryEntityToGetLibraryDtoMapper::libraryEntityToGetLibraryDto).collect(Collectors.toList());

            return libraryListDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createLibraryService(CreateLibraryDto libraryDto) {
        LibraryEntity savedLibrary = null;
        CityEntity city = null;

        GetLibraryDto savedLibraryDto = null;
        GetCityCountryDto cityCountryDto = null;


        String returnText = null;

        try {
            city = cityDao.findCityByIdDao(libraryDto.getCityIdDto());
            if (Objects.isNull(city)) {
                throw new BadRequestException("City does not exist with id: ".concat(String.valueOf(libraryDto.getCityIdDto())));
            }
            cityCountryDto = cityEntityToGetCityCountryDtoMapper.cityEntityToGetCityDto(city);

            savedLibrary = libraryDao.createLibraryDao(libraryDto, cityCountryDto);
            savedLibraryDto = libraryEntityToGetLibraryDtoMapper.libraryEntityToGetLibraryDto(savedLibrary);

            returnText = LibraryReturnTextUtil.createLibraryText(savedLibraryDto);

            return returnText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String editLibraryService(EditLibraryDto libraryDto, Integer libraryId) {
        LibraryEntity editedLibrary = null;
        CityEntity city = null;

        GetLibraryDto editedLibraryDto = null;
        GetCityCountryDto cityCountryDto = null;


        String returnText = null;

        try {
            libraryDto.setLibraryIdDto(libraryId);

            city = cityDao.findCityByIdDao(libraryDto.getCityIdDto());
            if (Objects.isNull(city)) {
                throw new BadRequestException("City does not exist with id: ".concat(String.valueOf(libraryDto.getCityIdDto())));
            }
            cityCountryDto = cityEntityToGetCityCountryDtoMapper.cityEntityToGetCityDto(city);

            editedLibrary = libraryDao.editLibraryDao(libraryDto, cityCountryDto);
            editedLibraryDto = libraryEntityToGetLibraryDtoMapper.libraryEntityToGetLibraryDto(editedLibrary);

            returnText = LibraryReturnTextUtil.editLibraryText(editedLibraryDto);

            return returnText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
