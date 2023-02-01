package com.library.microlibrary.mappers.countryMappers;

import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryEntityToGetCountryDtoMapper {
    CountryEntityToGetCountryDtoMapper INSTANCE = Mappers.getMapper(CountryEntityToGetCountryDtoMapper.class);

    @Mapping(source = "countryId", target = "countryIdDto")
    @Mapping(source = "countryName", target = "countryNameDto")
    GetCountryDto countryEntityToGetCountryDto(CountryEntity country);

}
