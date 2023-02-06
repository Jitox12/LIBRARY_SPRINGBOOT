package com.library.microlibrary.services.cityServices;

import com.library.microlibrary.dao.cityDao.CityDao;
import com.library.microlibrary.dao.countryDao.CountryDao;
import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.cityDto.GetCityNameDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityDtoMapper;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityNameDtoMapper;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryDtoMapper;
import com.library.microlibrary.repositories.CityRepository;
import com.library.microlibrary.utils.returnTextUtils.cityReturnTextUtils.CityReturnTextUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService{

    //DAO
    private final CityDao cityDao;
    private final CountryDao countryDao;

    //City Mappers
    private final CityEntityToGetCityDtoMapper cityEntityToGetCityDtoMapper;
    private final CityEntityToGetCityNameDtoMapper cityEntityToGetCityNameDtoMapper;

    //Country Mappers
    private final CountryEntityToGetCountryDtoMapper countryEntityToGetCountryDtoMapper;

    @Override
    public GetCityNameDto findCityNameByIdService(Integer cityId) {
        CityEntity city = null;
        GetCityNameDto cityName = null;

        try{
            city = cityDao.findCityByIdDao(cityId);

            if(Objects.isNull(city)){
                throw new BadRequestException("City Does not with Id: ".concat(String.valueOf(cityId)));
            }
            cityName = cityEntityToGetCityNameDtoMapper.cityEntityToGetCityNameDto(city);

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
            cityNameListDto = cityList.stream().map(cityEntityToGetCityNameDtoMapper::cityEntityToGetCityNameDto).collect(Collectors.toList());

            return cityNameListDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createCityService(CreateCityDto cityDto) {
        CityEntity savedCity = null;
        GetCityDto savedCityDto = null;

        CountryEntity country = null;
        GetCountryDto countryDto = null;
        String returnText = null;

        try{
            country = countryDao.findCountryByIdDao(cityDto.getCountryIdDto());
            if(Objects.isNull(country)){
                throw new BadRequestException("Country Does not with Id: ".concat(String.valueOf(cityDto.getCountryIdDto())));
            }
            countryDto = countryEntityToGetCountryDtoMapper.countryEntityToGetCountryDto(country);

            savedCity = cityDao.createCityDao(cityDto, countryDto);
            savedCityDto = cityEntityToGetCityDtoMapper.cityEntityToGetCityDto(savedCity);

            returnText = CityReturnTextUtil.createCityText(savedCityDto, countryDto);

            return returnText;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String editCityService(EditCityDto cityDto, Integer cityId) {
        CityEntity editedCity = null;
        GetCityDto editedCityDto = null;

        CountryEntity country = null;
        GetCountryDto countryDto = null;

        String returnText = null;

        try{
            cityDto.setCityIdDto(cityId);

            country = countryDao.findCountryByIdDao(cityDto.getCountryIdDto());

            if(Objects.isNull(country)){
                throw new BadRequestException("Country does not exist with Id: ".concat(String.valueOf(cityDto.getCountryIdDto())));
            }
            countryDto = countryEntityToGetCountryDtoMapper.countryEntityToGetCountryDto(country);

            editedCity = cityDao.editCityDao(cityDto, countryDto);
            editedCityDto = cityEntityToGetCityDtoMapper.cityEntityToGetCityDto(editedCity);

            returnText = CityReturnTextUtil.editCityText(editedCityDto, countryDto);

            return returnText;
        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}
