package com.library.microlibrary.services.cityServices;

import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.entities.CityEntity;

import java.util.List;

public class CityServiceImpl implements CityService{
    @Override
    public CityEntity findCityByIdService(Integer cityId) {
        return null;
    }

    @Override
    public List<CityEntity> findCityListService() {
        return null;
    }

    @Override
    public void createCityService(CreateCityDto cityDto) {

    }

    @Override
    public void editCityService(EditCityDto cityDto, Integer cityId) {

    }
}
