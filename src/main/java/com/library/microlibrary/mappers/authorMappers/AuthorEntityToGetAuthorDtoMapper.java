package com.library.microlibrary.mappers.authorMappers;

import com.library.microlibrary.dto.authorDto.GetAuthorDto;
import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorEntityToGetAuthorDtoMapper {
    AuthorEntityToGetAuthorDtoMapper INSTANCE = Mappers.getMapper(AuthorEntityToGetAuthorDtoMapper.class);

    default String CitytoCityName(CityEntity city) {
        return city.getCityName();
    }

    @Mapping(source = "authorName", target = "authorNameDto")
    @Mapping(source = "city", target = "cityNameDto")
    GetAuthorDto authorEntityToGetAuthorDto(AuthorEntity author);
}
