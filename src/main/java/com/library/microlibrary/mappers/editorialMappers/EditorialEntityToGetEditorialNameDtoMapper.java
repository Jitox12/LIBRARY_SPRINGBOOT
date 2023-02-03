package com.library.microlibrary.mappers.editorialMappers;

import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.dto.editorialDto.EditEditorialDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.entities.EditorialEntity;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryNameDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EditorialEntityToGetEditorialNameDtoMapper {

    EditorialEntityToGetEditorialNameDtoMapper INSTANCE = Mappers.getMapper(EditorialEntityToGetEditorialNameDtoMapper.class);

    @Mapping(source = "editorialName", target = "editorialNameDto")
    GetEditorialDto editorialEntityToGetEditorialNameDto(EditorialEntity editorial);
}
