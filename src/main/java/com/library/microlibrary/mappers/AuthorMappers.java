package com.library.microlibrary.mappers;

import com.library.microlibrary.dto.authorDto.GetAuthorCityDto;
import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMappers {
    AuthorMappers INSTANCE = Mappers.getMapper(AuthorMappers.class);

    default String CitytoCityName(CityEntity city) {
        return city.getCityName();
    }

    @Mapping(source = "authorName", target = "authorNameDto")
    @Mapping(source = "city", target = "cityNameDto")
    GetAuthorDto authorEntityToGetAuthorDto(AuthorEntity author);

    @Mapping(source = "authorId", target = "authorIdDto")
    @Mapping(source = "authorName", target = "authorNameDto")
    @Mapping(source = "city", target = "cityDto")
    GetAuthorCityDto authorEntityToGetFullAuthorDto(AuthorEntity author);
}