package com.library.microlibrary.services.serviceImpl;

import com.library.microlibrary.dao.CityDao;
import com.library.microlibrary.dao.CountryDao;
import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.CountryMappers;
import com.library.microlibrary.services.CountryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    //Dao's
    private final CountryDao countryDao;
    private final CityDao cityDao;

    //Mapper's
    private final CountryMappers countryMappers ;

    public CountryServiceImpl(CountryDao countryDao, CityDao cityDao, CountryMappers countryMappers) {
        this.countryDao = countryDao;
        this.cityDao = cityDao;
        this.countryMappers = countryMappers;
    }

    @Override
    public GetCountryNameDto findCountryNameByIdService(Integer countryId) {
        CountryEntity country = null;
        GetCountryNameDto countryNameDto = null;

        try {
            country = countryDao.findCountryNameByIdDao(countryId);

            if (Objects.isNull(country)) {
                throw new BadRequestException("Country is null");
            }

            countryNameDto = countryMappers.countryEntityToGetCountryNameDto(country);
            return countryNameDto;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetCountryNameDto> findCountryNameListService() {
        List<CountryEntity> country = null;
        List<GetCountryNameDto> countryNameDto = null;

        try {
            country = countryDao.findCountryListDao();
            countryNameDto = country.stream().map(countryMappers::countryEntityToGetCountryNameDto).collect(Collectors.toList());
            return countryNameDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GetCountryDto findCountryByIdService(Integer countryId) {
        return null;
    }

    @Override
    public List<GetCountryDto> findCountryListService() {
        return null;
    }

    @Override
    public void createCountryService(CreateCountryDto countryDto) {
        try {
            countryDao.createCountryDao(countryDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editCountryService(EditCountryDto countryDto, Integer countryId) {
        countryDto.setCountryIdDto(countryId);

        try {
            countryDao.editCountryDao(countryDto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


}