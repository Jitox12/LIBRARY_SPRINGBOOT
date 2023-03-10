package com.library.microlibrary.dao;


import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;

import java.io.IOException;
import java.util.List;

public interface CityDao {

    public CityEntity findCityByIdDao(Integer cityId) throws IOException;
    public List<CityEntity> findCityListDao() throws IOException;

    public CityEntity createCityDao(CreateCityDto cityDto, GetCountryDto countryDto) throws IOException;
    public CityEntity editCityDao(EditCityDto cityDto, GetCountryDto countryDto) throws IOException;
}
