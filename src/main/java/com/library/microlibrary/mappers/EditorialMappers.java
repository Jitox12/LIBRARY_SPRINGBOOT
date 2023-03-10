package com.library.microlibrary.mappers;

import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.entities.EditorialEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EditorialMappers {
    EditorialMappers INSTANCE = Mappers.getMapper(EditorialMappers.class);

    default String CitytoCityName(CityEntity city) {
        return city.getCityName();
    }

    default String CountrytoCountryName(CountryEntity country) {
        return country.getCountryName();
    }

    @Mapping(source = "editorialId", target = "editorialIdDto")
    @Mapping(source = "editorialName", target = "editorialNameDto")
    @Mapping(source = "city", target = "cityNameDto")
    @Mapping(source = "city.country", target = "countryNameDto")
    GetEditorialDto editorialEntityToGetEditorialDto(EditorialEntity editorial);

    @Mapping(source = "editorialName", target = "editorialNameDto")
    GetEditorialDto editorialEntityToGetEditorialNameDto(EditorialEntity editorial);

}
