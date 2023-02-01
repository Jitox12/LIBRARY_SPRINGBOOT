package com.library.microlibrary.dao.cityDao;


import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;

import java.util.List;

public interface CityDao {

    public CityEntity findCityByIdDao(Integer cityId);
    public List<CityEntity> findCityListDao();
    public void createCityDao(CreateCityDto cityDto, GetCountryDto countryDto);
    public void editCityDao(EditCityDto cityDto, GetCountryDto countryDto);
}
