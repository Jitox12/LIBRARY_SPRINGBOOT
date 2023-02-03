package com.library.microlibrary.mappers.cityMappers;

import com.library.microlibrary.dto.cityDto.GetCityCountryDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityEntityToGetCityCountryDtoMapper {

    CityEntityToGetCityCountryDtoMapper INSTANCE = Mappers.getMapper(CityEntityToGetCityCountryDtoMapper.class);

    @Mapping(source = "cityId", target = "cityIdDto")
    @Mapping(source = "cityName", target = "cityNameDto")
    @Mapping(source = "country", target = "countryDto")
    GetCityCountryDto cityEntityToGetCityDto(CityEntity city);
}
