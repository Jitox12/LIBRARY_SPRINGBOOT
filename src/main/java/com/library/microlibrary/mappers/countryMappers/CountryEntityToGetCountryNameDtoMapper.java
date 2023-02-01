package com.library.microlibrary.mappers.countryMappers;

import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.entities.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryEntityToGetCountryNameDtoMapper {

    CountryEntityToGetCountryNameDtoMapper INSTANCE = Mappers.getMapper(CountryEntityToGetCountryNameDtoMapper.class);

    @Mapping(source = "countryName", target = "countryNameDto")
    GetCountryNameDto countryEntityToGetCountryNameDto(CountryEntity country);

}
