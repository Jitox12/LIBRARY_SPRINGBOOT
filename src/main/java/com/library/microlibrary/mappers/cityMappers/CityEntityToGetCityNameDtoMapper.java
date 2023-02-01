package com.library.microlibrary.mappers.cityMappers;

import com.library.microlibrary.dto.cityDto.GetCityNameDto;
import com.library.microlibrary.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityEntityToGetCityNameDtoMapper {

    CityEntityToGetCityNameDtoMapper INSTANCE = Mappers.getMapper(CityEntityToGetCityNameDtoMapper.class);

    @Mapping(source = "cityName", target = "cityNameDto")
    GetCityNameDto cityEntityToGetCityNameDto(CityEntity city);
}
