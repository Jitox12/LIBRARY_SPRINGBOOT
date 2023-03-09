package com.library.microlibrary.mappers.authorMappers;

import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface AuthorEntityToGetFullAuthorDtoMapper {
    AuthorEntityToGetFullAuthorDtoMapper INSTANCE = Mappers.getMapper(AuthorEntityToGetFullAuthorDtoMapper.class);

    default String CitytoCityName(CityEntity city) {
        return city.getCityName();
    }

    @Mapping(source = "authorName", target = "authorNameDto")
    @Mapping(source = "city", target = "cityDto")
    GetAuthorCityDto authorEntityToGetFullAuthorDto(AuthorEntity author);

}
