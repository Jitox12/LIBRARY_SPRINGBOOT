package com.library.microlibrary.mappers.cityMappers;

import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityEntityToGetCityDtoMapper {
    CityEntityToGetCityDtoMapper INSTANCE = Mappers.getMapper(CityEntityToGetCityDtoMapper.class);

    @Mapping(source = "cityId", target = "cityId")
    @Mapping(source = "cityName", target = "cityName")
    GetCityDto cityEntityToGetCityDto(CityEntity city);
}
