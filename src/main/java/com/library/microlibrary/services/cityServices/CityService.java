package com.library.microlibrary.services.cityServices;

import com.library.microlibrary.dto.cityDto.CreateCityDto;
import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityNameDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;

import java.util.List;

public interface CityService {

    public GetCityNameDto findCityNameByIdService(Integer cityId);
    public List<GetCityNameDto> findCityNameListService();
    public void createCityService(CreateCityDto cityDto);
    public void editCityService(EditCityDto cityDto, Integer cityId);
}
