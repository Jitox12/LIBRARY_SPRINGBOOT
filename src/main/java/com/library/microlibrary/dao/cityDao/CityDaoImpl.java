package com.library.microlibrary.dao.cityDao;

import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@AllArgsConstructor
@Component
public class CityDaoImpl implements CityDao{

    private final CityRepository cityRepository;

    @Override
    public CityEntity findCityByIdDao(Integer cityId) throws IOException {
        CityEntity city = cityRepository.findByCityId(cityId);
        return city;
    }

    @Override
    public List<CityEntity> findCityListDao() throws IOException {
        return null;
    }

    @Override
    public void createCityDao(CreateCityDto cityDto, GetCountryDto countryDto) throws IOException {

    }

    @Override
    public void editCityDao(EditCityDto cityDto, GetCountryDto countryDto) throws IOException {

    }
}
