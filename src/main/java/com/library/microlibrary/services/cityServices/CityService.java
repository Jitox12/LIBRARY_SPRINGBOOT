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
    public String createCityService(CreateCityDto cityDto);
    public String editCityService(EditCityDto cityDto, Integer cityId);
}
