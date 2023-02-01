package com.library.microlibrary.dao.cityDao;

import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class CityDaoImpl implements CityDao {

    private final CityRepository cityRepository;

    @Override
    public CityEntity findCityNameByIdDao(Integer cityId) throws IOException {
        CityEntity city = null;
        city = cityRepository.findCityNameByCityId(cityId);

        return city;
    }

    @Override
    public List<CityEntity> findCityNameListDao() throws IOException {
        List<CityEntity> cityList = null;
        cityList = cityRepository.findAll();

        return cityList;
    }

    @Override
    public CityEntity createCityDao(CreateCityDto cityDto, GetCountryDto countryDto) throws IOException {
        CityEntity city = null;
        CountryEntity country = null;
        CityEntity savedCity = null;

        country = CountryEntity.builder()
                .countryId(countryDto.getCountryIdDto())
                .countryName(countryDto.getCountryNameDto())
                .build();

        city = CityEntity.builder()
                .cityName(cityDto.getCityNameDto())
                .country(country)
                .build();
        savedCity = cityRepository.save(city);

        return savedCity;
    }

    @Override
    public CityEntity editCityDao(EditCityDto cityDto, GetCountryDto countryDto) throws IOException {
        CityEntity city = null;
        CountryEntity country = null;
        CityEntity editedCity = null;

        country = CountryEntity.builder()
                .countryId(countryDto.getCountryIdDto())
                .countryName(countryDto.getCountryNameDto())
                .build();

        city = CityEntity.builder()
                .cityId(cityDto.getCityIdDto())
                .cityName(cityDto.getCityNameDto())
                .country(country)
                .build();

        editedCity = cityRepository.save(city);

        return editedCity;
    }
}