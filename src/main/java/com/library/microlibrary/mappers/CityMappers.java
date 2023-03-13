package com.library.microlibrary.mappers;

import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.cityDto.GetCityNameDto;
import com.library.microlibrary.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMappers {

    CityMappers INSTANCE = Mappers.getMapper(CityMappers.class);

    @Mapping(source = "cityId", target = "cityIdDto")
    @Mapping(source = "cityName", target = "cityNameDto")
    @Mapping(source = "country", target = "countryDto")
    GetCityCountryDto cityEntityToGetCityCountryDto(CityEntity city);

    @Mapping(source = "cityId", target = "cityIdDto")
    @Mapping(source = "cityName", target = "cityNameDto")
    GetCityDto cityEntityToGetCityDto(CityEntity city);

    @Mapping(source = "cityName", target = "cityNameDto")
    GetCityNameDto cityEntityToGetCityNameDto(CityEntity city);

}
