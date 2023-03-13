package com.library.microlibrary.services.serviceImpl;

import com.library.microlibrary.dao.CityDao;
import com.library.microlibrary.dao.CountryDao;
import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.cityDto.GetCityNameDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.CityMappers;
import com.library.microlibrary.mappers.CountryMappers;
import com.library.microlibrary.services.CityService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    //DAO
    private final CityDao cityDao;
    private final CountryDao countryDao;

    //City Mappers
    private final CityMappers cityMappers;
    private final CountryMappers countryMappers;

    public CityServiceImpl(CityDao cityDao, CountryDao countryDao, CityMappers cityMappers, CountryMappers countryMappers) {
        this.cityDao = cityDao;
        this.countryDao = countryDao;
        this.cityMappers = cityMappers;
        this.countryMappers = countryMappers;
    }


    @Override
    public GetCityNameDto findCityNameByIdService(Integer cityId) {
        CityEntity city = null;
        GetCityNameDto cityName = null;

        try{
            city = cityDao.findCityByIdDao(cityId);

            if(Objects.isNull(city)){
                throw new BadRequestException("City Does not with Id: ".concat(String.valueOf(cityId)));
            }
            cityName = cityMappers.cityEntityToGetCityNameDto(city);

            return cityName;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetCityNameDto> findCityNameListService() {
        List<CityEntity> cityList = null;
        List<GetCityNameDto> cityNameListDto = null;

        try{
            cityList = cityDao.findCityListDao();
            cityNameListDto = cityList.stream().map(cityMappers::cityEntityToGetCityNameDto).collect(Collectors.toList());

            return cityNameListDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCityService(CreateCityDto cityDto) {
        CityEntity savedCity = null;
        GetCityDto savedCityDto = null;

        CountryEntity country = null;
        GetCountryDto countryDto = null;

        try{
            country = countryDao.findCountryByIdDao(cityDto.getCountryIdDto());
            if(Objects.isNull(country)){
                throw new BadRequestException("Country Does not with Id: ".concat(String.valueOf(cityDto.getCountryIdDto())));
            }
            countryDto = countryMappers.countryEntityToGetCountryDto(country);

            savedCity = cityDao.createCityDao(cityDto, countryDto);
            cityMappers.cityEntityToGetCityDto(savedCity);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editCityService(EditCityDto cityDto, Integer cityId) {
        CityEntity editedCity = null;
        GetCityDto editedCityDto = null;

        CountryEntity country = null;
        GetCountryDto countryDto = null;

        try{
            cityDto.setCityIdDto(cityId);

            country = countryDao.findCountryByIdDao(cityDto.getCountryIdDto());

            if(Objects.isNull(country)){
                throw new BadRequestException("Country does not exist with Id: ".concat(String.valueOf(cityDto.getCountryIdDto())));
            }
            countryDto = countryMappers.countryEntityToGetCountryDto(country);

            editedCity = cityDao.editCityDao(cityDto, countryDto);
            cityMappers.cityEntityToGetCityDto(editedCity);

        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}
